package requests;

import base_urls.PlaceHolderBaseUrl;
import org.testng.annotations.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.Map;

public class PatchRequest extends PlaceHolderBaseUrl {
    @Test
    public void patchRequestTest(){
        spec.pathParams("first", "todos", "second", "198");

        Map<String, Object> expectedData = JsonPlaceHolderTestData.expectedDataMap(null,"Read Books", null);
        System.out.println("expectedData = " + expectedData);
    }
}
