package com.kosmoastronauta.demo.services;

import com.kosmoastronauta.demo.domain.Book;
import com.kosmoastronauta.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService
{
    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks()
    {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);

        if(books.isEmpty()) throw new NoSuchElementException("There is no books");

        return books;
    }
}
