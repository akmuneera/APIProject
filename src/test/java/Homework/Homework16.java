package Homework;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class Homework16 {
        private static final String BASE_URL = "https://documenter.getpostman.com/view/4012288/TzK2bEa8";

        @Test
        public void homework() {
            // Add a new contact
            RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body("{\"name\": \"John Doe\", \"email\": \"john.doe@example.com\"}")
                    .post(BASE_URL + "/contacts")
                    .then()
                    .statusCode(201);

            // Read the created contact
            RestAssured.given()
                    .get(BASE_URL + "/contacts/{123}", "123")
                    .then()
                    .statusCode(200)
                    .body("name", equalTo("John Doe"));

            // Update the contact
            RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body("{\"name\": \"Updated Name\"}")
                    .put(BASE_URL + "/contacts/{123}", "123")
                    .then()
                    .statusCode(200);

            // Delete the contact
            RestAssured.given()
                    .delete(BASE_URL + "/contacts/{123}", "123")
                    .then()
                    .statusCode(204);

            // Negative assertion: Verify the deleted contact doesn't exist
            RestAssured.given()
                    .get(BASE_URL + "/contacts/{123}", "123")
                    .then()
                    .statusCode(404);
        }
    }

