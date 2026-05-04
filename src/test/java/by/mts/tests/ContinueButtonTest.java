package by.mts.tests;

import by.mts.pages.HomePage;
import by.mts.pages.PaymentConfirmationPage;
import by.mts.pages.TopUpNoCommissionBlock;
import by.mts.support.BaseUiTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContinueButtonTest extends BaseUiTest {

    @Test
    void shouldProceedToPayment() {
        TopUpNoCommissionBlock block = new HomePage(driver).open().topUpNoCommission();
        block.selectCommServices();
        block.fillPhoneLast9Digits("297777777");
        block.fillAmountRub("10");
        PaymentConfirmationPage confirmationPage = block.clickContinueAndNavigateToConfirmation();

        assertThat(confirmationPage.getDisplayedPhoneNumber()).contains("297777777");
    }
}


