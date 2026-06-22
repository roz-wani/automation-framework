package api;

import base.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.RequestSpec;

public class APIChainingTest extends BaseAPI {

    @BeforeMethod
    public void start() {
        setupAPI();
    }

    @Test
    public void apiChaining() {

        User user = new User();
        user.setName("Wani");
        user.setJob("QA Engineer");

        Response createResponse = RestAssured
                .given()
                .spec(RequestSpec.getRequestSpec())
                .body(user)
                .when()
                .post("/users");

        System.out.println(createResponse.asPrettyString());

        Assert.assertEquals(
                createResponse.getStatusCode(), 201);

        //Capture User ID
        String userId = createResponse.jsonPath()
                        .getString("id");
        System.out.println("Create User ID = " + userId);

        Response getResponse = RestAssured
                .given()
                .spec(RequestSpec.getRequestSpec())
                .when()
                .get("/users/" + userId);

        System.out.println("GET Response : ");
        System.out.println(getResponse.asPrettyString());

        Assert.assertEquals(
                getResponse.getStatusCode(), 404);

        User updatedUser = new User();

        updatedUser.setName("Wani");
        updatedUser.setJob("Automation Tester");

        System.out.println("Base URI = " + RestAssured.baseURI);
        System.out.println("Update URL = " + RestAssured.baseURI + "/users/" + userId);

        Response updateResponse = RestAssured
                .given()
                .log().all()
                .spec(RequestSpec.getRequestSpec())
                .body("""
                        {
                        "name" : "Wani",
                        "job" : "Automation Tester"
                        }
                        """)
                .when()
                .put("/users/1");

        System.out.println("Update Status Code = "
                + updateResponse.getStatusCode());

        System.out.println("Update Response : ");
        System.out.println(updateResponse.asPrettyString());

        Assert.assertEquals(
                updateResponse.getStatusCode(),
                200);

        Assert.assertEquals(
                updateResponse.jsonPath().getString("name"),
                "Wani");

        Assert.assertEquals(
                updateResponse.jsonPath().getString("job"),
                "Automation Tester"
        );

    }
}
