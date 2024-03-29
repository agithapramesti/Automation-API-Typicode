package api;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.serenitybdd.core.pages.PageObject;
import stepDefinition.TypicodeSteps;

import java.util.logging.Logger;

import static net.serenitybdd.rest.SerenityRest.given;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypicodeController extends PageObject {

    private Response response;
    Logger logger = Logger.getLogger(TypicodeController.class.getName());

    public Response sendGetTypicode() {
        Response response = given().log().all()
                .header("content-type", "application/json")
                .header("charset", "UTF-8")
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        logger.info("Get Typicode Response: ");
        response.getBody().prettyPrint();
        return response;
    }
}
