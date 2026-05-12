package api;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserTest {

    @Test
    public void  createUser() {

        String requestBody = "{\"name\": \"wani\", \"job\": \"QA Engineer\"}";

        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("https://jsonplaceholder.typicode.com/posts");

        System.out.println(response.asPrettyString());

        String name = response.jsonPath().getString("name");

        Assert.assertEquals(name, "wani");
    }
}
