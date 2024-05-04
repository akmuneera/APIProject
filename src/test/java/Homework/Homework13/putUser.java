package Homework.Homework13;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class putUser extends homework {

        @Test
        public void putUser() {

            Data.setFirstName("Nora");
            Data.setEmail("Nora@gmail.com");

            System.out.println("Data = " + Data);

            Response response = given()
                    .contentType(ContentType.JSON)
                    .body(Data)
                    .put(url + "/" + Data.getUsername());
            response.prettyPrint();
            response
                    .then()
                    .assertThat()
                    .body("code", equalTo(response.getStatusCode())
                            , "type", equalTo(type)
                            , "message", equalTo(Data.getId() + "")
                    );

        }


    }
