package Homework;

import base_urls.PlaceHolderBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

/*
      Given
          1) https://reqres.in/api/users
          2) {
              "name": "morpheus",
              "job": "leader"
              }
      When
          I send POST Request to the Url
      Then
          Status code is 201
          And response body should be like {
                                              "name": "morpheus",
                                              "job": "leader",
                                              "id": "496",
                                              "createdAt": "2022-10-04T15:18:56.372Z"
                                            }
   */
public class Homework08 extends PlaceHolderBaseUrl {
    @Test
    public void homework() {

            spec.pathParams("first", "");

            String expectedData = """
                                 {
                                 "name": "morpheus",
                                 "job": "leader"
                                 }
                                 """;
            Response response = given(spec)
                    .body(expectedData)
                    .post("{first}");

            response.prettyPrint();


            response
                    .then()
                    .statusCode(201)
                    .body("name", equalTo("morpheus"),
                            "job", equalTo("leader"));
        }

    }

