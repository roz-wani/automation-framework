package api;

import base.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RequestSpec;
import utils.JsonUtil;
import utils.ResponseSpec;

public class CreateUserTest extends BaseAPI {

    @Test
    public void createUser() throws Exception {

        User user = JsonUtil.readJson(
                "src/test/resources/user.json",
                User.class);

        Response createResponse = RestAssured
                .given()
                .spec(RequestSpec.getRequestSpec())
                .body(user)
                .when()
                .post("/users");

        createResponse.then()
                .spec(ResponseSpec.getResponseSpec201());

        System.out.println(createResponse.asPrettyString());

    }
}
