package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {}

    public static void initializeDriver() {

        String browser = ConfigReader.getProperty("browser").toLowerCase();
        boolean headless = ConfigReader.getBooleanProperty("headless");

        Log.info("Opening " + browser + " browser. Headless execution is set to " + headless + ".");

        switch (browser) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--disable-gpu");
                }
                driver.set(new ChromeDriver(chromeOptions));
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("-headless");
                }
                driver.set(new FirefoxDriver(firefoxOptions));
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headless) {
                    edgeOptions.addArguments("--headless=new");
                    edgeOptions.addArguments("--disable-gpu");
                }
                driver.set(new EdgeDriver(edgeOptions));
                break;

            default:
                throw new RuntimeException(
                        "Unsupported browser: " + browser +
                                ". Supported browsers are: chrome, firefox, edge"
                );
        }

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(
                Duration.ofSeconds(ConfigReader.getIntProperty("implicitWait")));
        getDriver().manage().timeouts().scriptTimeout(
                Duration.ofSeconds(ConfigReader.getIntProperty("scriptTimeout")));
        getDriver().manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(ConfigReader.getIntProperty("pageLoadTimeout")));
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            initializeDriver();
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            Log.info("Closing browser.");
            driver.get().quit();
            driver.remove();
        }
    }
}