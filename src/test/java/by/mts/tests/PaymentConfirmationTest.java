package by.mts.tests;

import by.mts.pages.HomePage;
import by.mts.pages.PaymentConfirmationPage;
import by.mts.pages.TopUpNoCommissionBlock;
import by.mts.support.BaseUiTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentConfirmationTest extends BaseUiTest {

    @Test
    void shouldDisplayCorrectPaymentDetailsAfterContinue() {
        // GIVEN: подготавливаем данные платежа
        String phoneNumber = "297777777";
        String amount = "10";

        // WHEN: выполняем все шаги до страницы подтверждения
        TopUpNoCommissionBlock block = new HomePage(driver).open().topUpNoCommission();
        block.selectCommServices();
        block.fillPhoneLast9Digits(phoneNumber);
        block.fillAmountRub(amount);
        PaymentConfirmationPage confirmationPage = block.clickContinueAndNavigateToConfirmation();

        // THEN: валидируем данные на странице подтверждения
        assertThat(confirmationPage.getDisplayedPhoneNumber())
                .as("Отображаемый номер телефона должен совпадать с введённым")
                .contains(phoneNumber);

        assertThat(confirmationPage.getDisplayedAmount())
                .as("Отображаемая сумма должна совпадать с введённой")
                .contains(amount);

        assertThat(confirmationPage.getCardNumberPlaceholder())
                .as("Должен отображаться placeholder для номера карты")
                .isNotEmpty();

        assertThat(confirmationPage.getExpiryPlaceholder())
                .as("Должен отображаться placeholder для срока действия")
                .isNotEmpty();

        assertThat(confirmationPage.getCvvPlaceholder())
                .as("Должен отображаться placeholder для CVV")
                .isNotEmpty();

        assertThat(confirmationPage.getPaymentButtonText())
                .as("Текст кнопки оплаты должен содержать 'Оплатить'")
                .containsIgnoringCase("оплатить");
    }
}
