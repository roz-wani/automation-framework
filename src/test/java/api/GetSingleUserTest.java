package api;

import base.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;
import model.UserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleUserTest extends BaseAPI {

    @Test
    public void getSingleUser() {

        Response response = RestAssured
                .given()
                .when()
                .get("/users/1");

        UserResponse user = response.as(UserResponse.class);

        System.out.println("Name : " + user.getName());
        System.out.println("Username : " + user.getUsername());
        System.out.println("Email : " + user.getEmail());

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
