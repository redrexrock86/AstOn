package by.mts.tests;

import by.mts.pages.HomePage;
import by.mts.pages.PaymentConfirmationPage;
import by.mts.pages.TopUpNoCommissionBlock;
import by.mts.support.BaseUiTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentFlowTest extends BaseUiTest {

    @Test
    void shouldValidatePaymentWindow() {
        // GIVEN: подготавливаем данные платежа
        String phone = "297777777";
        String amount = "15";

        // WHEN: выполняем все шаги до страницы подтверждения
        TopUpNoCommissionBlock block = new HomePage(driver).open().topUpNoCommission();
        block.selectCommServices();
        block.fillPhoneLast9Digits(phone);
        block.fillAmountRub(amount);
        PaymentConfirmationPage confirmationPage = block.clickContinueAndNavigateToConfirmation();

        // THEN: валидируем данные на странице подтверждения
        assertThat(confirmationPage.getDisplayedPhoneNumber())
                .as("Номер телефона должен отображаться корректно")
                .contains(phone);

        assertThat(confirmationPage.getDisplayedAmount())
                .as("Сумма должна отображаться корректно")
                .contains(amount);

        assertThat(confirmationPage.getCardNumberPlaceholder())
                .as("Должен быть placeholder для номера карты")
                .isNotEmpty();

        assertThat(confirmationPage.getExpiryPlaceholder())
                .as("Должен быть placeholder для срока действия")
                .isNotEmpty();

        assertThat(confirmationPage.getCvvPlaceholder())
                .as("Должен быть placeholder для CVV")
                .isNotEmpty();
    }
}

