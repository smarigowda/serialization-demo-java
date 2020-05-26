package com.learning.santosh;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.Test;
import pojo.Employee;
import pojo.Employees;

import java.util.List;

public class AppTest {
    @Test
    public void CreateAPlace() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = RestAssured
                                .given().log().all()
                                    .body("{\n" +
                                            "  \"location\": {\n" +
                                            "    \"lat\": -38.383494,\n" +
                                            "    \"lng\": 33.427362\n" +
                                            "  },\n" +
                                            "  \"types\": [\n" +
                                            "      \"shoe park\", \"shop\"\n" +
                                            "  ]\n" +
                                            "  \"accuracy\": 50,\n" +
                                            "  \"name\": \"Frontline house\",\n" +
                                            "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                                            "  \"address\": \"29, side layout, cohen 09\",\n" +
                                            "  \"types\": [\"shoe park\", \"shop\"],\n" +
                                            "  \"website\": \"http://google.com\",\n" +
                                            "  \"language\": \"French-IN\"\n" +
                                            "}")
                                .when()
                                    .post("/maps/api/place/add/json")
                                .then()
                                    .assertThat().statusCode(200)
                                    .extract().response().asString();

    }
}
