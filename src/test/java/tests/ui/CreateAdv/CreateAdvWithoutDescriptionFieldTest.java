package tests.ui.CreateAdv;

import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import tests.ui.Advertisement;
import tests.ui.BaseUiTest;
import tests.ui.generators.TestData;
import tests.ui.generators.TestDataStorage;
import tests.ui.modals.CreateAdvertisementModal;
import tests.ui.pages.AdvertisementsPage;

import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;

@Epic("Создание объявления")
public class CreateAdvWithoutDescriptionFieldTest extends BaseUiTest {

    public static TestData testData;
    public static Advertisement advrtmnt;

    static {
        testDataStorage = TestDataStorage.getStorage();
        testData = testDataStorage.addTestData();
        advrtmnt = testData.getAdvertisement();
    }


    @Test(testName = "Создать объявление без заполения Описание" +
            " - Сохранить - Объявление не создано")
    public void createAdvertisementWithoutDescriptionFieldTest() {
        step("Открыть страницу с Объявлениями", () -> {
            new AdvertisementsPage().open()
                    .waitUntilHeaderLogoIsDisplayed();
        });
        step("Нажать Создать в хедер элементах", () -> {
            new AdvertisementsPage().getCreateOrder().click();
        });
        step("Заполнить форму - нажать Сохранить", () -> {
            new CreateAdvertisementModal().getAdvrtmntInputFields()
                    .stream().reduce((first, second) -> first).get()
                    .setInputName(advrtmnt.getName())
                    .setInputPrice(advrtmnt.getPrice())
                    .setInputDescription("")
                    .setInputUrl(advrtmnt.getUrl());
            new CreateAdvertisementModal().getSubmitButton().click();
        });
        step("Текст ошибки без заполнения обязательного поля Описание", () -> {
            softAssertion.assertThat(new CreateAdvertisementModal()
                            .getErrorMessageForEmptyField(new CreateAdvertisementModal()
                                    .getAdvrtmntInputFields()
                                    .stream().reduce((first, second) -> second)
                                    .get().getInputDescription())
                            .shouldBe(visible).isDisplayed())
                    .as("После поля ввода Описания отображена ошибка").isTrue();
        });
        step("Закрыть модальное окно 'Создать объявление' ", () -> {
            new CreateAdvertisementModal().getCloseButton().shouldBe(visible).click();
        });
    }

    @Test(testName = "Поиск объявления",
                dependsOnMethods = {"createAdvertisementWithoutDescriptionFieldTest"})
    public void searchAdvertisementTest() {
        step("Отсутствие объявления по Названию " +
                "через поисковую строку на странице Объявлений", () -> {
            new AdvertisementsPage()
                    .setInSearchField(advrtmnt.getName())
                    .getSearchButton().click();
            softAssertion.assertThat(new AdvertisementsPage()
                            .getFind0().shouldBe(visible).isDisplayed()).
                    as("Найдено: 0 - отображено").isTrue();
            softAssertion.assertThat(new AdvertisementsPage()
                            .getProductNameOnProductCard(advrtmnt.getName())
                            .shouldNotBe(visible).exists())
                    .as("Заголовок созданного объявления не отображен").isFalse();
        });

    }

}
