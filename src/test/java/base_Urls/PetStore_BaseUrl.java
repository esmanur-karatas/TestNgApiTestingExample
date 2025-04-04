package base_Urls;

import base.BaseTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class PetStore_BaseUrl extends BaseTest {
    protected RequestSpecification spec;

    @Before
    public void setup(){
        spec= new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2").build();
    }
}
