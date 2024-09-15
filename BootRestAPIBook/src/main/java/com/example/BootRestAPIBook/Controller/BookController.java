package com.example.BootRestAPIBook.Controller;

import com.example.BootRestAPIBook.Services.BookService;
import com.example.BootRestAPIBook.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

//    @RequestMapping(value = "/books", method = RequestMethod.GET)
//    @ResponseBody
//    @GetMapping("/books")
//    public Book getBook(){
//        Book book = new Book(330, "Spring-Boot", "Arti Sahu");
//        return book;
//    }

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
//        return bookService.getAllBooks();
        List<Book> list = bookService.getAllBooks();
        if(list.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id){
//        return bookService.getBookById(id);
        Book book = bookService.getBookById(id);
        if(book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
//        bookService.addBook(book);
//        return book;
        try{
            Book b = bookService.addBook(book);
            return ResponseEntity.of(Optional.of(book));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id){
        try{
            bookService.deleteBook(id);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") int id){
//        return bookService.updateBook(book, id);
        try{
            Book b = bookService.updateBook(book, id);
            return ResponseEntity.ok().body(b);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }





}
