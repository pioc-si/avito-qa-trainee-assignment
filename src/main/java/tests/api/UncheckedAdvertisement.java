package tests.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tests.ui.Advertisement;
import static io.restassured.RestAssured.given;
import static tests.ui.pages.AdvertisementsPage.ADVERTISEMENTS_URL;
import static tests.ui.pages.BasePage.BASE_URL;
import static tests.utils.AdvertisementNumber.getAdvertisementNumber;

public class UncheckedAdvertisement implements CrudInterface {
    private final RequestSpecification spec;

    public UncheckedAdvertisement(RequestSpecification spec) {
        this.spec = spec;
    }

    @Override
    public void create() {
    }

    @Override
    public Response read() {
        String AdvertisementNumber = getAdvertisementNumber();
        return given()
                .spec(spec)
                .get(BASE_URL + "/api" + ADVERTISEMENTS_URL + AdvertisementNumber);
    }

    @Override
    public void update() {
    }

}
