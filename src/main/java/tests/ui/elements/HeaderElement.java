package tests.ui.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

@Getter
public class HeaderElement extends PageElement {

    private final SelenideElement linkToAdvertisements;
    private final SelenideElement linkToOrders;
    private final SelenideElement logo;

    public HeaderElement(SelenideElement element) {
        super(element);

        this.logo = element("div.chakra-stack img[src*='/logo.png']");
        this.linkToAdvertisements = element("div.chakra-stack > a[href*='advertisements']");
        this.linkToOrders = element("div.chakra-stack > a[href*='orders']");
    }


}
