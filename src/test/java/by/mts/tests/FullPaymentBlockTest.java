package by.mts.tests;

import by.mts.pages.HomePage;
import by.mts.pages.PaymentConfirmationPage;
import by.mts.pages.TopUpNoCommissionBlock;
import by.mts.support.BaseUiTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("MTS.by UI Тестирование")
@Feature("Онлайн пополнение без комиссии")
public class FullPaymentBlockTest extends BaseUiTest {

    private HomePage homePage;

    @BeforeEach
    void openHomePage() {
        homePage = new HomePage(driver).open();
    }

    @Test
    @DisplayName("Проверка плейсхолдеров в форме оплаты")
    @Description("Проверяет, что поля 'Номер телефона' и 'Сумма' имеют правильные подписи")
    @Severity(SeverityLevel.NORMAL)
    @Story("Пользователь видит правильные подписи в полях ввода")
    void placeholdersShouldBeCorrect() {
        TopUpNoCommissionBlock block = homePage.topUpNoCommission();

        Allure.step("Проверка плейсхолдера 'Номер телефона'", () -> {
            assertThat(block.getPhonePlaceholder()).isEqualTo("Номер телефона");
        });

        Allure.step("Проверка плейсхолдера 'Сумма'", () -> {
            assertThat(block.getAmountPlaceholder()).isEqualTo("Сумма");
        });
    }

    @Test
    @DisplayName("Полный сценарий оплаты услуг связи")
    @Description("Заполнение формы, отправка и проверка модального окна оплаты")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Пользователь успешно заполняет форму и переходит к оплате")
    void testFullPaymentFlow() {
        TopUpNoCommissionBlock block = homePage.topUpNoCommission();

        Allure.step("Проверка видимости блока 'Онлайн пополнение'", () -> {
            assertThat(block.isBlockDisplayed()).isTrue();
            System.out.println("✅ Блок 'Онлайн пополнение' найден");
        });

        Allure.step("Проверка плейсхолдеров формы", () -> {
            assertThat(block.getPhonePlaceholder()).isEqualTo("Номер телефона");
            assertThat(block.getAmountPlaceholder()).isEqualTo("Сумма");
            System.out.println("✅ Плейсхолдеры проверены");
        });

        Allure.step("Заполнение поля телефона: +375297777777", () -> {
            block.fillPhone("297777777");
            System.out.println("✅ Поле телефона заполнено");
        });

        Allure.step("Заполнение поля суммы: 15 рублей", () -> {
            block.fillAmount("15");
            System.out.println("✅ Поле суммы заполнено");
        });

        Allure.step("Нажатие кнопки 'Продолжить'", () -> {
            block.clickContinue();
            System.out.println("✅ Кнопка 'Продолжить' нажата");
        });

        Allure.step("Проверка модального окна оплаты", () -> {
            PaymentConfirmationPage confirmation = new PaymentConfirmationPage(driver);

            Allure.step("Проверка номера телефона в окне оплаты", () -> {
                assertThat(confirmation.getDisplayedPhoneNumber()).contains("297777777");
                System.out.println("✅ Номер телефона: " + confirmation.getDisplayedPhoneNumber());
            });

            Allure.step("Проверка суммы в окне оплаты", () -> {
                assertThat(confirmation.getDisplayedAmount()).contains("15");
                System.out.println("✅ Сумма: " + confirmation.getDisplayedAmount());
            });

            Allure.step("Проверка суммы на кнопке оплаты", () -> {
                assertThat(confirmation.getAmountOnButton()).contains("15");
                System.out.println("✅ Сумма на кнопке: " + confirmation.getAmountOnButton());
            });

            Allure.step("Проверка плейсхолдеров полей карты", () -> {
                assertThat(confirmation.getCardNumberPlaceholder()).isNotEmpty();
                assertThat(confirmation.getExpiryPlaceholder()).isNotEmpty();
                assertThat(confirmation.getCvvPlaceholder()).isNotEmpty();
                System.out.println("✅ Плейсхолдеры полей карты проверены");
            });

            Allure.step("Проверка наличия иконок платёжных систем", () -> {
                assertThat(confirmation.arePaymentLogosPresent()).isTrue();
                System.out.println("✅ Иконки платёжных систем присутствуют");
            });
        });

        System.out.println("\n🎉 ВСЕ ТРЕБОВАНИЯ ВЫПОЛНЕНЫ! 🎉");
    }
}