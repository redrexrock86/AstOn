package by.mts.tests;

import by.mts.pages.HomePage;
import by.mts.pages.TopUpNoCommissionBlock;
import by.mts.support.BaseUiTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentLogosTest extends BaseUiTest {

    @Test
    void shouldShowPaymentSystemLogos() {
        TopUpNoCommissionBlock block = new HomePage(driver).open().topUpNoCommission();
        assertThat(block.countPaymentLogosLikeVisaMastercardMirBelkart())
                .as("Expected at least 3 recognizable payment logos inside the block")
                .isGreaterThanOrEqualTo(3);
    }
}

