package get;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
public class G03 {
    // BU TESTTE TEK DATANIN BODYSİ ÜZERİNDE HAMCREST MATCHER İLE DOĞRULAMA YAPTIK
       /*
       https://jsonplaceholder.typicode.com/posts/1
  I send a GET request to the Url
    HTTP Status Code should be 200
    Response format (contentType) should be "application/json"
    "id" should be 1
    "title" should be "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body" should be "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto",
*/

    @Test
    public void testName() {
        //1- Set URL
        String url="https://jsonplaceholder.typicode.com/posts/1";

        //2- Send the request and get the response
        Response response= given().get(url);
        response.prettyPrint();

        //3-Do assertions
        //1.yol Tek datada dogrulama yolu eğer bir data da hata verirse bu yolda diğer dataları doğrulamıyor. buna hard assertion deniyor.
        response.then()
                .statusCode(200)
                .contentType("application/json")
                .body("id", equalTo(1))
                .body("title",equalTo( "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                .body("body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));

        //2.yol Tek datada dogrulama yolu bundaysa mesela body içinde bir hata verirse diğerlerini doğrulamaya devam ediyor hata vermiyor diğerlerini doğrulamadan
        response.then()
                .statusCode(200)
                .contentType("application/json")
                .body("id", equalTo(1)
                        ,"title",equalTo( "sunt aut facere repellat provident occaecati excepturi optio reprehenderit")
                        ,"body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));



    }
}
