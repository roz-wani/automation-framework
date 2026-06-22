package api;

import base.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RequestSpec;

public class UpdateUserTest extends BaseAPI {

    @Test
    public void updateUser() {

        User user = new User();

        user.setName("Wani Updated");
        user.setJob("Senior QA");

        Response response = RestAssured
                .given()
                .spec(RequestSpec.getRequestSpec())
                .body(user)
                .when()
                .put("/users/1");

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
