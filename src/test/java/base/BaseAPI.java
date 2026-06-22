package base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseAPI {

    @BeforeClass
    public void setupAPI() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

    }
}
