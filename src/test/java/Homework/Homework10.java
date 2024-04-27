package Homework;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

/**
 * Using the https://petstore.swagger.io/ document,
 * write an automation test that finds the number of "pets" with the status
 * "available" and asserts that there are more than 100.
 */
public class Homework10 {
    @Test
    public void homework(){

        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        // Send GET request to retrieve pets with status "available"
        Response response = RestAssured.given()
                .queryParam("status", "available")
                .get("/pet/findByStatus");

        // Validate response (you can add more assertions as needed)
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

        // Get the count of available pets
        int availablePetsCount = response.jsonPath().getList("id").size();

        // Assert that there are more than 100 available pets
        assert availablePetsCount > 100 : "Expected more than 100 available pets, but found: " + availablePetsCount;

    }
}
