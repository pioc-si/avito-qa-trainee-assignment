package tests.utils;

import com.codeborne.selenide.WebDriverRunner;

public class AdvertisementNumber {

    public static String getAdvertisementNumber() {
        String url = WebDriverRunner.getWebDriver().getCurrentUrl();
        return url.replaceAll(".*/advertisements/([^/?]+).*", "$1");
    }

}
