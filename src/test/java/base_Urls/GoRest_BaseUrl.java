package base_Urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class GoRest_BaseUrl {
    protected RequestSpecification spec;

    @BeforeMethod
    public void setup(){
        System.out.println("Burada  @Before anatosyonlu setup metodu çalıştı");
        spec= new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://gorest.co.in/public/v2").build();
    }
}
