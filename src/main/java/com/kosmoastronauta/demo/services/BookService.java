package com.kosmoastronauta.demo.services;

import com.kosmoastronauta.demo.domain.Book;
import com.kosmoastronauta.demo.repositories.BookRepository;
import org.springframework.stereotype.Service;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService
{
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks()
    {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);

        if(books.isEmpty()) throw new NoSuchElementException("There is no books");

        return books;
    }

    public void addNewBook(Book book)
    {
        if(!isBookValid(book)) throw new InvalidParameterException("Book has not required fields");
        bookRepository.save(book);
    }

    private boolean isBookValid(Book book)
    {
        return !book.getTitle().isEmpty();
    }

    public List<Book> getAllBooksBySchoolId(long schoolId)
    {
        //TODO check if this id in school table exists

        List<Book> books = new ArrayList<>(bookRepository.getBooksBySchoolIdEquals(schoolId));

        if(books.isEmpty()) throw new NoSuchElementException("There is no books in that school");

        return books;
    }

    public List<Book> getAllBooksLikeThat(Book book)
    {
        List<Book> books = this.getAllBooksBySchoolId(book.getSchoolId());
        if(!book.getTitle().isEmpty())
        {
            String title = book.getTitle();
            books.removeIf(book1 -> book1.getTitle().equals(title));
        }

        if(!book.getAuthor().isEmpty())
        {
            String author = book.getAuthor();
            books.removeIf(book1 -> book1.getAuthor().equals(author));
        }

        if(!book.getEdition().isEmpty())
        {
            String edition = book.getEdition();
            books.removeIf(book1 -> book1.getEdition().equals(edition));
        }

        if(!book.getSubject().isEmpty())
        {
            String subject = book.getSubject();
            books.removeIf(book1 -> book1.getSubject().equals(subject));
        }

        if(books.isEmpty()) throw new NoSuchElementException("No such books");

        return books;
    }

}
