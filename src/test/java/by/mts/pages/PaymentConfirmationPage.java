package by.mts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.ArrayList;


public final class PaymentConfirmationPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By phoneNumberDisplay = By.xpath("//*[contains(normalize-space(), 'Номер телефона')]/following-sibling::*");
    private final By amountDisplay = By.xpath("//*[contains(normalize-space(), 'Сумма')]/following-sibling::*");
    private final By cardNumberPlaceholder = By.cssSelector("#card-number, .card-input[placeholder*='номер'], input[placeholder*='карта']");
    private final By expiryPlaceholder = By.cssSelector("#expiry, .expiry-input, input[placeholder*='срок']");
    private final By cvvPlaceholder = By.cssSelector("#cvv, .cvv-input, input[placeholder*='CVV']");
    private final By paymentButton = By.xpath("//button[contains(normalize-space(), 'Оплатить') or contains(normalize-space(), 'Pay')]");
    private final By paymentLogosContainer = By.xpath("//*[contains(normalize-space(), 'Способы оплаты') or contains(normalize-space(), 'Payment methods')]");
    private final By connectionPhone = By.cssSelector("#connection-phone");
    private final By connectionAmount = By.cssSelector("#connection-sum, #connection-amount, #connection-rub");

    public PaymentConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getDisplayedPhoneNumber() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberDisplay)).getText();
    }

    public String getDisplayedAmount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(amountDisplay)).getText();
    }

    public String getCardNumberPlaceholder() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberPlaceholder));
        return element.getAttribute("placeholder");
    }

    public String getExpiryPlaceholder() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(expiryPlaceholder));
        return element.getAttribute("placeholder");
    }

    public String getCvvPlaceholder() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(cvvPlaceholder));
        return element.getAttribute("placeholder");
    }

    public String getPaymentButtonText() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(paymentButton));
        return button.getText();
    }

    public int countPaymentLogos() {
        WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentLogosContainer));
        List<WebElement> logos = container.findElements(By.cssSelector("img, svg"));
        return logos.size();
    }

    public String getPhonePlaceholder() {
        WebElement phoneInput = driver.findElement(connectionPhone);
        return phoneInput.getAttribute("placeholder");
    }

    public String getAmountPlaceholder() {
        WebElement amountInput = driver.findElement(connectionAmount);
        return amountInput.getAttribute("placeholder");
    }

    public String getAccountPlaceholder() {
        // Локатор для поля «лицевой счёт / номер договора» в разделе «Домашний интернет»
        By accountField = By.cssSelector("#account-number, #contract-id, input[placeholder*='счёт'], input[placeholder*='договор']");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(accountField));
        return element.getAttribute("placeholder");
    }

    public String getInstallmentPlaceholder() {
        // Локатор для поля «номер договора / код рассрочки» в разделе «Рассрочка»
        By installmentField = By.cssSelector("#installment-id, #contract-code, input[placeholder*='рассрочка'], input[placeholder*='код']");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(installmentField));
        return element.getAttribute("placeholder");
    }

    public String getDebtPlaceholder() {
        // Локатор для поля «номер счёта / идентификатор» в разделе «Задолженность»
        By debtField = By.cssSelector("#debt-account, #identifier, input[placeholder*='счёт'], input[placeholder*='идентификатор']");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(debtField));
        return element.getAttribute("placeholder");
    }


}

