package stepDefinition;

import api.TypicodeController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CreateTypicodeSteps {

    TypicodeController typicodeController;
    Logger logger = Logger.getLogger(CreateTypicodeSteps.class.getName());


    @Given("^prepare create request data with title is \"([^\"]*)\"$")
    public void prepareCreateRequestDataWithTitleIs(String title) {
        typicodeController.setTitle(title);
    }

    @When("^prepare create request data with body is \"([^\"]*)\"$")
    public void prepareCreateRequestDataWithBodyIs(String body) {
        typicodeController.setBody(body);
    }

    @And("^prepare create request data with userId is \"([^\"]*)\"$")
    public void prepareCreateRequestDataWithUserIdIs(String userId) {
        typicodeController.setUserId(Integer.parseInt(userId));
    }

    @And("^send post to typicode endpoint")
    public void sendPostToTypicodeEndpoint() {
        Response postTypicodeResponse = typicodeController.postGetTypicode();
        typicodeController.setResponse(postTypicodeResponse);
    }

    @Then("^receive create response successfully with response code is \"([^\"]*)\"$")
    public void receiveCreateResponseSuccessfullyWithResponseCodeIs(String responseCode) {
        int statusCodeExpected = Integer.parseInt(responseCode);
        int statusCodeActual = typicodeController.getResponse().getStatusCode();
        assertThat("status code is different with expected",
                statusCodeActual, equalTo(statusCodeExpected));
    }

    @And("^create response with title should be \"([^\"]*)\"$")
    public void createResponseWithTitleShouldBe(String titleExpected) {
        String titleActual = typicodeController.getResponse().path("title");
        assertThat("response with title is different with expected",
                titleActual, equalTo(titleExpected));
    }

    @And("^create response with body should be \"([^\"]*)\"$")
    public void createResponseWithBodyShouldBe(String bodyExpected) {
        String bodyActual = typicodeController.getResponse().path("body");
        assertThat("response with body is different with expected",
                bodyActual, equalTo(bodyExpected));
    }

    @And("^create response with userId should be \"([^\"]*)\"$")
    public void createResponseWithUserIdShouldBe(String userId) {
        Integer userIdExpected = Integer.parseInt(userId);
        Integer userIdActual = typicodeController.getResponse().path("userId");
        assertThat("response with userId is different with expected",
                userIdActual, equalTo(userIdExpected));
    }

    @And("create response with id is not NULL")
    public void createResponseWithIdIsNotNULL() {
        Integer idActual = typicodeController.getResponse().path("id");
        assertThat("response id is NULL", idActual, notNullValue());
    }
}
