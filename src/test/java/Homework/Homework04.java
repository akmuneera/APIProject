package Homework;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

/*
      Given
          https://reqres.in/api/users/2
      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
      And
          Response format should be "application/json"
      And
          "email" is "janet.weaver@reqres.in",
      And
          "first_name" is "Janet"
      And
          "last_name" is "Weaver"
      And
          "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
   */
public class Homework04 {
    public static void main(String[] args) {

        Response response = RestAssured.get("https://reqres.in/api/users/2");
        response
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("email", equalTo("janet.weaver@reqres.in"))
                .body("first_name", equalTo("Janet"))
                .body("last_name",equalTo("Weaver"))
                .body("text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }


}
