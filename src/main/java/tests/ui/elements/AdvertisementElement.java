package tests.ui.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.element;

@Getter
public class AdvertisementElement extends PageElement{

    private final SelenideElement inputName;
    private final SelenideElement inputPrice;
    private final SelenideElement inputDescription;
    private final SelenideElement inputUrl;

    public AdvertisementElement(SelenideElement element) {
        super(element);

        this.inputName = $x("//input[@name='name']");
        this.inputPrice = $x("//input[@name='price']");
        this.inputDescription = $x("//*[@name='description']");
        this.inputUrl = $x("//input[@name='imageUrl']");
    }

    public AdvertisementElement setInputName(String name) {
        inputName.shouldBe(visible).setValue(name);
        return this;
    }

    public AdvertisementElement setInputPrice(int price) {
        inputPrice.shouldBe(visible).setValue(String.valueOf(price));
        return this;
    }

    public AdvertisementElement setInputDescription(String description) {
        inputDescription.shouldBe(visible).setValue(description);
        return this;
    }

    public AdvertisementElement setInputUrl(String url) {
        inputUrl.shouldBe(visible).setValue(url);
        return this;
    }





}
