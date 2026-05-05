package by.mts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public HomePage open() {
        driver.get(URL);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        closeCookieBanner();

        // Прокручиваем к блоку
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 1500);");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ждём, пока поля станут доступны
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-phone")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-sum")));
            System.out.println("Поля формы доступны");
        } catch (Exception e) {
            System.out.println("Поля формы НЕ найдены!");
        }

        return this;
    }

    private void closeCookieBanner() {
        try {
            By cookieButton = By.xpath("//button[contains(text(),'Принять') or contains(text(),'Согласен') or contains(text(),'ОК')]");
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
            button.click();
            System.out.println("Куки-баннер закрыт");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        } catch (TimeoutException e) {
            System.out.println("Куки-баннер не найден");
        }
    }

    public TopUpNoCommissionBlock topUpNoCommission() {
        return new TopUpNoCommissionBlock(driver);
    }
}