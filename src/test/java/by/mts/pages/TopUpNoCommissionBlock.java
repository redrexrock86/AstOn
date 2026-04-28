package by.mts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class TopUpNoCommissionBlock {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By title = By.xpath("//*[self::h1 or self::h2 or self::h3][normalize-space()='Онлайн пополнение без комиссии']");
    private final By blockRoot = By.xpath(
            "//*[self::h1 or self::h2 or self::h3][normalize-space()='Онлайн пополнение без комиссии']" +
                    "/ancestor::*[.//button[normalize-space()='Продолжить']][1]"
    );

    private final By aboutServiceLinkInBlock = By.xpath(
            "//*[self::h1 or self::h2 or self::h3][normalize-space()='Онлайн пополнение без комиссии']" +
                    "/ancestor::*[.//button[normalize-space()='Продолжить']][1]" +
                    "//a[contains(normalize-space(), 'Подробнее')]"
    );

    private final By commServicesTab = By.xpath(
            "//*[self::h1 or self::h2 or self::h3][normalize-space()='Онлайн пополнение без комиссии']" +
                    "/ancestor::*[.//button[normalize-space()='Продолжить']][1]" +
                    "//*[self::button or self::a][normalize-space()='Услуги связи']"
    );

    private final By connectionPhone = By.cssSelector("#connection-phone");
    private final By connectionAmount = By.cssSelector("#connection-sum, #connection-amount, #connection-rub");
    private final By selectOptionOverlay = By.cssSelector(".select__option");

    private final By continueButtonInBlock = By.xpath(
            "//*[self::h1 or self::h2 or self::h3][normalize-space()='Онлайн пополнение без комиссии']" +
                    "/ancestor::*[.//button[normalize-space()='Продолжить']][1]" +
                    "//button[normalize-space()='Продолжить' or @type='submit']"
    );

    public TopUpNoCommissionBlock(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getTitleText() {
        String raw = wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
        return raw.replaceAll("\\s+", " ").trim();
    }

    public int countPaymentLogosLikeVisaMastercardMirBelkart() {
        WebElement root = wait.until(ExpectedConditions.visibilityOfElementLocated(blockRoot));
        List<WebElement> candidates = new ArrayList<>();
        candidates.addAll(root.findElements(By.cssSelector("img")));
        candidates.addAll(root.findElements(By.cssSelector("svg")));

        int matched = 0;
        for (WebElement el : candidates) {
            String outer = safeOuterHtml(el).toLowerCase();
            if (outer.contains("visa") || outer.contains("mastercard") || outer.contains("maestro")
                    || outer.contains("mir") || outer.contains("belkart") || outer.contains("белкарт")) {
                matched++;
            }
        }
        return matched;
    }

    public void selectCommServices() {
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(commServicesTab));
        scrollIntoView(tab);
        safeClick(tab);
        waitForOverlaysToClose();
    }

    public void fillPhoneLast9Digits(String last9Digits) {
        WebElement root = wait.until(ExpectedConditions.visibilityOfElementLocated(blockRoot));
        waitForOverlaysToClose();

        WebElement phoneInput;
        List<WebElement> byId = root.findElements(connectionPhone);
        if (!byId.isEmpty()) {
            phoneInput = byId.get(0);
        } else {
            phoneInput = root.findElement(By.xpath(".//input[(@type='tel' or @type='text') and not(@disabled)]"));
        }

        scrollIntoView(phoneInput);
        safeClick(phoneInput);
        selectAll(phoneInput);
        phoneInput.sendKeys(Keys.BACK_SPACE);
        phoneInput.sendKeys(last9Digits);
    }

    public void fillAmountRub(String amount) {
        WebElement root = wait.until(ExpectedConditions.visibilityOfElementLocated(blockRoot));
        waitForOverlaysToClose();

        WebElement amountInput;
        List<WebElement> byId = root.findElements(connectionAmount);
        if (!byId.isEmpty()) {
            amountInput = byId.get(0);
        } else {
            List<WebElement> inputs = root.findElements(By.xpath(".//input[(@type='text' or @type='tel' or @type='number') and not(@disabled)]"));
            amountInput = inputs.size() >= 2 ? inputs.get(1) : inputs.get(0);
        }

        scrollIntoView(amountInput);
        safeClick(amountInput);
        selectAll(amountInput);
        amountInput.sendKeys(Keys.BACK_SPACE);
        amountInput.sendKeys(amount);
    }

    public String clickAboutServiceAndGetNavigatedUrl() {
        String originalUrl = driver.getCurrentUrl();
        String originalWindow = driver.getWindowHandle();
        Set<String> beforeHandles = driver.getWindowHandles();

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(aboutServiceLinkInBlock));
        scrollIntoView(link);
        link.click();

        Set<String> afterHandles = driver.getWindowHandles();
        if (afterHandles.size() > beforeHandles.size()) {
            for (String h : afterHandles) {
                if (!beforeHandles.contains(h)) {
                    driver.switchTo().window(h);
                    break;
                }
            }
        }

        wait.until(d -> !d.getCurrentUrl().equals(originalUrl));
        String newUrl = driver.getCurrentUrl();

        if (!driver.getWindowHandle().equals(originalWindow)) {
            driver.close();
            driver.switchTo().window(originalWindow);
        }
        return newUrl;
    }

    public ContinueResult clickContinueAndWaitForEffect() {
        String originalUrl = driver.getCurrentUrl();
        String originalWindow = driver.getWindowHandle();
        Set<String> beforeHandles = driver.getWindowHandles();

        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(continueButtonInBlock));
        scrollIntoView(btn);
        btn.click();

        // На сайте переход может быть без изменения URL (SPA), поэтому ждём любой “эффект”:
        // - изменился URL
        // - открылась новая вкладка
        // - изменился DOM (кнопка стала stale)
        // - появился iframe/сообщение об ошибке (частые паттерны у платёжных форм)
        wait.until(d -> {
            if (!d.getCurrentUrl().equals(originalUrl)) return true;
            if (d.getWindowHandles().size() > beforeHandles.size()) return true;
            try {
                btn.isEnabled(); // может бросить StaleElementReferenceException
            } catch (Exception e) {
                return true;
            }
            return hasAny(d, By.xpath("//iframe"))
                    || hasAny(d, By.xpath("//*[contains(normalize-space(), 'Оплата') or contains(normalize-space(),'оплата')]"))
                    || hasAny(d, By.xpath("//*[contains(normalize-space(), 'Ошибка') or contains(normalize-space(),'ошибка') or contains(normalize-space(),'Некоррект') or contains(normalize-space(),'неверн')]"));
        });

        Set<String> afterHandles = driver.getWindowHandles();
        boolean newWindow = afterHandles.size() > beforeHandles.size();
        if (newWindow) {
            for (String h : afterHandles) {
                if (!beforeHandles.contains(h)) {
                    driver.switchTo().window(h);
                    break;
                }
            }
        }

        String url = driver.getCurrentUrl();
        String titleNow = driver.getTitle();
        boolean urlChanged = !url.equals(originalUrl);

        boolean domChanged;
        try {
            btn.isEnabled();
            domChanged = false;
        } catch (Exception e) {
            domChanged = true;
        }

        boolean iframePresent = hasAny(driver, By.xpath("//iframe"));
        boolean paymentTextPresent = hasAny(driver, By.xpath("//*[contains(normalize-space(), 'Оплата') or contains(normalize-space(),'оплата')]"));
        boolean errorTextPresent = hasAny(driver, By.xpath("//*[contains(normalize-space(), 'Ошибка') or contains(normalize-space(),'ошибка') or contains(normalize-space(),'Некоррект') or contains(normalize-space(),'неверн')]"));

        if (!driver.getWindowHandle().equals(originalWindow)) {
            driver.close();
            driver.switchTo().window(originalWindow);
        }

        return new ContinueResult(newWindow, urlChanged, domChanged, iframePresent, paymentTextPresent, errorTextPresent, url, titleNow);
    }

    private boolean hasAny(WebDriver d, By by) {
        try {
            return !d.findElements(by).isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public static final class ContinueResult {
        public final boolean openedNewWindow;
        public final boolean urlChanged;
        public final boolean domChanged;
        public final boolean iframePresent;
        public final boolean paymentTextPresent;
        public final boolean errorTextPresent;
        public final String url;
        public final String pageTitle;

        public ContinueResult(boolean openedNewWindow,
                              boolean urlChanged,
                              boolean domChanged,
                              boolean iframePresent,
                              boolean paymentTextPresent,
                              boolean errorTextPresent,
                              String url,
                              String pageTitle) {
            this.openedNewWindow = openedNewWindow;
            this.urlChanged = urlChanged;
            this.domChanged = domChanged;
            this.iframePresent = iframePresent;
            this.paymentTextPresent = paymentTextPresent;
            this.errorTextPresent = errorTextPresent;
            this.url = url;
            this.pageTitle = pageTitle;
        }
    }

    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }

    private void waitForOverlaysToClose() {
        try {
            driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
        } catch (Exception ignored) {
        }
        try {
            wait.withTimeout(Duration.ofSeconds(5))
                    .until(ExpectedConditions.invisibilityOfElementLocated(selectOptionOverlay));
        } catch (Exception ignored) {
            // overlay might not exist or might be non-blocking
        }
    }

    private void safeClick(WebElement element) {
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    private void selectAll(WebElement element) {
        boolean isMac = System.getProperty("os.name", "").toLowerCase().contains("mac");
        element.sendKeys(Keys.chord(isMac ? Keys.COMMAND : Keys.CONTROL, "a"));
    }

    private String safeOuterHtml(WebElement element) {
        try {
            return element.getAttribute("outerHTML");
        } catch (Exception e) {
            return "";
        }
    }
}

