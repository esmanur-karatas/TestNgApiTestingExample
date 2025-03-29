package get;

import base_Urls.Reqres_BaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class PathParams extends Reqres_BaseUrl {
    /*
        Given
            https://reqres.in/api/users/5
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "application/json; charset=utf-8"
        And
            Status Line should be "HTTP/1.1 200 OK"
       And
            email should be "charles.morris@reqres.in",
       And
            text should be "To keep ReqRes free, contributions towards server costs are appreciated!"
     */


    @Test
    public void name() {
        //1- Set the url
        spec.pathParams("first", "users", "second",5);

        //2- Set the expected data

        //3- Send the request and get the response
        Response response= given(spec).get("{first}/{second}");
        response.prettyPrint();

        //4- Do assertion
        response.then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK")
                .body("data.email", equalTo("charles.morris@reqres.in"),
                        "support.text", equalTo("Tired of writing endless social media content? Let Content Caddy generate it for you."));
    }
}
