package Homework.Homework15;

import base_urls.Homework15BaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static Homework.Homework15.createUser.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class readUser extends Homework15BaseUrl{

        @Test
        public void getUser() {
            spec.pathParams("first", "users","second","me");

            Response response = given(spec).get("{first}/{second}");
            response.prettyPrint();
            response
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .body("_id",equalTo(userId),
                            "firstName", equalTo(expectedData.getFirstName()),
                            "lastName",equalTo(expectedData.getLastName()),
                            "email",equalTo(expectedData.getEmail()),
                            "__v",equalTo(version));


        }
    }

