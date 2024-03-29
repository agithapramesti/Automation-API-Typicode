package stepDefinition;
import api.TypicodeController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetTypicodeSteps {

    TypicodeController typicodeController;
    Logger logger = Logger.getLogger(GetTypicodeSteps.class.getName());

    @Given("^prepare a GET to typicode endpoint$")
    public void prepareAGETToTypicodeEndpoint() {
        //in this step, we can also put request (if needed)
        logger.info("preparation a GET to typicode endpoint");
    }

    @When("^send GET to typicode endpoint$")
    public void sendGETToTypicodeEndpoint() {
        Response getTypicodeResponse = typicodeController.sendGetTypicode();
        typicodeController.setResponse(getTypicodeResponse);
    }

    @Then("^receive GET response successfully with response code is \"([^\"]*)\"$")
    public void receiveGETResponseSuccessfullyWithResponseCodeIs(String responseCode) {
        int statusCodeExpected = Integer.parseInt(responseCode);
        int statusCodeActual = typicodeController.getResponse().getStatusCode();
        assertThat("status code is different with expected",
                statusCodeActual, equalTo(statusCodeExpected));
    }
}
