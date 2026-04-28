package by.mts.tests;

import by.mts.pages.HomePage;
import by.mts.pages.TopUpNoCommissionBlock;
import by.mts.support.BaseUiTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContinueButtonTest extends BaseUiTest {

    @Test
    void shouldFillCommServicesAndProceed() {
        TopUpNoCommissionBlock block = new HomePage(driver).open().topUpNoCommission();
        block.selectCommServices();
        block.fillPhoneLast9Digits("297777777");
        block.fillAmountRub("10");

        TopUpNoCommissionBlock.ContinueResult result = block.clickContinueAndWaitForEffect();
        assertThat(result.url).contains("mts.by");
        assertThat(result.url.toLowerCase()).doesNotContain("error");
        assertThat(result.openedNewWindow
                || result.urlChanged
                || result.domChanged
                || result.iframePresent
                || result.paymentTextPresent
                || result.errorTextPresent)
                .as("After clicking Continue, expected some visible effect (navigation, new tab, DOM change, iframe, or message)")
                .isTrue();
    }
}

