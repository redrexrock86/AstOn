package by.mts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class TopUpNoCommissionBlock {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public TopUpNoCommissionBlock(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try { Thread.sleep(500); } catch (InterruptedException e) {}
    }

    public boolean isBlockDisplayed() {
        try {
            By title = By.xpath("//h2[contains(text(),'Онлайн пополнение')]");
            return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getTitleText() {
        By title = By.xpath("//h2[contains(text(),'Онлайн пополнение')]");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return element.getText().replace("\n", " ").trim();
    }

    public String getPhonePlaceholder() {
        By locator = By.id("connection-phone");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getAttribute("placeholder");
    }

    public String getAmountPlaceholder() {
        By locator = By.id("connection-sum");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getAttribute("placeholder");
    }

    public void fillPhone(String phone9digits) {
        By locator = By.id("connection-phone");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        scrollToElement(element);

        element.clear();
        element.sendKeys("+375" + phone9digits);
        System.out.println("Введён телефон: " + phone9digits);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
    }

    public void fillAmount(String amount) {
        By locator = By.id("connection-sum");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        scrollToElement(element);

        // Кликаем через JavaScript, чтобы обойти перекрытие
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        try { Thread.sleep(500); } catch (InterruptedException e) {}

        element.clear();
        element.sendKeys(amount);
        System.out.println("Введена сумма: " + amount);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
    }

    public void clickContinue() {
        By locator = By.xpath("//button[contains(text(),'Продолжить') and not(@disabled)]");
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(locator));
        scrollToElement(button);

        // Кликаем через JavaScript для надёжности
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        System.out.println("Кнопка 'Продолжить' нажата");
        try { Thread.sleep(5000); } catch (InterruptedException e) {}
    }
}