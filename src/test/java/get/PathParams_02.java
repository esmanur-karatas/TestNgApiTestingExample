package get;

import base_Urls.RestCountries_BaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PathParams_02 extends RestCountries_BaseUrl {
    /*
            Given
                https://restcountries.com/v3.1/lang/turkish
            When
                User sends a GET Request to the url
            Then
                HTTP Status Code should be 200
            And
                Content Type should be "application/json"
           And
                official name should be "Republic of Turkey",
           And
                capital should be "Ankara"
           And
                region should be "Asia"
           And
                continents should be "Europe", "Asia"
         */

    @Test
    public void name() {
        spec.pathParams("first","lang", "second", "turkish");

        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        response.then()
                .statusCode(200)
                .contentType("application/json")
                .body("name.official", hasItem("Republic of Turkey"),
                        "capital", hasItem(hasItem("Ankara")),
                        "region", hasItem("Asia"),
                        "continents", hasItem(hasItem("Asia")));

    }
}