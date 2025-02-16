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
public class CreateAdvWithAllFieldsTest extends BaseUiTest {

    public static TestData testData;
    public static Advertisement advrtmnt;

    static {
        testDataStorage = TestDataStorage.getStorage();
        testData = testDataStorage.addTestData();
        advrtmnt = testData.getAdvertisement();
    }


    @Test(testName = "Создать объявление с заполнением всех полей")
    public void createAdvertisementWithFullFieldsTest() {
        step("Открыть страницу с Объявлениями", () -> {
            new AdvertisementsPage().open()
                    .waitUntilHeaderLogoIsDisplayed();
        });
        step("Нажать Создать", () -> {
            new AdvertisementsPage().getCreateOrder().click();
        });
        step("Заполнить форму - нажать Сохранить", () -> {
            new CreateAdvertisementModal()
                    .createAdvrtmntFormIsVisible();
            new CreateAdvertisementModal().getAdvrtmntInputFields()
                    .stream().reduce((first, second) -> first).get()
                    .setInputName(advrtmnt.getName())
                    .setInputPrice(advrtmnt.getPrice())
                    .setInputDescription(advrtmnt.getDescription())
                    .setInputUrl(advrtmnt.getUrl());
            new CreateAdvertisementModal().getSubmitButton()
                    .shouldBe(visible).click();
        });
    }

    @Test(testName = "Поиск объявления",
            dependsOnMethods = {"createAdvertisementWithFullFieldsTest"})
    public void searchAndGoToAdvertisementTest() {
        step("Найти объявление по Названию " +
                "через поисковую строку на странице Объявлений" +
                " - Перейти", () -> {
            new AdvertisementsPage()
                    .setInSearchField(advrtmnt.getName())
                    .getSearchButton().click();
            softAssertion.assertThat(new AdvertisementsPage()
                            .getProductNameOnProductCard(advrtmnt.getName())
                            .shouldBe(visible).isDisplayed())
                    .as("Заголовок созданного объявления отображен").isTrue();
        });
    }
}