package met.office.api.steps;

import io.restassured.response.ValidatableResponse;
import met.office.api.constants.EndPoints;
import met.office.api.constants.Path;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class MetSteps {

    @Step
    public ValidatableResponse getSiteListInfo() {
        return SerenityRest.given()
                .when()
                .get(EndPoints.GET_ALL_SITELIST)
                .then();
    }
    @Step
    public ValidatableResponse getLocationInfo(String locationId  ){
        System.out.println("Printing Location Id"+ locationId   );

        return SerenityRest.given()
         //       .pathParams("key","258969c4-6bf7-4c78-87a2-109d843987aa","res","3hourly")
                .when()
                .get("/val/wxfcs/all/json/"+locationId+"/?res=3hourly&key=258969c4-6bf7-4c78-87a2-109d843987aa")
                .then().log().all();
    }
}
