package Homework;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.hamcrest.Matchers.equalTo;

/*
       Given
         https://reqres.in/api/unknown/3
       When
           User send a GET request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response content type is "application/json; charset=utf-8"
       And
           Response body should be like;(Soft Assertion)
       {
       "data": {
           "id": 3,
           "name": "true red",
           "year": 2002,
           "color": "#BF1932",
           "pantone_value": "19-1664"
       },
       "support": {
           "url": "https://reqres.in/#support-heading",
           "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
       }
}
     */
public class Homework06 {
    @Test
    public void homework() {


        Response response = RestAssured.get("https://reqres.in/api/unknown/3");
        response.then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");

        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.getInt("id");
        String name = jsonPath.getString("name");
        int year = jsonPath.getInt("year");
        String color = jsonPath.getString("color");
        String pantone_value = jsonPath.getString("pantone_value");
        String url = jsonPath.getString("url");
        String text = jsonPath.getString("text");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(id, " 3");
        softAssert.assertEquals(name,"true red");
        softAssert.assertEquals(year,"2002");
        softAssert.assertEquals(color,"#BF1932");
        softAssert.assertEquals(pantone_value,"19-1664");
        softAssert.assertEquals(url,"https://reqres.in/#support-heading");
        softAssert.assertEquals(text,"To keep ReqRes free, contributions towards server costs are appreciated!");
        softAssert.assertAll();




    }
}
