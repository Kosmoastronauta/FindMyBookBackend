package com.kosmoastronauta.demo.controllers;

import com.github.javafaker.Faker;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.parsing.Parser;
import com.kosmoastronauta.demo.domain.Book;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static com.jayway.restassured.RestAssured.given;

class BookControllerTest
{
    private static final String URL = "http://localhost:8080";

    private static Faker faker = new Faker();

    @Test
    @Order(1)
    void getAllBooksWhileThereIsNoBookInDatabase()
    {
        given().when().get(URL + "/getAllBooks/").then().statusCode(HttpStatus.NO_CONTENT.value());
    }

    @Test
    @Order(2)
    public void addNewValidBook()
    {
        try
        {
            RestAssured.defaultParser = Parser.JSON;
            JSONObject request = new JSONObject();
            request.put("title", faker.book().title());
            request.put("author", faker.book().author());
            request.put("edition", faker.name().name());
            request.put("describe", faker.name().title());
            request.put("year", faker.number().randomNumber());
            request.put("subject", faker.name().lastName());
            request.put("schoolId", faker.number().randomNumber());

            Book book = given().contentType("application/json")
                    .body(request.toString())
                    .when().post(URL + "/addNewBook/")
                    .then().statusCode(HttpStatus.OK.value())
                    .extract().as(Book.class);
        } catch(Exception e)
        {}

    }

}
