#  Selenium Automation Framework (Java + TestNG)

This project is a **scalable Selenium Automation Framework** built using **Java, TestNG, and Maven**, designed with industry-level practices like **Page Object Model, Data-Driven Testing, Retry Mechanism, Reporting, and CI/CD integration**.

---

##  Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Extent Reports
- Apache POI (Excel)
- Jackson (JSON)
- GitHub Actions (CI/CD)

---

##  Framework Design

This framework follows a **modular and scalable architecture**:


src
└── test/java/com/pravin/automation
├── base → Driver & BaseTest setup
├── pages → Page Object Model classes
├── tests → Test classes
├── testdata → DataProviders (Excel, JSON, Map, Array)
├── utils → ConfigReader, Screenshot, Excel utils
├── listeners → TestNG Listeners (Reporting, Logging)
└── retry → Retry Analyzer for flaky tests


---

##  Key Features

###  1. Page Object Model (POM)
- Clean separation of UI and test logic
- Reusable page methods

###  2. Data-Driven Testing
Supports multiple data sources:
- Array-based DataProvider
- Map-based DataProvider (flexible & scalable)
- Excel DataProvider
- JSON DataProvider

---

###  3. Retry Mechanism
- Failed tests automatically retried using `IRetryAnalyzer`
- Helps handle flaky test scenarios

---

###  4. Listener Implementation
- Custom TestNG Listener used for:
  - Logging
  - Screenshot capture
  - Report integration

---

###  5. Extent Reporting
- Detailed HTML reports
- Includes:
  - Pass/Fail status
  - Screenshots on failure
  - Retry tracking (flaky detection)

---

###  6. Parallel Execution
- Thread-safe execution using ThreadLocal WebDriver
- Configurable via TestNG XML

---

###  7. Environment Handling
- Config-driven setup (browser, URL, headless mode)
- No hardcoded values

---

###  8. CI/CD Integration (GitHub Actions)
- Tests automatically run on every push
- Supports headless execution in CI environment

---

##  How to Run Tests

###  Run Locally

```bash
mvn clean test
** Run via TestNG XML
testng.xml
** Run Specific Groups
<groups>
    <run>
        <include name="smoke"/>
    </run>
</groups>

## Sample Test Scenarios
Login validation (valid / invalid)
Text input validation
Button click validation
Checkbox selection

## Error message validation
** Reporting

After execution:
/test-output/ExtentReport.html


##  Challenges Solved
Handled ElementClickInterceptedException using explicit waits & safe click
Stabilized tests for CI environment (headless execution)
Fixed parallel execution issues using ThreadLocal
Implemented retry + reporting integration for flaky tests


## Key Learnings
Difference between local vs CI execution behavior
Importance of synchronization in Selenium
Thread safety in parallel execution
Clean framework design vs messy implementation
Debugging pipeline failures using logs


## Future Improvements
Docker integration
Selenium Grid setup
Allure reporting
API + UI combined testing

## Author
Pravin Kolkar
Automation QA Engineer (SDET Track)
pravinkolkar06@gmail.com
