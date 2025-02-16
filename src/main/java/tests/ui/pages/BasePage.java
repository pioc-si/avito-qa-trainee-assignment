package tests.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import tests.ui.elements.AdvertisementElement;
import tests.ui.elements.HeaderElement;
import tests.ui.elements.PageElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    public static final String BASE_URL = "http://tech-avito-intern.jumpingcrab.com";
    private ElementsCollection headerElements = $$x("//img[contains(@src, '/logo.png')]/ancestor::div[contains(@class, 'chakra-stack')]");
    private SelenideElement pageLoader = $x("//div[@data-testid='three-circles-wrapper']");

    public List<AdvertisementElement> getAdvrtmntInputFields(ElementsCollection advrtmntInputElements) {
        return generatePageElements(advrtmntInputElements, AdvertisementElement::new);
    }


    public  <T extends PageElement> List<T> generatePageElements(
            ElementsCollection collection,
            Function<SelenideElement, T> creator) {
        var elements = new ArrayList<T>();
        collection.asDynamicIterable().forEach(webElement ->
                elements.add(creator.apply(webElement)));
        return elements;
    }

    public List<HeaderElement> getHeaderElements() {
        return generatePageElements(headerElements, HeaderElement::new);
    }

    public void waitUntilHeaderLogoIsDisplayed() {
        getHeaderElements().stream().reduce((first, second) -> first).get()
                .getLogo().shouldBe(visible, Duration.ofMinutes(2));
    }

    public void waitUntilPageIsLoaded() {
        pageLoader.shouldNotBe(visible, Duration.ofMinutes(1));
    }


}
