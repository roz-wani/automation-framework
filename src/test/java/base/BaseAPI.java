package base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {

    protected RequestSpecification request;

    public void setupAPI() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        request = RestAssured
                .given()
                .contentType("application/json");

    }
}
