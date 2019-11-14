package com.kosmoastronauta.demo.controllers;

import com.kosmoastronauta.demo.domain.Book;
import com.kosmoastronauta.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class BookController
{
    @Autowired
    BookService bookService;

    @GetMapping("/getAllBooks/")
    public ResponseEntity<List<Book>> getAllBooks()
    {
        List<Book> allBooks;

        try
        {
            allBooks = bookService.getAllBooks();
        }catch(NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }
}
