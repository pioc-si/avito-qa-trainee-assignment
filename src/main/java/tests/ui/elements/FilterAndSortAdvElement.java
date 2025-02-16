package tests.ui.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class FilterAndSortAdvElement extends PageElement{

    private final SelenideElement itemsOnPage;
    private final SelenideElement filter;
    private final SelenideElement sort;

    public FilterAndSortAdvElement(SelenideElement element) {
        super(element);

        this.itemsOnPage = $x("//button[contains(@id, 'menu-button') and .//span[contains(text(), 'Items on page')]]");
        this.filter = $x("//button[contains(@id, 'menu-button')]/span[contains(text(), 'Items on page')]/following::button[contains(@id, 'menu-button')][1]");
        this.sort = $x("//button[contains(@id, 'menu-button')]/span[contains(text(), 'Items on page')]/following::button[contains(@id, 'menu-button')][2]");
    }


}
