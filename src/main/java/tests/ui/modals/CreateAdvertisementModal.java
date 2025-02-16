package tests.ui.modals;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.Setter;
import tests.ui.elements.AdvertisementElement;
import tests.ui.pages.BasePage;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Setter
@Getter
public class CreateAdvertisementModal extends BasePage {

    private ElementsCollection createAdvrtmntInputElements = $$x("//*[contains(@id,'chakra-modal')]");
    private SelenideElement header = $x("//header[contains(text(), 'Создать объявление')]");
    private SelenideElement pic = $x("//p[contains(text(), 'Изображение')]");
    private SelenideElement labelName = $x("//label[contains(text(), 'Название')]");
    private SelenideElement labelPrice = $x("//label[contains(text(), 'Цена')]");
    private SelenideElement labelDescription = $x("//label[contains(text(), 'Описание')]");
    private SelenideElement labelUrl = $x("//label[contains(text(), 'Ссылка на изображение')]");
    private SelenideElement submitButton = $x("//button[@type='submit']");
    private SelenideElement closeButton = $x("//button[contains(@class, 'close-btn')]");
    private String errorText = "Поле обязательно для заполнения.";

    public List<AdvertisementElement> getAdvrtmntInputFields() {
        return getAdvrtmntInputFields(createAdvrtmntInputElements);
    }


    public CreateAdvertisementModal createAdvrtmntFormIsVisible() {
        header.shouldBe(visible);
        pic.shouldBe(visible);
        labelName.shouldBe(visible);
        labelPrice.shouldBe(visible);
        labelDescription.shouldBe(visible);
        labelUrl.shouldBe(visible);
        submitButton.shouldBe(visible);
        return this;
    }

    public SelenideElement getErrorMessageForEmptyField(SelenideElement fieldName) {
        return fieldName.$x("following::div[@aria-live='polite' and text()='" + errorText +"']");
    }
}
