package tests.ui.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class NestedFiltersElement extends FilterAndSortAdvElement{
    private final SelenideElement price;
    private final SelenideElement views;
    private final SelenideElement likes;

    public NestedFiltersElement(SelenideElement element) {
        super(element);

        this.price = $x("//div[contains(@id,'menu-list')]//button[text()='Цена']");
        this.views = $x("//div[contains(@id,'menu-list')]//button[text()='Просмотры']");
        this.likes = $x("//div[contains(@id,'menu-list')]//button[text()='Лайки']");
        }

}
