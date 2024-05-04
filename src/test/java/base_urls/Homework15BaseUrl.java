package base_urls;
import Homework.Homework15.createUser;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
public class Homework15BaseUrl {


        protected RequestSpecification spec;

        @BeforeMethod
        public void setUp() {
            String token = createUser.token;
            System.out.println("token = " + token);
            spec = new RequestSpecBuilder()
                    .setBaseUri("https://thinking-tester-contact-list.herokuapp.com")
                    .addHeader("Authorization", "Bearer " + token)
                    .setContentType(ContentType.JSON)
                    .build();

        }
    }
