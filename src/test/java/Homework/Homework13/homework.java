package Homework.Homework13;
import org.testng.annotations.BeforeMethod;
import POJO.UserPetStorePojo;
import utilities.ObjectMapperUtils;
public class homework {


        UserPetStorePojo Data;
        String url = "https://petstore.swagger.io/v2/user";
        String type = "unknown";

        @BeforeMethod
        public void setUp() {

            String strJson =
                    """
                            {
                              "id": 123,
                              "username": "akmuneera",
                              "firstName": "Muneera",
                              "lastName": "AlAli",
                              "email": "akmuneera19@gmail.com",
                              "password": "password098",
                              "phone": "55555555",
                              "userStatus": "avaliable" 
                            }""";


            Data = ObjectMapperUtils.convertJsonToPojo(strJson, UserPetStorePojo.class);
        }



    }

