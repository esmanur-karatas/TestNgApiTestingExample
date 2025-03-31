package get;

import base_Urls.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertEquals;

public class HeaderAssertRestAssured extends HerokuappBaseUrl {
    @Test
    public void HeaderAssertRestAssuredTest() {
            /*
 https://restful-booker.herokuapp.com/booking/34
 HTTP Status Code'unun 200
 Content Type'ın "application/json; charset=utf-8"
 Status Line'ın "HTTP/1.1 200 OK"
 Server'ın' "Cowboy"
 Connection'ın "keep-alive"
 oldugunu dogrular
*/
        //2 Ayrı yöntemle testimizi yazdık.

        //enpoint oluştur.
        String endpoint = " https://restful-booker.herokuapp.com/booking/34";

        //2- Send the request and get the response
        Response response = given().get(endpoint);
        response.prettyPrint();

        //System.out.println(response.time());
        //3- Do assertion
       // response.then() // rest assure da assertionlari then ile yapariz
                //.statusCode(200)
                //.contentType("application/json; charset=utf-8")
//                .statusLine("HTTP/1.1 200 OK")
//                .statusLine(containsString("OK"))
//                .header("Server", "Cowboy")
//                .header("Connection", "keep-alive")
//                .time(lessThan(5000L));

    }

    @Test
    public void HeaderAssertRestAssuredTest_02() {
        //set url
        specificationHereoku.pathParams("first", "booking", "second", 34);

        //3- send request and get response
        Response response = given(specificationHereoku).get("{first}/{second}");
        response.prettyPrint();

        //do assertion
        //response.then() // rest assure da assertionlari then ile yapariz
                //.statusCode(200)
//                .contentType(ContentType.JSON)
//                .body("firstname", equalTo("Jane"),
//                        "lastname", equalTo("Doe"),
//                        "totalprice", equalTo(111),
//                        "depositpaid", equalTo(true),
//                        "bookingdates.checkin", equalTo("2018-01-01"),
//                        "bookingdates.checkout", equalTo("2019-01-01"));
    }
}