package Homework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

/*
     Given
         https://reqres.in/api/users/23
     When
         User send a GET Request to the url
     Then
         HTTP Status code should be 404
     And
         Status Line should be HTTP/1.1 404 Not Found
     And
         Server is "cloudflare"
     And
         Response body should be empty
  */
public class Homework05 {


    @Test
    public void homework(){

    Response response = RestAssured.get("https://reqres.in/api/users/23");
        response.then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server", equalTo("cloudflare"))
                .body (equalTo("{}"));

    }
}
