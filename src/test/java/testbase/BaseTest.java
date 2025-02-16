package testbase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.thoughtworks.gauge.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Locale;

public class BaseTest {

    private static final String BROWSER = "chrome";  // Here you can type the browser you want to use.
    public static WebDriver driver;
    protected static Actions actions;
    private Logger logger = LoggerFactory.getLogger(BaseTest.class);
    private static final String OS = System.getProperty("os.name").toLowerCase(Locale.ROOT);
    private static ExtentTest extentTest;
    private static ExtentTest extentTestScenarios;
    private static ExtentReports extentReports;
    private static final String PROJECT_ROOT = System.getProperty("user.dir");
    private static final String REPORT_PATH = PROJECT_ROOT + "/reports/extent-report.html";

    @BeforeSuite
    public void reportConfig() {
        try {
            Files.createDirectories(Paths.get(PROJECT_ROOT + "/reports"));
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(REPORT_PATH);

            extentSparkReporter.config().setTheme(Theme.DARK);
            extentSparkReporter.config().setDocumentTitle("Testinium Promote Project");
            extentSparkReporter.config().setReportName("CatchyLabs Automation Report");
            extentSparkReporter.config().setTimeStampFormat("[dd/MM/yyyy] - [HH:mm:ss]");
            extentSparkReporter.config().setEncoding("UTF-8");

            extentReports.attachReporter(extentSparkReporter);
            extentReports.setSystemInfo("OS", System.getProperty("os.name"));
            extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));

        } catch (IOException e) {
            logger.error("Failed to set report config or create file directory.", e);
        }
    }

    @BeforeSpec
    public void beforeSpec(ExecutionContext context) {
        extentTest = extentReports.createTest(context.getCurrentSpecification().getName());
    }

    @BeforeScenario
    public void startDriver(ExecutionContext context) {

        extentTestScenarios = extentTest.createNode(context.getCurrentScenario().getName());

        if (BROWSER.equalsIgnoreCase("safari") && !OS.contains("mac")) {
            throw new RuntimeException("Safari sadece macOS'ta çalışır!");
        }

        switch (BROWSER.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-translate");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "safari":
                driver = new SafariDriver();
                break;

            default:
                throw new IllegalArgumentException("Invalid Browser Parameter " + BROWSER);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        actions = new Actions(driver);
    }

    @BeforeStep
    public void beforeStep(ExecutionContext context) {
        if (extentTestScenarios != null) {
            extentTestScenarios.info("Running test step -> " + context.getCurrentStep().getText());
        }
    }

    @AfterStep
    public void afterStep(ExecutionContext context) {
        if (context.getCurrentStep().getIsFailing()) {
            extentTestScenarios.fail("Failed Test Step -> " + context.getCurrentStep().getText());
        }
    }


    @AfterScenario
    public void afterSenario(ExecutionContext context) {
        try {
            if (context.getCurrentScenario().getIsFailing()) {
                extentTestScenarios.fail("Failed Scenario -> " + context.getCurrentScenario().getTags());
            }
        } finally {
            driver.quit();
        }
    }

    public static ExtentTest getLog() {
        return extentTestScenarios;
    }

    @AfterSuite
    public void afterSuite() {
        if (extentReports != null) {
            try {
                extentReports.flush();
            } catch (Exception e) {
                logger.error("FAIL : Report Could Not Be Generated ", e);
            }
        }
    }

}
