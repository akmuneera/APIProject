package Homework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

/*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12

    Note: Print using JsonPath: response.jsonPath().prettyPrint();

*/
public class Homework11 {
    @Test
    public void homework(){
        RestAssured.baseURI = "https://automationexercise.com/api";

        // Send GET request to retrieve the products list
        Response response = RestAssured.given()
                .get("/productsList");

        // Validate response (you can add more assertions as needed)
        response.then()
                .statusCode(200);

        // Get the count of "Women" user types
        int womenUserTypeCount = response.jsonPath().getList("products.findAll { it.category.usertype.usertype == 'Women' }").size();

        // Assert that there are 12 "Women" user types
        assert womenUserTypeCount == 12 : "Expected 12 Women user types, but found: " + womenUserTypeCount;

        // Print response body
        response.jsonPath().prettyPrint();

    }
}
