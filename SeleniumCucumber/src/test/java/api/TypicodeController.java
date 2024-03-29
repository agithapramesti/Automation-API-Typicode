package api;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.serenitybdd.core.pages.PageObject;

import java.util.logging.Logger;

import static net.serenitybdd.rest.SerenityRest.given;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypicodeController extends PageObject {

    Logger logger = Logger.getLogger(TypicodeController.class.getName());
    private Response response;
    private String title;
    private String body;
    private int userId;

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

    public Response postGetTypicode() {
        String requestBody = "{\"userId\":"+getUserId()+",\"title\":\""+getTitle()+"\"," +
                "\"body\":\""+getBody()+"\"}";

        Response response = given().log().all()
                .header("content-type", "application/json")
                .header("charset", "UTF-8")
                .body(String.format(requestBody,getUserId(),getTitle(),getBody()))
                .when()
                .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                .assertThat()
                .statusCode(201)
                .extract()
                .response();

        //HttpStatus.CREATED returns 201
        logger.info("Get Typicode Response: ");
        response.getBody().prettyPrint();
        return response;
    }
}
