package com.kosmoastronauta.demo.controllers;

import com.kosmoastronauta.demo.domain.Book;
import com.kosmoastronauta.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
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

    @PostMapping("/addNewBook/")
    public ResponseEntity<HttpStatus> addNewBook(@RequestBody Book book)
    {
        try
        {
            bookService.addNewBook(book);
        }catch(InvalidParameterException e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getBooksBySchoolId/{schoolId}/")
    public ResponseEntity<List<Book>> getBooksBySchoolId(@PathVariable long schoolId)
    {
        List<Book> books;

        try
        {
            books = bookService.getAllBooksBySchoolId(schoolId);
        }catch(NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/getBooksFromSchoolWithSpecifiedData/")
    public ResponseEntity<List<Book>> getBooksFromSchoolWithSpecifiedFields(@RequestBody Book book)
    {
        List<Book> books;
        try
        {
            books= bookService.getAllBooksLikeThat(book);
        }catch(NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
