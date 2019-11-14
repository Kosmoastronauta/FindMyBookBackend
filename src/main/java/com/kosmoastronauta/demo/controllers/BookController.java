package com.kosmoastronauta.demo.controllers;

import com.kosmoastronauta.demo.domain.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController
{
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks()
    {

    }
}
