package Homework.Homework13;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class getUser extends homework {

        @Test()
        public void getUser() {
            System.out.println("Data = " + Data);

            Response response = given()
                    .contentType(ContentType.JSON)
                    .get(url + "/" + Data.getUsername());
            response.prettyPrint();

            response
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .body("id", equalTo(Data.getId())
                            , "username", equalTo(Data.getUsername())
                            , "firstName", equalTo(Data.getFirstName())
                            , "lastName", equalTo(Data.getLastName())
                            , "email", equalTo(Data.getEmail())
                            , "password", equalTo(Data.getPassword())
                            , "phone", equalTo(Data.getPhone())
                            , "userStatus", equalTo(0)
                    );
        }
}
