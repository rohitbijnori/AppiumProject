
# Appium Automation Framework

A Java-based mobile test automation framework built using Appium, TestNG, and Maven for automating Android and iOS applications.

## Technologies Used

- **Java** – Programming language
- **Appium** – Mobile application automation
- **TestNG** – Test execution and test management
- **Maven** – Dependency management and build tool
- **Selenium WebDriver** – WebDriver APIs used by Appium
- **Git & GitHub** – Version control and collaboration
- **Extent Reports / Allure** – Test reporting (if configured)

## Framework Features

- Automated mobile application test execution
- TestNG annotations and assertions
- Maven-based dependency management
- Reusable utility methods
- Page Object Model (POM), if implemented
- Android and iOS support, if configured
- Test execution and reporting integration, if configured

## Prerequisites

Install the following tools before running the tests:

1. Java JDK
2. Eclipse IDE
3. Maven
4. Node.js and Appium Server
5. Android Studio and Android SDK for Android testing
6. Xcode for iOS testing on macOS
7. Appium drivers required for your target platforms

## Setup Instructions

1. Clone the repository:

   ```bash
   git clone https://github.com/rohitbijnori/AppiumProject.git
   ```

2. Import the project into Eclipse as an existing Maven project.

3. Configure the Java JDK, Android SDK, and Appium environment as required.

4. Install project dependencies:

   ```bash
   mvn clean install
   ```

5. Start the Appium server and connect the required emulator, simulator, or device.

## Execute Tests

Run the configured TestNG test suite using:

```bash
mvn test
```

If your project uses a specific TestNG XML suite, configure Maven to run that suite or execute the XML file directly from Eclipse.

## Repository

GitHub: https://github.com/rohitbijnori/AppiumProject

## Author

Rohit Kumar
