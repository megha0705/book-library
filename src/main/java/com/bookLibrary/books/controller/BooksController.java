package com.bookLibrary.books.controller;

import com.bookLibrary.books.entity.BookDto;
import com.bookLibrary.books.entity.BooksEntity;
import com.bookLibrary.books.repository.BookRepo;
import com.bookLibrary.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BooksController {
    @Autowired
    BookRepo bookRepo;
    @Autowired
    BookService bookService;
    @GetMapping("/getAll")
    public ResponseEntity<List<BooksEntity>> getAllBooks(){
        return ResponseEntity.ok(bookRepo.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BooksEntity> getAllBooks(@PathVariable int id){
        BooksEntity book = bookRepo.findById(id).orElseThrow(()-> new RuntimeException("books with thiis id not found"));
        return ResponseEntity.ok(book);
    }
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id){
        bookRepo.deleteById(id);
        return ResponseEntity.ok("book deleted successfully");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAvailability(@PathVariable int id , @RequestParam String availability ){
    return  ResponseEntity.ok(bookService.updateAvailability(id , availability));

    }
    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody BookDto book){
        return ResponseEntity.ok(bookService.addBook(book));

    }
}
