package met.office.api.metsteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import met.office.api.steps.MetSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasValue;

public class StepsDef {
    static ValidatableResponse response;
     static List<Integer> locationId;
    @Steps
    MetSteps metSteps;
    @Given("^I am on MetOffice Webpage$")
    public void iAmOnMetOfficeWebpage() {
    }

    @When("^I send request to get all sitelist endpoint data for the daily and three-hourly forecast data$")
    public void iSendRequestToGetAllSitelistEndpointDataForTheDailyAndThreeHourlyForecastData() {
        response= metSteps.getSiteListInfo();

    }

    @Then("^I should able to get a valid status code (\\d+)$")
    public void iShouldAbleToGetAValidStatusCode(int arg0) {
        response.statusCode(200);
    }

    @And("^I should navigate this list and find the Location ID for \"([^\"]*)\"\\.$")
    public void iShouldNavigateThisListAndFindTheLocationIDFor(String locationName)
            {
               response.body("Locations.Location.name",hasItem(locationName));
//                List<Integer> id = response.extract().path("Locations.Location.findAll{it.name =='Croydon'}.id");
            locationId =response.extract().path("Locations.Location.findAll{it.name == locationName}.id");
//                System.out.println("Croydon"+ locationId);
//                System.out.println("Printing Location Id"+locationId);
    }

    @And("^I have access the correct location$")
    public void iHaveAccessTheCorrectLocation() {
//        List<Integer> id = response.extract().path("Locations.Location.findAll{it.name =='Croydon'}.id");
      System.out.println("Croydon"+ locationId);
//     Assert.assertTrue(locationId.contains(locationId));
    }

    @And("^I get the parameter with name ‘S’ has a description of wind speed\\.$")
    public void iGetTheParameterWithNameSHasADescriptionOfWindSpeed() {

    }
}