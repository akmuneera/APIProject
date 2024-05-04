package Homework.Homework13;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class deleteUser extends homework {
        @Test()
        public void deleteUser() {

            Response response = given()
                    .body(Data)
                    .contentType(ContentType.JSON)
                    .delete(url + "/" + Data.getUsername());
            response.prettyPrint();

            response
                    .then()
                    .assertThat()
                    .body("code", equalTo(response.getStatusCode())
                            , "type", equalTo(type)
                            , "message", equalTo(Data.getUsername())
                    );
        }


    }
