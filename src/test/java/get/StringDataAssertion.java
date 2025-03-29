package get;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class StringDataAssertion {

    @Test
    public void testInvalidTodo() {
             /*
    https://jsonplaceholder.typicode.com/todos/gfhrr756
    User send GET Request to the URL
    Response format should be “application/json”
    HTTP Status Code should be 404
    todos should be empty
     */

        //1- Set the URL
        String url = "https://jsonplaceholder.typicode.com/todos/gfhrr756";

        //2- Send the request and get the response
        Response response = given().get(url);
        response.prettyPrint();

        //3- Do assertions
        response.then()
                .statusCode(404)
                .contentType("application/json");

        String expected = "{}";
        String actual = response.asString();
        assertEquals(expected, actual);

    }

    @Test
    public void testInvalidBooking() {
         /*
    https://restful-booker.herokuapp.com/booking/123437
    User send GET Request to the URL
    Response format should be “text/plain”
    HTTP Status Code should be 404
    HTTP Status Line should be "HTTP/1.1 404 Not Found"
    todos should be "Not Found"
     */
        //1-Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/123437";

        //2- Send request and get response
        Response response = given().get(url);
        response.prettyPrint();

        //3- Do assertions
        response.then()
                .statusCode(404)
                .contentType("text/plain")
                .statusLine("HTTP/1.1 404 Not Found");

        String actualText = response.asString();
        String expectedText = "Not Found";
        assertEquals(expectedText, actualText);


    }
}
