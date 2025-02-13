package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class LoginTest {

    @Test(description = "Verify if login API is Working")
    public void loginTest () {


        AuthService authService = new AuthService();
        LoginRequest loginRequest = new LoginRequest("iranga","sonal1234");
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(response.asPrettyString());
        System.out.println(loginResponse.getToken());
        System.out.println(loginResponse.getUsername());

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertNotNull(loginResponse.getToken());
        Assert.assertEquals(loginResponse.getUsername(),"iranga");
        Assert.assertEquals(loginResponse.getEmail(),"ght@gmail.com");
        Assert.assertEquals(loginResponse.getId(),88);
    }
}
