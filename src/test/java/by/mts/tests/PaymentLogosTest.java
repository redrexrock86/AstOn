package by.mts.tests;

import by.mts.pages.HomePage;
import by.mts.pages.PaymentConfirmationPage;
import by.mts.pages.TopUpNoCommissionBlock;
import by.mts.support.BaseUiTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentLogosTest extends BaseUiTest {

    @Test
    void shouldShowPaymentLogos() {
        // GIVEN: переходим к блоку пополнения и заполняем данные
        TopUpNoCommissionBlock block = new HomePage(driver).open().topUpNoCommission();
        block.selectCommServices();
        block.fillPhoneLast9Digits("297777777");
        block.fillAmountRub("20");

        // WHEN: переходим на страницу подтверждения
        PaymentConfirmationPage confirmationPage = block.clickContinueAndNavigateToConfirmation();

        // THEN: проверяем логотипы платёжных систем
        int logosCount = confirmationPage.countPaymentLogos();

        assertThat(logosCount)
                .as("Должно отображаться хотя бы несколько логотипов платёжных систем")
                .isGreaterThanOrEqualTo(2);

        // Дополнительно можно проверить текст кнопки оплаты
        assertThat(confirmationPage.getPaymentButtonText())
                .as("Кнопка оплаты должна содержать корректную надпись")
                .containsIgnoringCase("оплатить");
    }
}


