package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {

    @Test(description = "Verify if Account creation API is Working")
    public void createAccountTest () {

      SignUpRequest signUpRequest= new SignUpRequest.Builder()
              .username("doni1234")
              .email("doni273@gmail.com")
              .firstname("doni")
              .password("doni1234")
              .lastname("Silva1")
              .mobileNumber("3445553355")
              .build();

        AuthService authService = new AuthService();

        Response response = authService.signUp(signUpRequest);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.asPrettyString(),"User registered successfully!");
        Assert.assertEquals(response.statusCode(),200);

    }
}
