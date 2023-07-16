package met.office.api.steps;

import io.restassured.response.ValidatableResponse;
import met.office.api.constants.EndPoints;
import met.office.api.constants.Path;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class MetSteps {

    @Step
    public ValidatableResponse getSiteListInfo() {
        return SerenityRest.given()
                .when()
                .get(EndPoints.GET_ALL_SITELIST)
                .then();
    }
    @Step
    public ValidatableResponse getLocationInfo(String locationId ){
        return SerenityRest.given()
                .when()
                .get(EndPoints.GET_FORECAST_DATA,locationId)
                .then().log().all();

    }
}
