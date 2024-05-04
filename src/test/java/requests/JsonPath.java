package requests;

import base_urls.BookerBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class JsonPath extends BookerBaseUrl {
    @Test
    public void jsonPathTest() {


        //Set the url
        spec.pathParams("first","booking", "second","656");

        //Set the expected data

        //Send the request and get the response
       Response response = given(spec).get("{first}/{second}");
       response.prettyPrint();

       //Do assertion
        // 1st way
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Josh"),
                        "lastname", equalTo("Allen"));
        //2nd way
        //Convert response to JsonPath object
        io.restassured.path.json.JsonPath jsonPath = response.jsonPath();

        //retrieve the desired data from json object by using Jsonpath object
        String firstname = jsonPath.getString("firstname");
        String lastname = jsonPath.getString("lastname");
        int totalprice = jsonPath.getInt("totalprice");
        boolean depositpaid = jsonPath.getBoolean("depositpaid");
        String checkin = jsonPath.getString("bookingdates.checkin");
        String checkout = jsonPath.getString("bookingdates.checkout");
        String additionalneeds = jsonPath.getString("additionalneeds");


        assertEquals(firstname,"Josh");
        assertEquals(lastname, "Allen");
        assertEquals(totalprice, 111);
        assertTrue(depositpaid);
        assertEquals(checkin, "2018-01-01");
        assertEquals(checkout,"2019-01-01");
        assertEquals(additionalneeds, "midnight snack");

    }
}