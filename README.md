
# Database Project

## Overview

This project is a database application designed to manage various entities such as artists, albums, customers, employees, invoices, playlists, and tracks. It includes both the backend implementation and the corresponding unit tests to ensure the integrity and functionality of the database operations.

## Project Structure

The project is organized into several key directories:

- **`src/main/java/edu/montana/csci/csci440/`**: Contains the main Java source files for the application, including models representing database entities, controllers for managing these entities, and utilities for database interaction.

- **`src/main/resources/`**: Includes configuration files and templates used in the application, such as `application.properties` and HTML templates for views.

- **`src/test/java/edu/montana/csci/csci440/`**: Contains unit tests for the various models and functionalities provided by the application.

- **`DEMO_SCRIPT.md`**: A markdown file providing a demo script to showcase the application's capabilities.

- **`pom.xml`**: The Maven project file, which manages dependencies and builds configurations.

- **`.git/`**: Git repository metadata for version control.

- **`.gitignore`**: Specifies files and directories that should be ignored by Git.

- **`.project`**: Eclipse IDE project configuration file.

## Prerequisites

To run this project, you need to have the following installed:

- **Java JDK 8 or higher**
- **Maven**
- **Git**

## Setup Instructions

1. **Clone the Repository**:
    ```bash
    git clone <repository-url>
    cd Databases
    ```

2. **Build the Project**:
    Navigate to the root directory of the project and run the following Maven command to compile and package the application:
    ```bash
    mvn clean install
    ```

3. **Run the Application**:
    You can run the application using the following Maven command:
    ```bash
    mvn spring-boot:run
    ```

4. **Access the Application**:
    Once the application is running, you can access it in your web browser at `http://localhost:8080`.

## Detailed Description

### 1. Models (`src/main/java/edu/montana/csci/csci440/model/`)

The models represent the database entities, such as `Album`, `Artist`, `Customer`, `Employee`, `Invoice`, `Playlist`, and `Track`. Each model corresponds to a table in the database and includes fields representing columns in these tables.

### 2. Controllers (`src/main/java/edu/montana/csci/csci440/controller/`)

The controllers manage the application's logic, handling HTTP requests and interacting with the models to perform CRUD (Create, Read, Update, Delete) operations.

### 3. Utilities (`src/main/java/edu/montana/csci/csci440/util/`)

Utilities include helper classes for database interaction, such as connection management and query execution.

### 4. Templates (`src/main/resources/templates/`)

This directory contains HTML templates used to render the user interface for various entities, such as invoices, playlists, and tracks.

### 5. Configuration Files (`src/main/resources/`)

- **`application.properties`**: Contains configuration settings for the application, such as database connection details.

### 6. Unit Tests (`src/test/java/edu/montana/csci/csci440/`)

The test classes provide unit tests for the models and other functionalities, ensuring the integrity of the application's core components.

## Running Tests

To run the unit tests, use the following Maven command:
```bash
mvn test
```

The test results will be displayed in the console, and you can find detailed reports in the `target/surefire-reports` directory.

## Demo Script

Refer to the `DEMO_SCRIPT.md` file for a step-by-step guide to demonstrating the application's key features.

## Contribution

If you want to contribute to this project, please fork the repository and submit a pull request. Ensure that your code follows the project's coding standards and passes all unit tests.
