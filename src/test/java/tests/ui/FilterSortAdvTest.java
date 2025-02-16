package tests.ui;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import tests.ui.pages.AdvertisementsPage;
import static io.qameta.allure.Allure.step;

@Epic("Фильтрация и сортировка объявлений")
public class FilterSortAdvTest extends BaseUiTest {


    @Test(testName = "Поиск объявления")
    public void searchAndGoToAdvertisementTest() {
        step("Открыть страницу с Объявлениями", () -> {
            new AdvertisementsPage().open()
                    .waitUntilHeaderLogoIsDisplayed();
        });
        step("Нажать на ItemsOnPage", () -> {
            new AdvertisementsPage().getFilterSortElements()
                    .stream().reduce((first, second) -> second).get()
                    .getItemsOnPage().click();
            new AdvertisementsPage().getItemsOnPageElements()
                    .stream().reduce((first, second) -> second).get()
                    .getItemsOnPage10().click();
        });
        step("Нажать на filter", () -> {
            new AdvertisementsPage().getFilterSortElements()
                    .stream().reduce((first, second) -> second).get()
                    .getFilter().click();
            new AdvertisementsPage().getFilterElements()
                    .stream().reduce((first, second) -> second).get()
                    .getPrice().click();
        });
        step("Нажать на sort", () -> {
            new AdvertisementsPage().getFilterSortElements()
                    .stream().reduce((first, second) -> second).get()
                    .getSort().click();
            new AdvertisementsPage().getSortElements()
                    .stream().reduce((first, second) -> second).get()
                    .getDecrease().click();
        });
        softAssertion.assertThat(new AdvertisementsPage().getAdv().shouldBe(
                CollectionCondition.allMatch("all visible",
                        el -> el.isDisplayed())));
        int expectedCountOfAdvs = new AdvertisementsPage().getAdv().size();
        softAssertion.assertThat(new AdvertisementsPage()
                .getAdv().shouldBe(CollectionCondition.size(expectedCountOfAdvs)));
    }
}