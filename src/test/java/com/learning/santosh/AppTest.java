package com.learning.santosh;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class AppTest {
    @Test
    public void GetEmployees() {
        RestAssured.baseURI = "http://dummy.restapiexample.com";
        String response = RestAssured.given().when().log().all().get("/api/v1/employees").then().log().all().extract().body().asString();
        System.out.println(response);
    }
}
