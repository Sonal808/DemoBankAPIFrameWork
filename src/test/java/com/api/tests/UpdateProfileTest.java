package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTest {

    @Test(description = "Verify if update  profile API is Working")
    public void updateProfileTest () {

        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("iranga", "sonal1234"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(response.asPrettyString());

        System.out.println("----------------------------------------");

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(loginResponse.getToken());
        System.out.println(response.asPrettyString());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);

        Assert.assertEquals(userProfileResponse.getUsername(), "iranga");

        System.out.println("-------------------------------------------");

        ProfileRequest profileRequest = new ProfileRequest.Builder()
                .firstName("dolton")
                .lastName("desilva")
                .email("ght@gmail.com")
                .mobileNumber("2353545559")
                .build();

        Response response1 = userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);

        System.out.println(response1.asPrettyString());


    }
}
