package base_Urls;

import base.BaseTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class Reqres_BaseUrl extends BaseTest {
    protected RequestSpecification spec;

    @Before
    public void setUp(){
        spec= new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri("https://reqres.in/api").build();
    }
}
