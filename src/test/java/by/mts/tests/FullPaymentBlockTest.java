package by.mts.tests;

import by.mts.pages.HomePage;
import by.mts.pages.PaymentConfirmationPage;
import by.mts.pages.TopUpNoCommissionBlock;
import by.mts.support.BaseUiTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FullPaymentBlockTest extends BaseUiTest {

    private HomePage homePage;

    @BeforeEach
    void openHomePage() {
        homePage = new HomePage(driver).open();
    }

    @Test
    void testFullPaymentFlow() {
        TopUpNoCommissionBlock block = homePage.topUpNoCommission();

        // Шаг 1: Проверка блока
        assertThat(block.isBlockDisplayed()).isTrue();
        System.out.println("✅ Блок 'Онлайн пополнение' найден");

        // Шаг 2: Проверка плейсхолдеров
        assertThat(block.getPhonePlaceholder()).isEqualTo("Номер телефона");
        assertThat(block.getAmountPlaceholder()).isEqualTo("Сумма");
        System.out.println("✅ Плейсхолдеры проверены");

        // Шаг 3: Заполнение формы
        block.fillPhone("297777777");
        block.fillAmount("15");
        System.out.println("✅ Поля заполнены: телефон +375297777777, сумма 15");

        // Шаг 4: Нажатие кнопки "Продолжить"
        block.clickContinue();
        System.out.println("✅ Кнопка 'Продолжить' нажата");

        // Шаг 5: Проверка модального окна оплаты
        PaymentConfirmationPage confirmation = new PaymentConfirmationPage(driver);

        // Проверка номера телефона
        assertThat(confirmation.getDisplayedPhoneNumber()).contains("297777777");
        System.out.println("✅ Номер телефона в окне оплаты: " + confirmation.getDisplayedPhoneNumber());

        // Проверка суммы
        assertThat(confirmation.getDisplayedAmount()).contains("15");
        System.out.println("✅ Сумма в окне оплаты: " + confirmation.getDisplayedAmount());

        // Проверка суммы на кнопке
        assertThat(confirmation.getAmountOnButton()).contains("15");
        System.out.println("✅ Сумма на кнопке: " + confirmation.getAmountOnButton());

        // Проверка плейсхолдеров полей карты
        assertThat(confirmation.getCardNumberPlaceholder()).isEqualTo("Номер карты");
        assertThat(confirmation.getExpiryPlaceholder()).isEqualTo("ММ / ГГ");
        assertThat(confirmation.getCvvPlaceholder()).isEqualTo("CVC");
        System.out.println("✅ Плейсхолдеры полей карты проверены");

        // Проверка иконок платёжных систем
        assertThat(confirmation.arePaymentLogosPresent()).isTrue();
        System.out.println("✅ Иконки платёжных систем (Visa, Mastercard, Белкарт) присутствуют");

        System.out.println("\n🎉 ВСЕ ТРЕБОВАНИЯ ВЫПОЛНЕНЫ! 🎉");
    }
}