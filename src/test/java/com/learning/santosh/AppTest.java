package com.learning.santosh;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.testng.annotations.Test;
import pojo.Employee;
import pojo.Employees;
import pojo.Location;
import pojo.Place;

import java.util.ArrayList;
import java.util.List;

public class AppTest {
    @Test
    public void CreateAPlace() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        Place place = new Place();

        place.setAccuracy(40);
        place.setName("Frontline house");
        place.setPhone_number("(+91) 983 893 3937");
        place.setAddress("29, side layout, cohen 09");
        place.setWebsite("http://google.com");
        place.setLanguage("French-IN");

        List<String> types = new ArrayList<>();
        types.add("shop");
        types.add("shoe park");

        place.setTypes(types);

        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);

        place.setLocation(location);

        String response = RestAssured
                                .given().log().all()
                                    .queryParam("key", "qaclick123")
//                                    .contentType(ContentType.JSON)
                                    .body(place)
                                .when()
                                    .post("/maps/api/place/add/json")
                                .then().log().all()
                                    .assertThat().statusCode(200)
                                    .extract().response().asString();

    }
}
