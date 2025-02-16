package tests.ui.EditAdv;

import io.qameta.allure.Epic;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import tests.api.UncheckedAdvertisement;
import tests.ui.Advertisement;
import tests.ui.BaseUiTest;
import tests.ui.generators.TestData;
import tests.ui.generators.TestDataStorage;
import tests.ui.modals.CreateAdvertisementModal;
import tests.ui.pages.AdvertisementPage;
import tests.ui.pages.AdvertisementsPage;

import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;
import static tests.api.Specifications.authSpec;
import static tests.utils.AdvertisementNumber.getAdvertisementNumber;

@Epic("Редактирование объявления")
public class EditAdvertisementTest extends BaseUiTest {

    public static TestData testDataOld;
    public static Advertisement advrtmntOld;
    public static TestData testDataNew;
    public static Advertisement advrtmntNew;

    static {
        testDataStorage = TestDataStorage.getStorage();
        testDataOld = testDataStorage.addTestData();
        advrtmntOld = testDataOld.getAdvertisement();
        testDataNew = testDataStorage.addTestData();
        advrtmntNew = testDataNew.getAdvertisement();
    }


    @Test(testName = "Создание объявления")
    public void createAndEditAndSaveAdvertisementTest() {
        step("Открыть страницу с Объявлениями", () -> {
            new AdvertisementsPage().open()
                    .waitUntilHeaderLogoIsDisplayed();
        });
        step("Нажать Создать в хедер элементах", () -> {
            new AdvertisementsPage().getCreateOrder().click();
        });
        step("Заполнить форму - нажать Сохранить", () -> {
            new CreateAdvertisementModal()
                    .createAdvrtmntFormIsVisible();
            new CreateAdvertisementModal().getAdvrtmntInputFields()
                    .stream().reduce((first, second) -> first).get()
                    .setInputName(advrtmntOld.getName())
                    .setInputPrice(advrtmntOld.getPrice())
                    .setInputDescription(advrtmntOld.getDescription())
                    .setInputUrl(advrtmntOld.getUrl());
            new CreateAdvertisementModal().getSubmitButton().click();
        });
    }


    @Test(testName = "Поиск объявления",
            dependsOnMethods = {"createAndEditAndSaveAdvertisementTest"})
    public void searchAndGoToAdvertisementTest() {
        step("Найти объявление по Названию " +
                "через поисковую строку на странице Объявлений" +
                " - Перейти", () -> {
            new AdvertisementsPage()
                    .setInSearchField(advrtmntOld.getName())
                    .getSearchButton().click();
            new AdvertisementsPage()
                    .getProductNameOnProductCard(advrtmntOld.getName())
                    .shouldBe(visible).click();
            getAdvertisementNumber();
        });
        }

    @Test(testName = "Редактирование объявления",
            dependsOnMethods = {"searchAndGoToAdvertisementTest"})
    public void editAndSaveAdvertisementTest() {
        step("В объявлении нажать на svg редактирования", () -> {
            new AdvertisementPage().getSvgElement()
                    .shouldBe(visible).click();
        });
        step("Изменить все поля в объявлении - " +
                "Нажать галочку(сохранить редактирование)", () -> {
            new AdvertisementPage().getAdvrtmntInputFields()
                    .stream().reduce((first, second) -> first).get()
                    .setInputName(advrtmntNew.getName())
                    .setInputPrice(advrtmntNew.getPrice())
                    .setInputDescription(advrtmntNew.getDescription());
            new AdvertisementPage().getSvgElement().click();

            softAssertion.assertThat(new UncheckedAdvertisement(
                    authSpec()).read()
                    .then().extract().statusCode())
                    .isEqualTo(HttpStatus.SC_OK);
        });
        step("Проверка, что значения в полях " +
                "Название, Цена, Описание обновились", () -> {
            softAssertion.assertThat(new AdvertisementPage()
                            .getName().getText())
                    .as("Название объявления не совпадает")
                    .isEqualTo(advrtmntNew.getName());

            softAssertion.assertThat(new AdvertisementPage()
                            .getPrice().getText())
                    .as("Цена объявления не совпадает")
                    .isEqualTo(advrtmntNew.getPrice() + " ₽");

            softAssertion.assertThat(new AdvertisementPage()
                            .getDescription().getText())
                    .as("Описание объявления не совпадает")
                    .isEqualTo(advrtmntNew.getDescription());
        });
    }
}
