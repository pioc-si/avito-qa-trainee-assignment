package tests.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import lombok.Getter;
import lombok.Setter;
import tests.ui.elements.AdvertisementElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

@Getter
@Setter
public class AdvertisementPage extends BasePage {

    private SelenideElement divEditButton = $x("//div[contains(@class,'chakra-container')]/div[contains(@class,'chakra-container')]/div[1]");
    private SelenideElement svgElement = divEditButton.$(By.xpath("./*"));
    private ElementsCollection editAdvrtmntInputElements = $$x("//div[contains(@class,'chakra-container')]//div[contains(@class,'chakra-stack')]");
    private SelenideElement name = $x("//*[contains(@class,'chakra-heading')]");
    private SelenideElement price = $x("//*[contains(@class, 'chakra-heading')]/following-sibling::p[contains(@class, 'chakra-text')]");
    private SelenideElement description = $x("//header/following-sibling::div[contains(@class, 'chakra-stack')][1]//p[contains(@class, 'chakra-text')]");

    public AdvertisementPage() {
        waitUntilPageIsLoaded();
    }

    public List<AdvertisementElement> getAdvrtmntInputFields() {
        return getAdvrtmntInputFields(editAdvrtmntInputElements);
    }


}
