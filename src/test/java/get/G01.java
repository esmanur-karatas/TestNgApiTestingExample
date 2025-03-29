package get;

import io.restassured.response.Response;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class G01 {

    @Test
    public void getPetTest() {

                /*
        https://petstore.swagger.io/v2/pet/9 adresine git
        StatusCode 200
        Content-Type application/json
        statusLine HTTP/1.1 200 OK
        Connection keep-alive
        Time 800'den küçük
         */
        //1- End point olustur url gitmek için
        String endPoint = "https://petstore.swagger.io/v2/pet/9";

        //2- GET request olustururuz given ile endpointteki veriler gelsin diye
        //given().get(endPoint);

        //3- Response olustururuz gelen verileri bir kaba koymak için response oluşturduk.
        Response response = given().get(endPoint);

        //4- içindeki veriyi görmek için prettyPrint() kullanırız.
        response.prettyPrint();

        //5- Status Code' un 200 olduğunu doğrula
        int expectedStatusCode = 200;
        int actualStatusCode = response.statusCode();
        assertEquals(expectedStatusCode, actualStatusCode);

        //6- Content Type' ın application/json olduğunu doğrula
        String expectedContentType = "application/json";
        String actualContentType = response.contentType();
        assertEquals(expectedContentType, actualContentType);

        //statusLine'ın HTTP/1.1 200 OK olduğunu doğrula
        String expectedStatusLine="HTTP/1.1 200 OK";
        String actualStatusLine= response.statusLine();
        assertEquals(expectedStatusLine, actualStatusLine);

        //8- Connection'ın keep-alive oldugunu dogrula
        String expectedConnection= "keep-alive";
        String actualConnection= response.header("Connection");
        assertEquals(expectedConnection, actualConnection);

        //9-Time'ın 800'den küçük oldugunu dogrula
        int expectedTime= 800;
        int actualTime= (int) response.getTime();
        if (actualTime<expectedTime){
            System.out.println("Test passed!");
        }else {
            System.out.println("Test failed! " + actualTime + " saniyede döndü.");
        }
    }
}
