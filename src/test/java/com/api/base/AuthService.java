package com.api.base;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;

import java.util.HashMap;

public class AuthService extends BaseService {
    private static final String BASE_PATH = "/api/auth/";

    public Response login (LoginRequest payLoad) {
        return postRequest(payLoad, BASE_PATH + "login");
    }

    public Response signUp (SignUpRequest payLoad) {
        return postRequest(payLoad, BASE_PATH + "signup");
    }

    public Response forgotPassword (String emailAddress) {
        HashMap<String,String> payLoad = new HashMap<String,String>();
        payLoad.put("email",emailAddress);

        return postRequest(payLoad, BASE_PATH + "forgot-password");
    }
}
