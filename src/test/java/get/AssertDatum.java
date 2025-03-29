package get;

import base_Urls.Jsonplaceholder_BaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

public class AssertDatum extends Jsonplaceholder_BaseUrl {
      /*
        Given
            https://jsonplaceholder.typicode.com/users
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "application/json"
        And
            Status Line should be HTTP/1.1 200 OK
        And
            name should be "Leanne Graham"
        And
            email should be "Sincere@april.biz"
        And
            city should be "Gwenborough"
        And
            company names should be "Romaguera-Crona", "Deckow-Crist"
     */

    @Test
    public void testName() {
        //1- Set the url
        spec.pathParam("first", "users");

        //2- Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //3-Do assertion
        response.then()
                .statusCode(200)
                .contentType("application/json")
                .statusLine("HTTP/1.1 200 OK")
                .body("name", hasItem("Leanne Graham"),
                        "email", hasItem("Sincere@april.biz"),
                        "address.city", hasItem("Gwenborough"),
                        "company.name", hasItems("Romaguera-Crona", "Deckow-Crist"));
    }
}