package com.kosmoastronauta.demo.controllers;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static com.jayway.restassured.RestAssured.given;

class BookControllerTest
{
    public static final String URL = "http://localhost";

    @Test
    @Order(1)
    void getAllBooksWhileThereIsNoBookInDatabase()
    {
        given().when().get(URL + "/getAllBooks/").then().statusCode(HttpStatus.NO_CONTENT.value());
    }

}
