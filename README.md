# CSCI 440 - Database Systems

## Project: Chinook Web App

You will be implementing a web application against a SQL store, found in `/db/chinook.db`

The web application will be an open-ended project, but must include the following:

* All entities in the chinookdb must be surfaced in the web application
* The Employee entity must have all CRUD operations surfaced
* A tree UI of the Employee hierarchy
* Track search with at least two inputs must be implemented
* At least one report-like page must exist that makes use of a `GROUP BY` clause
* Implement at least one Redis cache

### Project Rubric

The project will be largely graded via automated tests.  The grading will be broken down along the following lines:

* 75.4% - The automated test suite (if the test suite passes, you are guaranteed to get a C on the project)
* 15% - A recorded demo, demonstrating the following functionality
  * Navigating the core entities in the database
  * CRUD operations on the Employee entity
  * Track search
  * Paging implemented in the Track main view 
  * A Group By based report page
* 10% - Code quality and satisfaction of the Redis cache, determined by manual inspection
* .1% - At least one use of htmx (https://htmx.org) in the application to add dynamic AJAX behavior

### Project Resources

* [Spark Java Docs](http://sparkjava.com/documentation)
* [Velocity Templates Docs](https://velocity.apache.org/engine/2.2/user-guide.html#loops)
* [Active JDBC Docs](https://javalite.io/activejdbc)
