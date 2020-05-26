package com.learning.santosh;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.Test;
import pojo.Employee;
import pojo.Employees;

import java.util.List;

public class AppTest {
    @Test
    public void GetEmployees() {
        RestAssured.baseURI = "http://dummy.restapiexample.com";
        Employees response = RestAssured
                                .given().expect().defaultParser(Parser.JSON)
                                .when()
                                    .get("/api/v1/employees")
                                .then()
                                    .extract().body().as(Employees.class);

        String status = response.getStatus();
        System.out.println(status);

        List<Employee> data = response.getData();

        System.out.println(String.format("Total employees: %d",data.size()));
    }
}
