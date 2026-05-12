package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateUserTest {

    @Test
    public void updateUser() {

        String requestBody = "{\"name\": \"wani\", \"job\": \"Senior QA\"}";

        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("https://jsonplaceholder.typicode.com/posts/1");

        System.out.println(response.asPrettyString());

        int statusCode = response.getStatusCode();

        System.out.println("Status Code : " + statusCode);

        Assert.assertEquals(statusCode, 200);

        String updatedName = response.jsonPath().getString("name");

        Assert.assertEquals(updatedName, "wani");
    }
}
