package base_Urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class GoRest_BaseUrl02 {
    public static RequestSpecification setupUrl(){
        System.out.println("Burada GoRest_BaseUrl02 clasındaki setupUrl() metodu çalıştı");
        RequestSpecification spec= new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://gorest.co.in/public/v2").build();
        return spec;
    }
}
