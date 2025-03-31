package get;
import base_Urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class NegativeTestHardAssertion extends HerokuappBaseUrl {

/*
Given
    https://restful-booker.herokuapp.com/booking/224234
When
    User send Get Request to the endpoint
Then
    Status Code is 404
And
    Status-text is "HTTP/1.1 404 Not Found"
And
    Response body include "Not Found"
And
    Response body does not include "Esmanur Karataş"
And
    Header Server is "Cowboy"
And
    Header Connection is "keep-alive"

*/
    @Test
    public void nativeTest(){
        //1- set the url  bu endpointe get talebi yapacagiz
        specificationHereoku.pathParams("first", "booking", "second", 224234);

        //3- send request and get response
        Response response = given(specificationHereoku).get("{first}/{second}");
        response.prettyPrint();

        //4- do assertion gelen response dogrulanacak
        response.then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .body(equalTo("Not Found"))
                .body(not("Esmanur Karataş"))
                .header("Server","Cowboy")
                .header("Connection", "keep-alive");

        assertEquals(404, response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found", response.getStatusLine());
        assertEquals("Not Found", response.getBody().asString());
        assertNotEquals("Hakan Kara", response.getBody().asString());
        assertEquals("Cowboy", response.getHeader("Server"));
        assertEquals("keep-alive", response.getHeader("Connection"));
    }
}
