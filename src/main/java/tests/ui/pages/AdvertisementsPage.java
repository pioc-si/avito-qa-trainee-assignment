package tests.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import tests.ui.elements.*;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class AdvertisementsPage extends BasePage {

    public static final String ADVERTISEMENTS_URL = "/advertisements/";
    private SelenideElement createOrder = $x("//button[text()='Создать']");
    private SelenideElement searchButton = $x("//button[text()='Найти']");
    private SelenideElement find0 = $x("//p[contains(., 'Найдено') and contains(., '0')]");
    private SelenideElement inputSearchField = $x("//input[@placeholder='Поиск по объявлениям']");
    private ElementsCollection filterAndSortElements = $$x("//div[contains(@class, 'chakra-container')]");
    private ElementsCollection itemsOnPageElements = $$x("//button[text()='5']/ancestor::div[contains(@class, 'chakra-menu')]");
    private ElementsCollection filterElements = $$x("//button[text()='Цена']/ancestor::div[contains(@class, 'chakra-menu')]");
    private ElementsCollection sortElements = $$x("//button[text()='По убыванию']/ancestor::div[contains(@class, 'chakra-menu')]");

    private ElementsCollection adv = $$x("//div//a[contains(@href, '/advertisements/')][normalize-space(substring-after(@href, '/advertisements/')) != '']");


    public List<FilterAndSortAdvElement> getFilterSortElements() {
        return generatePageElements(filterAndSortElements, FilterAndSortAdvElement::new);
    }

    public List<NestedItemsOnPageElement> getItemsOnPageElements() {
        return generatePageElements(itemsOnPageElements, NestedItemsOnPageElement::new);
    }

    public List<NestedFiltersElement> getFilterElements() {
        return generatePageElements(filterElements, NestedFiltersElement::new);
    }

    public List<NestedSortElement> getSortElements() {
        return generatePageElements(sortElements, NestedSortElement::new);
    }

    public AdvertisementsPage() {
    }

    public SelenideElement getProductNameOnProductCard(String advrtmntName) {
        return $x("//div/h4[text()='" + advrtmntName + "']");
    }

    public AdvertisementsPage open() {
        Selenide.open(BASE_URL + ADVERTISEMENTS_URL);
        return this;
    }

    public AdvertisementsPage setInSearchField(String name) {
        inputSearchField.shouldBe(visible).setValue(name);
        return this;
    }

}
