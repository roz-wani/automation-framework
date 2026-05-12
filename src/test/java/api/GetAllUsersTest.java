package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllUsersTest {

    @Test
    public void getAllUsers() {

        Response response = RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users");

        int statusCode = response.getStatusCode();

        System.out.println("Status Code : " + statusCode);

        Assert.assertEquals(statusCode, 200);

        //Get first user name
        String firstUser = response.jsonPath().getString("[0].name");
        System.out.println("First User : " + firstUser);
        Assert.assertEquals(firstUser, "Leanne Graham");

        //Get second user email
        String secondEmail = response.jsonPath().getString("[1].email");
        System.out.println("Second Email : " + secondEmail);
        Assert.assertEquals(secondEmail, "Shanna@melissa.tv");
    }
}
