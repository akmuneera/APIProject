package Homework;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;



/*
Write an automation test that will create a 'user' using the "https://petstore.swagger.io/" document
*/
public class Homework09 {

    @Test
    public void homework(){

        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        String requestBody = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"myusername\",\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"email\": \"john.doe@example.com\",\n" +
                "  \"password\": \"mypassword\",\n" +
                "  \"phone\": \"1234567890\",\n" +
                "  \"userStatus\": 1\n" +
                "}";

        // Send POST request to create a new user
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/user");

        // Validate response
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

        // Print response body
        System.out.println("Response body: " + response.getBody().asString());

    }
}
