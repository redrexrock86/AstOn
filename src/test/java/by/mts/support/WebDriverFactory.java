package by.mts.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public final class WebDriverFactory {
    private WebDriverFactory() {}

    public static WebDriver create() {
        String browser = env("MTS_BROWSER", "chrome").toLowerCase();
        boolean headless = Boolean.parseBoolean(env("MTS_HEADLESS", "true"));

        WebDriver driver;
        if ("firefox".equals(browser)) {
            driver = new FirefoxDriver(firefoxOptions(headless));
        } else if ("chrome".equals(browser)) {
            driver = new ChromeDriver(chromeOptions(headless));
        } else {
            throw new IllegalArgumentException("Unsupported MTS_BROWSER: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;
    }

    private static ChromeOptions chromeOptions(boolean headless) {
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--window-size=1440,900");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        return options;
    }

    private static FirefoxOptions firefoxOptions(boolean headless) {
        FirefoxOptions options = new FirefoxOptions();
        if (headless) {
            options.addArguments("-headless");
        }
        return options;
    }

    private static String env(String name, String defaultValue) {
        String v = System.getenv(name);
        return (v == null || v.isBlank()) ? defaultValue : v;
    }
}

