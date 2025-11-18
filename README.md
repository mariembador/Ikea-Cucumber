# Cucumber Final Project (Selenium + Cucumber + TestNG)

End-to-end UI test automation framework for IKEA Egypt using Selenium WebDriver, Cucumber (Gherkin), and TestNG. It follows a Page Object Model structure and runs on Microsoft Edge with an AdBlock extension to reduce flakiness from ads/popups.

## Description

This project automates key user journeys on the IKEA Egypt website using Selenium WebDriver with Cucumber (Gherkin) and TestNG. It follows the Page Object Model for maintainability, uses WebDriverManager for driver setup, and JavaFaker for realistic test data. Tests run on Microsoft Edge with an AdBlock extension to reduce popups and ad-related flakiness, and generate an HTML report at target/report.html.

## Tech stack

- Java 23 (per `pom.xml`)
- Maven (dependency and build management)
- Selenium 4.27.0
- Cucumber JVM 7.20.1 (`cucumber-java`, `cucumber-testng`)
- TestNG (via `AbstractTestNGCucumberTests`)
- WebDriverManager 5.9.2 (automatic EdgeDriver management)
- JavaFaker 1.0.2 (random realistic test data)

## Project structure

```
CucumberFinalProject/
├─ pom.xml
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  │  └─ org/example/Main.java
│  │  └─ resources/
│  │     ├─ Features/
│  │     │  ├─ checkout.feature
│  │     │  ├─ products.feature
│  │     │  ├─ register.feature
│  │     │  └─ search.feature
│  │     ├─ AdBlock-—-block-ads-across-the-web-Chrome-Web-Store.crx
│  │     └─ AdBlock-bloquea-anuncios-en-la-web-Chrome-Web-Store.crx
│  └─ test/
│     └─ java/
│        └─ org/example/
│           ├─ pages/              # Page Object classes
│           ├─ stepsDefs/          # Cucumber step definitions (incl. Hooks)
│           └─ testRunner/         # Cucumber TestNG runner
└─ target/
   └─ report.html                  # Cucumber HTML report (generated)
```

Key files:
- `src/test/java/org/example/testRunner/runners.java` — Cucumber TestNG runner. Generates HTML report at `target/report.html`.
- `src/test/java/org/example/stepsDefs/Hooks.java` — WebDriver setup/teardown. Uses Edge + AdBlock extension and navigates to the base URL.
- `src/main/resources/Features/*.feature` — Gherkin feature files.

## Prerequisites

- Windows with Microsoft Edge installed
- JDK 23 (to match `maven.compiler.source/target`), or adjust the `pom.xml` to your installed JDK version
- Maven 3.9+
- Internet access (tests navigate to `https://www.ikea.com/eg/en/`)

Verify installations:

```cmd
java -version
mvn -version
```

## How to run

The project uses a TestNG-based Cucumber runner class. Because Maven’s default test includes may not match the class name `runners`, it’s safest to target it explicitly.

- Run all scenarios:

```cmd
mvn -Dtest=org.example.testRunner.runners test
```

- Run scenarios by tag (example: `@login`):

```cmd
mvn -Dtest=org.example.testRunner.runners -Dcucumber.filter.tags="@login" test
```

- Filter by scenario/feature name (regex supported):

```cmd
mvn -Dtest=org.example.testRunner.runners -Dcucumber.filter.name="Register Feature" test
```

- From IntelliJ/VS Code: open `runners.java` and run the class directly.

### Reports

On completion, an HTML report is generated at:
- `target/report.html`

Open it in a browser to review results.

## Browser and extension

- Browser: Microsoft Edge (managed by WebDriverManager)
- AdBlock extension: loaded to minimize ad-related flakiness
  - Primary CRX: `src/main/resources/AdBlock-—-block-ads-across-the-web-Chrome-Web-Store.crx`

Startup behavior in `Hooks`:
- Edge opens an extra tab for the extension’s welcome page; the code closes it and returns to the main tab.
- Base URL: `https://www.ikea.com/eg/en/`

### Customizing the run

Edit `src/test/java/org/example/stepsDefs/Hooks.java`:

- Change base URL:
  - Update the `driver.get("...")` line.
- Adjust waits:
  - `implicitlyWait(Duration.ofSeconds(10))` and the explicit `WebDriverWait` can be tuned as needed.
- Headless mode (optional):
  - Add `options.addArguments("--headless=new")` before creating the `EdgeDriver`.
- Switch browsers (optional):
  - Replace `EdgeOptions/EdgeDriver/WebDriverManager.edgedriver()` with the equivalent for Chrome or Firefox.

## Tags

You can tag scenarios in feature files (e.g., `@login`) and run a subset using `-Dcucumber.filter.tags="@tag"`.

Examples from `register.feature`:
- `@login` — used to group registration/login scenarios.

## Troubleshooting

- Tests don’t run with just `mvn test`:
  - Use `-Dtest=org.example.testRunner.runners` to target the TestNG runner class.
- Edge/driver issues:
  - Ensure Microsoft Edge is installed and up to date.
  - WebDriverManager downloads drivers automatically; clear its cache if needed (user home `~/.cache/selenium` or `%USERPROFILE%\.cache\selenium`).
- Extension errors:
  - Ensure the CRX file path in `Hooks` matches the location under `src/main/resources`.
- Java version mismatch:
  - Either install JDK 23 or change `maven.compiler.source/target` in `pom.xml` to your installed JDK.
- Flaky navigation due to ads/popups:
  - AdBlock is loaded to reduce noise; verify the extra tab is closed as implemented in `Hooks`.

## Extending the suite

- Add new scenarios in `src/main/resources/Features/*.feature`.
- Implement steps in `src/test/java/org/example/stepsDefs/`.
- Add/update Page Objects in `src/test/java/org/example/pages/`.

## License

This project is provided as-is for learning and demonstration purposes.

