package Homework;


import POJO.*;
import base_urls.PlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

//Write an automation test that will create, read, update, delete a 'pet' using the "https://petstore.swagger.io/" document
//(All actions must be done on same pet)
     //   (Use Pojo)


public class Homework12 extends PlaceHolderBaseUrl {

    @Test
    public void postPet(){
        spec.pathParams("first", "v2", "second","pet");

        petCategory petCategory = new petCategory(123,"cat");
        String[] photoUrlsArray = { "cute", "fluffy", "adorable" };
        petTags[] petTagsArray = { new petTags(123, "tag one") };
        petStore expectedData = new petStore(123, petCategory, "kitten", photoUrlsArray, petTagsArray, "not yet adopted");

        System.out.println("expectedData = " + expectedData);


        Response response = given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();


        petStore actualData = response.as(petStore.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getId(), expectedData.getId());
        assertEquals(actualData.getCategory().getId(), expectedData.getCategory().getId());
        assertEquals(actualData.getCategory().getName(), expectedData.getCategory().getName());
        assertEquals(actualData.getName(), expectedData.getName());
        assertEquals(actualData.getPhotoUrls(), expectedData.getPhotoUrls());
        assertEquals(actualData.getStatus(), expectedData.getStatus());

    }

    @Test
    public void readPet() {

        spec.pathParams("first", "v2", "second","pet");


        petCategory petCategory = new petCategory(1,"dog");
        String[] photoUrlsArray = { "string1", "string2", "string3" };
        petTags[] petTagsArray = { new petTags(1, "tag1") };
        petStore expectedData = new petStore(1, petCategory, "doggie", photoUrlsArray, petTagsArray, "available");
        System.out.println("expectedData = " + expectedData);


        Response response = given(spec).get("{first}/{second}");//Parameters can be declared directly here
        response.prettyPrint();

        petStore actualData = response.as(petStore.class);
        System.out.println("actualData = " + actualData);


        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getId(), expectedData.getId());
        assertEquals(actualData.getCategory().getId(), expectedData.getCategory().getId());
        assertEquals(actualData.getCategory().getName(), expectedData.getCategory().getName());
        assertEquals(actualData.getName(), expectedData.getName());
        assertEquals(actualData.getPhotoUrls(), expectedData.getPhotoUrls());
        assertEquals(actualData.getStatus(), expectedData.getStatus());

    }
    @Test
    public void updatePet() {

        spec.pathParams("first", "v2", "second","pet");


        petCategory petCategory = new petCategory(1,"dog");
        String[] photoUrlsArray = { "string1", "string2", "string3" };
        petTags[] petTagsArray = { new petTags(1, "tag1") };
        petStore expectedData = new petStore(1, petCategory, "doggie", photoUrlsArray, petTagsArray, "available");
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();


        petStore actualData = response.as(petStore.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getId(), expectedData.getId());
        assertEquals(actualData.getCategory().getId(), expectedData.getCategory().getId());
        assertEquals(actualData.getCategory().getName(), expectedData.getCategory().getName());
        assertEquals(actualData.getName(), expectedData.getName());
        assertEquals(actualData.getPhotoUrls(), expectedData.getPhotoUrls());
        assertEquals(actualData.getStatus(), expectedData.getStatus());
    }
    @Test
    public void deletePet() {

        spec.pathParams("first", "v2", "second","pet", "third", "1");

        petStore expectedData = new petStore();
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).delete("{first}/{second}/{third}");
        response.prettyPrint();

        petStore actualData = response.as(petStore.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(),200);

    }

    }
