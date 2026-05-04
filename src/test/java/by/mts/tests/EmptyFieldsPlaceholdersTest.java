package by.mts.tests;

import by.mts.pages.HomePage;
import by.mts.pages.TopUpNoCommissionBlock;
import by.mts.support.BaseUiTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmptyFieldsPlaceholdersTest extends BaseUiTest {

    private TopUpNoCommissionBlock block;

    @BeforeEach
    void setUp() {
        HomePage homePage = new HomePage(driver).open();
        block = homePage.topUpNoCommission();
    }

    @Test
    void emptyFieldsPlaceholders_shouldBeCorrect() {
        // Услуги связи
        assertThat(block.getPhonePlaceholder()).containsIgnoringCase("номер");
        assertThat(block.getAmountPlaceholder()).containsIgnoringCase("сумма");


    }
}
