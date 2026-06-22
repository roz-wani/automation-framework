package api;

import base.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.RequestSpec;

import java.util.List;

public class GetAllUsersDeserializationTest extends BaseAPI {

    @BeforeMethod
    public void start() {
        setupAPI();
    }

    @Test
    public void getAllUsers() {

        Response response = RestAssured
                .given()
                .spec(RequestSpec.getRequestSpec())
                .when()
                .get("/users");

        List<User> users =
                response.jsonPath()
                        .getList("", User.class);

        System.out.println("Total Users : " + users.size());

        User firstUser = users.get(0);

        System.out.println("Name : " + firstUser.getName());
        System.out.println("Email : " + firstUser.getEmail());

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
