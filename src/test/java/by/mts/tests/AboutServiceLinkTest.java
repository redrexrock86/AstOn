package by.mts.tests;

import by.mts.pages.HomePage;
import by.mts.pages.TopUpNoCommissionBlock;
import by.mts.support.BaseUiTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AboutServiceLinkTest extends BaseUiTest {

    @Test
    void aboutServiceLinkShouldNavigate() {
        TopUpNoCommissionBlock block = new HomePage(driver).open().topUpNoCommission();
        String url = block.clickAboutServiceAndGetNavigatedUrl();
        assertThat(url).contains("mts.by");
        assertThat(url).doesNotEndWith("mts.by/");
    }
}

