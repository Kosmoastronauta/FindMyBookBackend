package com.kosmoastronauta.demo.controllers;

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
    private static final String URL = "http://localhost";

    @Test
    @Order(1)
    void getAllBooksWhileThereIsNoBookInDatabase()
    {
        given().when().get(URL + "/getAllBooks/").then().statusCode(HttpStatus.NO_CONTENT.value());
    }

    @Test
    public void addNewValidBook() throws JSONException
    {
        RestAssured.defaultParser = Parser.JSON;
        JSONObject request = new JSONObject();
        request.put("title", "Temp Book2!!!!");
        request.put("author", "Temp author2!!!!!");
        request.put("edition", "first2!!!!");
        request.put("describe", "");
        request.put("year", 2002);

        Book book = given().contentType("application/json")
                .body(request.toString())
                .when().post(URL + "/books/")
                .then().statusCode(HttpStatus.OK.value())
                .extract().as(Book.class);
    }

}
