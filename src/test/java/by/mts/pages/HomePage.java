package by.mts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class HomePage {
    private static final String URL = "https://mts.by/";

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cookieAcceptButton = By.xpath(
            "//button[normalize-space()='Принять' or normalize-space()='Согласен' or normalize-space()='ОК']"
    );

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public HomePage open() {
        driver.get(URL);
        closeCookieIfPresent();
        return this;
    }

    public TopUpNoCommissionBlock topUpNoCommission() {
        return new TopUpNoCommissionBlock(driver);
    }

    private void closeCookieIfPresent() {
        try {
            WebElement btn = wait.withTimeout(Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
            btn.click();
        } catch (TimeoutException ignored) {

        }
    }
}

