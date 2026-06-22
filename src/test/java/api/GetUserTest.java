package api;

import base.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.RequestSpec;
import utils.ResponseSpec;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetUserTest extends BaseAPI {

    @BeforeMethod
    public void start() {
        setupAPI();
    }

    @Test
    public void getUser() {

        Response response = RestAssured
                .given()
                .spec(RequestSpec.getRequestSpec())
                .when()
                .get("/users/1");

        response.then().log().all();

        response.then()
                .spec(ResponseSpec.getResponseSpec200());

        response.then()
                .body(matchesJsonSchemaInClasspath(
                        "schemas/user-schema.json"
                ));

        User user = response.as(User.class);

        System.out.println("Name : " + user.getName());
        System.out.println("Username : " + user.getUsername());
        System.out.println("Email : " + user.getEmail());
        System.out.println("City : " + user.getAddress().getCity());
        System.out.println("Zipcode : " + user.getAddress().getZipcode());

        Assert.assertEquals(user.getId(), 1);

        Assert.assertEquals(
                user.getName(),
                "Leanne Graham");

        Assert.assertEquals(
                user.getUsername(), "Bret");

        Assert.assertEquals(
                user.getEmail(), "Sincere@april.biz");

        Assert.assertEquals(
                user.getAddress().getCity(), "Gwenborough");

        Assert.assertEquals(
                user.getAddress().getZipcode(), "92998-3874");

    }
}