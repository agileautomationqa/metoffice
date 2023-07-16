package met.office.api.steps;

import io.restassured.response.ValidatableResponse;
import met.office.api.constants.EndPoints;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class MetSteps {
    @Step
    public ValidatableResponse getSiteListInfo() {
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_SITELIST)
                .then().log().all();
    }
    @Step
    public ValidatableResponse getWindSpeedDiscriptions(){
        return SerenityRest.given()
                .when()
                .get(EndPoints.GET_WINDSPEED)
                .then().log().all();
    }
}
