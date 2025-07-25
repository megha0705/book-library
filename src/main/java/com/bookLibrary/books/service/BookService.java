package com.bookLibrary.books.service;

import com.bookLibrary.books.entity.BookDto;
import com.bookLibrary.books.entity.BooksEntity;
import com.bookLibrary.books.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;
    public String updateAvailability(int id, String availability) {
        BooksEntity book = bookRepo.findById(id).orElseThrow(()-> new RuntimeException("book with this id not available"));
        if ("true".equalsIgnoreCase(availability)) {
            book.setAvailable(true);
        } else if("false".equalsIgnoreCase(availability)){
            book.setAvailable(false);
        }
        bookRepo.save(book);
        return "book availability updated succesfully";
    }

    public String addBook(BookDto bookDto) {
        BooksEntity books = new BooksEntity();
        books.setAuthor(bookDto.getAuthor());
        books.setIsbn(bookDto.getIsbn());
        books.setAvailable(true);
        books.setTitle(bookDto.getTitle());
        bookRepo.save(books);
        return "books added successfully";

    }
}
