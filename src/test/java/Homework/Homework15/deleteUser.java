package Homework.Homework15;
import base_urls.Homework15BaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;
public class deleteUser extends Homework15BaseUrl {
        @Test
        public void deleteUser() {
            spec.pathParams("first", "users","second","me");

            Response response = given(spec).delete("{first}/{second}");
            response.prettyPrint();

            response
                    .then()
                    .assertThat()
                    .statusCode(200);
            assertTrue(response.asString().isEmpty());



        }
    }

