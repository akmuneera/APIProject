package requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AssertHeaderAndBody {

/*
   Given
       https://restful-booker.herokuapp.com/booking/0
   When
       User sends a GET Request to the URL
   Then
       HTTP Status code should be 404
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Response body contains "Not Found"
   And
       Response body does not contain "Clarusway"
   And
       Server is "Cowboy"
*/

    @Test
    public void assertionMethod() {
//        https://restful-booker.herokuapp.com/booking/0

//        User sends a GET Request to the URL
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/0");
        response.prettyPrint();

//        HTTP Status code should be 404

        //1st way:
        response.then().statusCode(404);
        //2nd way:
        int statusCode = response.statusCode();
        assertEquals(statusCode, 404);

//        Status Line should be HTTP/1.1 404 Not Found

//        Response body contains "Not Found"

//        Response body does not contain "Clarusway"

//        Server is "Cowboy"


    }


}