```markdown
# my-qa-project - QA Automation Framework

## Overview

This project is a comprehensive QA automation framework built with Java and Selenium. It's designed to automate both UI functional tests using Selenium WebDriver and REST API tests. Key features include robust reporting with Allure, detailed logging using Log4j2, and efficient test execution via Maven and TestNG. This framework provides a solid foundation for building scalable and maintainable automated test suites.

## Table of Contents

- Prerequisites
- Project Setup
- Running Tests
- Reporting
- Logging
- IDE Setup
- Version Control (GitHub)
- CI/CD (GitHub Actions)

## Prerequisites

-   **Java Development Kit (JDK):** Version 11 or higher is recommended.
-   **Apache Maven:** Version 3.6.x or later.
-   **Browsers:** Install the browsers you wish to test against (e.g., Chrome, Firefox, Edge). The project utilizes `WebDriverManager` to automatically handle downloading and managing WebDriver executables, so manual download is usually not required.

## Project Setup

1.  **Clone the repository:**
    ```bash
    git clone <repository_url>
    cd my-qa-project
    ```

2.  **Build the project with Maven:**
    ```bash
    mvn clean install
    ```
    This command cleans the project, downloads all necessary dependencies (including Selenium, TestNG, RestAssured, Allure adapters, Log4j2), compiles the source code, and packages the project. By default, Maven's Surefire plugin might be configured to run tests during the `install` phase; check the `pom.xml` configuration.

3.  **Environment Variables / Configuration:**
    -   Project-specific configurations (like base URLs for UI and API, credentials, browser type, etc.) are typically managed via a properties file, e.g., `src/test/resources/config.properties`. Update this file with your environment details.
    -   Alternatively, configurations can be passed via system properties when running tests (see "Running Tests" section).

## Running Tests

Tests are executed using Maven and TestNG.

-   **Run all tests:**
    ```bash
    mvn test
    ```
    This command executes tests included in the default Surefire plugin configuration in `pom.xml`, which typically points to `src/test/resources/testng.xml`.

-   **Run a specific TestNG suite XML file:**
    ```bash
    mvn test -Dsurefire.suiteXmlFiles=src/test/resources/alternative-testng-suite.xml
    ```
    Replace `alternative-testng-suite.xml` with the path to your desired TestNG XML file. The `testng.xml` file in `src/test/resources` is usually the primary suite definition.

-   **Run a specific test class:**
    ```bash
    mvn test -Dtest=com.mycompany.qa.test.ui.LoginPageTest
    ```
    Replace `com.mycompany.qa.test.ui.LoginPageTest` with the fully qualified name of the test class you want to run.

-   **Run a specific test method within a class:**
    ```bash
    mvn test -Dtest=com.mycompany.qa.test.api.UserApiTest#testCreateUser
    ```
    Replace the class and method name accordingly.

-   **Passing system properties (e.g., environment):**
    ```bash
    mvn test -Denvironment=staging -Dbrowser=firefox
    ```
    These properties can be read within your tests to configure the execution environment or browser.

## Reporting

This framework uses Allure TestNG for rich, interactive test reporting.

-   The necessary Allure TestNG adapter and Allure Maven plugin are configured in the project's `pom.xml`.
-   After running tests (`mvn test`), Allure results are generated in the `target/allure-results/` directory.
-   **Generate the Allure HTML report:**
    ```bash
    mvn allure:report
    ```
    This processes the results and creates the HTML report files in `target/site/allure-maven/`.
-   **Serve (open) the report in your browser:**
    ```bash
    mvn allure:serve
    ```
    This command generates the report and automatically opens it in your default web browser, running a small web server.

## Logging

Logging is implemented using Log4j2, configured via the `src/main/resources/log4j2.xml` file.

-   By default, logs are directed to the console and written to files in the `logs/` directory (`app.log` for general logs and `error.log` for errors).
-   You can configure log levels and appenders in `log4j2.xml`.
-   To use the logger in your Java classes:
    ```java
    import org.apache.logging.log4j.LogManager;
    import org.apache.logging.log4j.Logger;

    public class YourClass {
        private static final Logger logger = LogManager.getLogger(YourClass.class);

        // ... use logger.info(), logger.debug(), logger.error(), etc.
    }
    ```

## IDE Setup

-   **IntelliJ IDEA (Recommended):**
    -   Open the project by selecting the `pom.xml` file. IntelliJ will recognize it as a Maven project and import dependencies.
    -   Ensure the TestNG plugin is enabled (it's usually bundled).
    -   Install the "Allure IntelliJ Plugin" from the JetBrains Plugin Marketplace for convenient viewing of Allure reports directly within the IDE.
-   **Eclipse IDE for Java Developers:**
    -   Import the project as "Existing Maven Projects".
    -   Install the TestNG plugin from the Eclipse Marketplace.

## Version Control (GitHub)

The project is intended to be managed with Git and hosted on GitHub.

1.  **Initialize a Git repository (if not cloned):**
    ```bash
    git init
    ```
2.  **Add files to staging:**
    ```bash
    git add .
    ```
    (Ensure a proper `.gitignore` file is present to exclude build artifacts, logs, IDE files, etc.)
3.  **Commit changes:**
    ```bash
    git commit -m "Initial commit"
    ```
4.  **Link to GitHub repository and push:**
    ```bash
    git remote add origin <your_github_repo_url>
    git branch -M main
    git push -u origin main
    ```

## CI/CD with GitHub Actions

A GitHub Actions workflow is configured in `.github/workflows/main.yml`. This workflow automates the build and test process on pushes or pull requests.

-   The workflow sets up the Java JDK and configures Maven.
-   It caches Maven dependencies to speed up subsequent runs.
-   It builds the project and runs all tests using `mvn -B clean test` (the `-B` flag is for batch mode, non-interactive).
-   After test execution, it uploads the generated Allure results (`target/allure-results`) as a workflow artifact. You can then use another job or download the artifact and generate the report locally using `mvn allure:serve`.

---
This README was generated by the QA Automation Project Generator. Ensure all paths and commands are verified and updated to match your specific project implementation.
```