package api;

import base.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.JsonUtil;
import utils.RequestSpec;

import java.util.List;

public class MultiUserTest extends BaseAPI {

    @Test
    public void createMultipleUsers() throws Exception {

        List<User> users = JsonUtil.readJsonList(
                "src/test/resources/user.json",
                User.class);

        for (User user : users) {

            SoftAssert softAssert = new SoftAssert();

            Response response = RestAssured
                    .given()
                    .spec(RequestSpec.getRequestSpec())
                    .body(user)
                    .when()
                    .post("/users");

            System.out.println("Full Response:");
            System.out.println(response.asPrettyString());

            System.out.println("Expected Name :" + user.getName());
            System.out.println("Actual Name : " + response.jsonPath().getString("name"));

            System.out.println("Expected Job : " + user.getJob());
            System.out.println("Actual Job : " + response.jsonPath().getString("job"));

            System.out.println("ID =" + response.jsonPath().getString("id"));
            //System.out.println("createdAt =" + response.jsonPath().getString("createdAt"));

            softAssert.assertEquals(
                    response.getStatusCode(), 201);

            softAssert.assertEquals(
                    response.jsonPath().getString("name"),
                    user.getName());

            softAssert.assertEquals(
                    response.jsonPath().getString("job"),
                    user.getJob());

            softAssert.assertNotNull(
                    response.jsonPath().getString("id"));

            softAssert.assertAll();

            //Assert.assertNotNull(response.jsonPath().getString("createdAt"));
        }
    }

}
