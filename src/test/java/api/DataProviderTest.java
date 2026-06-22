package api;

import base.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.RequestSpec;

public class DataProviderTest extends BaseAPI {

    @DataProvider(name = "userData")
    public Object[][] getData() {

        return new Object[][] {
                {"Wani", "QA Engineer"},
                {"Ahmad", "Automation Tester"},
                {"Sinthu", "Senior QA"}
        };
    }

    @Test(dataProvider = "userData")
    public void createUser(String name, String job) {

        User user = new User();

        user.setName(name);
        user.setJob(job);

        Response response = RestAssured
                .given()
                .spec(RequestSpec.getRequestSpec())
                .body(user)
                .when()
                .post("/users");

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 201);
    }
}
