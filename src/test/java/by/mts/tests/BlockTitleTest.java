package by.mts.tests;

import by.mts.pages.HomePage;
import by.mts.pages.TopUpNoCommissionBlock;
import by.mts.support.BaseUiTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BlockTitleTest extends BaseUiTest {

    @Test
    void shouldHaveCorrectBlockTitle() {
        TopUpNoCommissionBlock block = new HomePage(driver).open().topUpNoCommission();
        assertThat(block.getTitleText()).isEqualTo("Онлайн пополнение без комиссии");
    }
}

