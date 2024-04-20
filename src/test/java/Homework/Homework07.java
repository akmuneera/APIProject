package Homework;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/*
      Given
             https://reqres.in/api/unknown/
      When
           I send GET Request to the URL
      Then

           1)Status code is 200
           2)Print all pantone_values
           3)Print all ids greater than 3 on the console
             Assert that there are 3 ids greater than 3
           4)Print all names whose ids are less than 3 on the console
             Assert that the number of names whose ids are less than 3 is 2
   */
public class Homework07 {
    @Test
    public void homework(){
        Response response = RestAssured.get("https://reqres.in/api/unknown/");
        JsonPath jsonPath = response.jsonPath();
        response.then()
                .statusCode(200);

        String pantoneValues = response.jsonPath().getString("data.pantone_value");
        System.out.println("Pantone Values: " + pantoneValues);

        List<Integer> idsGreaterThan3 = response.jsonPath().getList("data.findAll { it.id > 3 }.id");
        System.out.println("IDs greater than 3: " + idsGreaterThan3);
        assertEquals(idsGreaterThan3.size(), 3, "There should be 3 IDs greater than 3");



        List<String> names = response.jsonPath().getList("data.findAll { it.id < 3 }.name");
        System.out.println("Names with IDs less than 3: " + names);
        assertEquals(names.size(), 2, "There should be 2 names with IDs less than 3");
    }
}
