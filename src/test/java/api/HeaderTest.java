package api;

import base.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends BaseAPI {

    @Test
    public void headerTest() {

        Response response = RestAssured
                .given()
                .header("Content Type", "application/json")
                .when()
                .get("/users/1");

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
