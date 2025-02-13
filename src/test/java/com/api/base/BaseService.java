package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

    private static final String BASE_URL = "http://64.227.160.186:8080";
    private RequestSpecification requestSpecification;

    static {
        RestAssured.filters(new LoggingFilter());
    }

    public BaseService () {
        requestSpecification = given().baseUri(BASE_URL);
    }

    protected void setAuthToken(String token){
        String val = "Bearer "+ token;
        requestSpecification.header("Authorization", val );
    }

    protected Response getRequest (String endPoint) {
        return requestSpecification.get(endPoint);
    }

    protected Response postRequest (Object payLoad, String endPoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payLoad).post(endPoint);
    }

    protected Response putRequest (Object payLoad, String endPoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payLoad).put(endPoint);
    }
}
