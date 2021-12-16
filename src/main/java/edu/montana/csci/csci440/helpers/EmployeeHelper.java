package edu.montana.csci.csci440.helpers;

import edu.montana.csci.csci440.model.Employee;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EmployeeHelper {
    public static String makeEmployeeTree() {

        Employee employee = new Employee();
        Map<Long, List<Employee>> employeeMap = new HashMap<>();
        List<Employee> employees = Employee.all();

        for (Employee emp : employees) {
            if (employeeMap.containsKey(emp.getReportTo())) {
                List<Employee> currentReportsTo = employeeMap.get(emp.getReportTo());
                currentReportsTo.add(emp);
                employeeMap.put(emp.getReportTo(), currentReportsTo);
            } else {
                if (emp.getReportTo() != 0) {
                    List<Employee> empList = new LinkedList<>();
                    empList.add(emp);
                    employeeMap.put(emp.getReportTo(), empList);
                }
            }
            if (emp.getEmployeeId() == 1) {
                employee = emp;
            }
        }
        return "<ul>" + makeTree(employee, employeeMap) + "</ul>";
    }

    public static String makeTree(Employee employee, Map<Long, List<Employee>> employeeMap) {
        String list = "<li><a href='/employees/" + employee.getEmployeeId() + "'>"
                + employee.getEmail() + "</a><ul>";
        List<Employee> reports = employeeMap.get(employee.getEmployeeId());

        if (reports != null) {
            for (Employee report : reports) {
                list += makeTree(report, employeeMap);
            }
        }

        return list + "</ul></li>";
    }
}