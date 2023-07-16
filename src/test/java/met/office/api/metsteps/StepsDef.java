package met.office.api.metsteps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Ar;
import io.restassured.response.ValidatableResponse;
import met.office.api.steps.MetSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasValue;

public class StepsDef {
    static ValidatableResponse response;
     public String locationId;
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



    @And("^I navigate sitelist and find the Location ID for \"([^\"]*)\"$")
    public void iNavigateSitelistAndFindTheLocationIDFor(String locationName)  {
        response.body("Locations.Location.name",hasItem(locationName));
        System.out.println("Location name"+locationName );
        ArrayList<String> id = response.extract().path("Locations.Location.findAll{it.name =='" +locationName+"'}.id");
        locationId=id.get(0);
        System.out.println("pring id"+id);

    }

    @And("^I query daily forecast data for the location ID$")
    public void iQueryDailyForecastDataForTheLocationID() {
        metSteps.getLocationInfo(locationId);
        ArrayList<?> windSpeed=  response.extract().path("SiteRep.Wx");
        System.out.println("Wind Speed"+windSpeed);
        System.out.println("Location id"+locationId);



    }
}