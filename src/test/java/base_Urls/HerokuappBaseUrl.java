package base_Urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class HerokuappBaseUrl {
    protected RequestSpecification specificationHereoku;

    @BeforeMethod
            public void setUp(){
        specificationHereoku = new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .addHeader("Accept","application/json")
                .setBaseUri("https://restful-booker.herokuapp.com")
                .build();
    }

}
