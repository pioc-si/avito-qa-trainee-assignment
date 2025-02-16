package tests.ui.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class NestedSortElement extends FilterAndSortAdvElement {
    private final SelenideElement decrease;
    private final SelenideElement increase;

    public NestedSortElement(SelenideElement element) {
        super(element);

        this.decrease = $x("//div[contains(@id,'menu-list')]//button[text()='По убыванию']");
        this.increase = $x("//div[contains(@id,'menu-list')]//button[text()='По возрастанию']");
    }


}
