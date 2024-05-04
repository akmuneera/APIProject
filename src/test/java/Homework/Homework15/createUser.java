package Homework.Homework15;
import base_urls.Homework15BaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import POJO.UserContactsPojo;
import utilities.ObjectMapperUtils;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class createUser extends Homework15BaseUrl {
        public static String userId;
        public static String token = "";
        public static int version;
        public static UserContactsPojo expectedData;
        @Test
        public void createUser() {

            spec.pathParam("first", "users");


            String strJson = """
                {
                    "firstName": "Muneera",
                    "lastName": "Alali",
                    "email": "muneera@gmail.com",
                    "password": "password234"
                }""";

            expectedData = ObjectMapperUtils.convertJsonToPojo(strJson, UserContactsPojo.class);


            Response response = given(spec).body(expectedData).post("{first}");
            response.prettyPrint();

            userId = response.jsonPath().getString("user._id");
            token = response.jsonPath().getString("token");
            version = response.jsonPath().getInt("user.__v");

            response
                    .then()
                    .assertThat()
                    .statusCode(201)
                    .body("user.firstName", equalTo(expectedData.getFirstName()),
                            "user.lastName",equalTo(expectedData.getLastName()),
                            "user.email",equalTo(expectedData.getEmail()));


        }
    }
