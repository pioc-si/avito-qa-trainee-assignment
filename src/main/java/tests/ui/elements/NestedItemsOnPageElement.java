package tests.ui.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class NestedItemsOnPageElement extends FilterAndSortAdvElement{

    private final SelenideElement itemsOnPage5;
    private final SelenideElement itemsOnPage10;
    private final SelenideElement itemsOnPage15;
    private final SelenideElement itemsOnPage20;
    private final SelenideElement itemsOnPage25;

    public NestedItemsOnPageElement(SelenideElement element) {
        super(element);

        this.itemsOnPage5 = $x("//div[contains(@id,'menu-list')]//button[text()='5']");
        this.itemsOnPage10 = $x("//div[contains(@id,'menu-list')]//button[text()='10']");
        this.itemsOnPage15 = $x("//div[contains(@id,'menu-list')]//button[text()='15']");
        this.itemsOnPage20 = $x("//div[contains(@id,'menu-list')]//button[text()='20']");
        this.itemsOnPage25 = $x("//div[contains(@id,'menu-list')]//button[text()='25']");
    }


}
