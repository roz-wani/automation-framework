package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllUsersLoopTest {

    @Test
    public void getAllUsers() {

        Response response = RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users");

        //Status code validation
        Assert.assertEquals(response.getStatusCode(), 200);

        //Get all names
        List<String> names = response.jsonPath().getList("name");

        System.out.println("All Users Name : ");

        for (String name : names) {
            System.out.println(name);
        }

        //validate specific users exists
        Assert.assertTrue(names.contains("Leanne Graham"));
    }
}
