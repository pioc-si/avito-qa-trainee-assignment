package tests.ui;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import tests.ui.generators.TestDataStorage;

public class BaseUiTest {
    protected ChromeOptions options = new ChromeOptions();
    protected WebDriver driver;
    protected SoftAssertions softAssertion;
    public static TestDataStorage testDataStorage;


    public void setUpUiTests(ChromeOptions chromeOptions) {
        WebDriverManager.chromedriver().setup();
        Configuration.browserCapabilities = chromeOptions;
        Configuration.baseUrl="http://tech-avito-intern.jumpingcrab.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 120000;
        Configuration.timeout = 30000;
        Configuration.holdBrowserOpen = false;
        Configuration.headless = false;
    }

    @BeforeMethod
    public void beforeEachTest() {
        softAssertion = new SoftAssertions();
        setUpUiTests(options);
        testDataStorage = TestDataStorage.getStorage();
    }

    @AfterMethod
    public void afterEachTest() {
        softAssertion.assertAll();
        if (driver != null) {
            driver.quit();
        }
    }


}
