package tests.api;

import io.restassured.response.Response;
import tests.ui.Advertisement;

public interface CrudInterface {

    void create();

    Response read();

    void update();

}
