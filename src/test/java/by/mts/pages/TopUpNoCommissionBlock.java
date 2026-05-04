package by.mts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class TopUpNoCommissionBlock {
    // Поля — локаторы элементов
    @FindBy(id = "phone-input")
    private WebElement phoneInput;

    @FindBy(id = "amount-input")
    private WebElement amountInput;

    @FindBy(id = "account-input")
    private WebElement accountInput;

    @FindBy(id = "installment-input")
    private WebElement installmentInput;

    @FindBy(id = "debt-input")
    private WebElement debtInput;

    // Дополнительные поля для Title и Wait
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By title = By.xpath(
            "//*[self::h1 or self::h2 or self::h3][normalize-space()='Онлайн пополнение без комиссии']");

    public TopUpNoCommissionBlock(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // Геттеры для получения placeholder'ов
    public String getPhonePlaceholder() {
        return phoneInput.getAttribute("placeholder");
    }

    public String getAmountPlaceholder() {
        return amountInput.getAttribute("placeholder");
    }

    public String getAccountPlaceholder() {
        return accountInput.getAttribute("placeholder");
    }

    public String getInstallmentPlaceholder() {
        return installmentInput.getAttribute("placeholder");
    }

    public String getDebtPlaceholder() {
        return debtInput.getAttribute("placeholder");
    }

    // Метод получения текста заголовка блока
    public String getTitleText() {
        String raw = wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
        return raw.replaceAll("\\s+", " ").trim();
    }
}

