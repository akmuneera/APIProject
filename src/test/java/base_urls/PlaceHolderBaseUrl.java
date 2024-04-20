package base_urls;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

    public class PlaceHolderBaseUrl {

            protected RequestSpecification spec;

            @BeforeMethod
            public void setSpec() {

                spec = new RequestSpecBuilder()
                        .setBaseUri("https://reqres.in/api/users")
                        .setContentType(ContentType.JSON)
                        .build();

            }

        }




