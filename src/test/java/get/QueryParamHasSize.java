package get;

import base_Urls.PetStore_BaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class QueryParamHasSize extends PetStore_BaseUrl{
/*
 https://petstore.swagger.io/ dokumanını kullanarak statüsü "available" olan "pet"
    sayısını bulup 100'den fazla olduğunu assert eden bir otomasyon testi yazınız.


 */

    @Test
    public void QueryParamHasSizeTest() {
        //1- Set the url
        //status=available
        spec.pathParams("a", "pet", "b", "findByStatus")
                .queryParam("status", "available");

        //2- Send the request and get the response
        Response response= given(spec).get("{a}/{b}");
        response.prettyPrint();

        //3- Do assertion
        assertEquals(200, response.statusCode());

        int availablePet= response.jsonPath().getList("id").size();
        System.out.println("availablePet = " + availablePet);
        assertTrue(availablePet>100);

        //2.yol hasSize
        response.then()
                .statusCode(200)
                .body("id", hasSize(greaterThan(100)));


    }
}
