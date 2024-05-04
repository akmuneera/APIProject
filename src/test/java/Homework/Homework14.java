package Homework;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class Homework14 {

        @Test
        public void test() {
            String url = "https://dummy.restapiexample.com/api/v1/employees";

            Response response = given()
                    .contentType("application/json")
                    .get(url);
            response.prettyPrint();

            response
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .body("data", hasSize(24),
                            "data.employee_name", hasItems("Tiger Nixon", "Garrett Winters")
                    );


            int age = response.jsonPath().getInt("data.employee_age.max()");
            System.out.println("age = " + age);

            int minAge = response.jsonPath().getInt("data.employee_age.min()");
            String name = response.jsonPath().getList("data.findAll{it.employee_age ==" + minAge + "}.employee_name").getFirst().toString();
            System.out.println("name = " + name);

            int salary = response.jsonPath().getInt("data.employee_salary.sum()");
            System.out.println("salary = " + salary);

            Assert.assertEquals(age, 66);
            Assert.assertEquals(name, "Tatyana Fitzpatrick");
            Assert.assertEquals(salary, 6644770);


        }
    }

