package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserTest {

    @Test
    public void deleteUser() {

        Response response = RestAssured
                .given()
                .when()
                .delete("https://jsonplaceholder.typicode.com/posts/1");

        int statusCode = response.getStatusCode();

        System.out.println("Status Code : " + statusCode);

        Assert.assertEquals(statusCode, 200);
    }
}
