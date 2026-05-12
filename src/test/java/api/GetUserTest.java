package api;

import base.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetUserTest extends BaseAPI {

    @BeforeMethod
    public void start() {
        setupAPI();
    }

    @Test
    public void getUser() {

        Response response = request
                .when()
                .get("/users/1");

        System.out.println(response.asPrettyString());

        //Status code
        int statusCode = response.getStatusCode();
        System.out.println("Status Code : " + statusCode);
        Assert.assertEquals(statusCode, 200);

        //Response body validation
        String name = response.jsonPath().getString("name");
        System.out.println("Name : " + name);
        Assert.assertEquals(name, "Leanne Graham");

        String email = response.jsonPath().getString("email");
        System.out.println("Email : " + email);
        Assert.assertEquals(email, "Sincere@april.biz");

        String city = response.jsonPath().getString("address.city");
        System.out.println("City : " + city);
        Assert.assertEquals(city, "Gwenborough");

        //Header validation
        String contentType = response.getHeader("Content-Type");
        System.out.println("Content Type : " + contentType);
        Assert.assertTrue(contentType.contains("application/json"));

        //Response time validation
        long responseTime = response.getTime();
        System.out.println("Response Time : " + responseTime);
        Assert.assertTrue(responseTime < 3000);
    }
}