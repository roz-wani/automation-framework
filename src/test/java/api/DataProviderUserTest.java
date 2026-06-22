package api;

import base.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RequestSpec;
import utils.UserDataProvider;

public class DataProviderUserTest extends BaseAPI {

    @Test(dataProvider = "userData",
    dataProviderClass = UserDataProvider.class)
    public void createUser(User user) {

        Response response = RestAssured
                .given()
                .spec(RequestSpec.getRequestSpec())
                .body(user)
                .when()
                .post("/users");

        System.out.println("Testing User : " + user.getName());

        Assert.assertEquals(
                response.getStatusCode(), 201);

        Assert.assertEquals(
                response.jsonPath().getString("name"),
                user.getName());

        Assert.assertEquals(
                response.jsonPath().getString("job"),
                user.getJob());

    }
}
