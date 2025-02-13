package com.api.tests;

import com.api.base.AuthService;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest {

    @Test(description = "Verify if forgot password API is Working")
    public void forgotPasswordTest () {
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("dukeorigins933@gmail.com");

        JsonPath jsonpath= response.jsonPath();
        String message = jsonpath.getString("message");
        Assert.assertEquals(message,"If your email exists in our system, you will receive reset instructions.");


    }
}
