package Homework.Homework15;
import base_urls.Homework15BaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static Homework.Homework15.createUser.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class updateUser extends Homework15BaseUrl {

        @Test
        public void updateUser() {
            spec.pathParams("first", "users","second","me");

            String strJson = """
                {
                    "firstName": "Muneera",
                    "lastName": "Alali",
                    "email": "muneera@gmail.com",
                    "password": "password234"
                }""";

            expectedData.setFirstName("Nora");
            expectedData.setLastName("Alali");

            Response response = given(spec).body(expectedData).patch("{first}/{second}");
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

