package com.example.BootRestAPIBook.Services;

import com.example.BootRestAPIBook.dao.BookRepository;
import com.example.BootRestAPIBook.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {
//    private static List<Book> list = new ArrayList<>();

//    static{
//        list.add(new Book(331, "Python", "Arti"));
//        list.add(new Book(332, "C++", "Arti2"));
//        list.add(new Book(333, "Java-Script", "Arti3"));
//    }

    @Autowired
    private BookRepository bookRepository;

    //get All Books
    public List<Book> getAllBooks(){
//        return list;
        List<Book> books = (List<Book>) bookRepository.findAll();
        return books;
    }

    //get single book by id
    public Book getBookById(int id){
        Book book = null;
        try{
//            book = list.stream().filter(e -> e.getBookId() == id).findFirst().get();
            book = bookRepository.findById(id);
        } catch (Exception e){
            e.printStackTrace();
        }

        return book;
    }

    //adding the book
    public Book addBook(Book book){
//        list.add(book);
        Book b = bookRepository.save(book);
        return b;
    }

    //deleting a book
    public void deleteBook(int id){
//        list.forEach(b -> {
//            if(b.getBookId() == id){
//                list.remove(b);
//                return;
//            }
//        });
        bookRepository.deleteById(id);
    }

    //update book
    public Book updateBook(Book book, int id){
//        list.forEach(b -> {
//            if(b.getBookId() == id){
//                b.setBookId(book.getBookId());
//                b.setAuthor(book.getAuthor());
//                b.setTitle(book.getTitle());
//            }
//        });
        book.setBookId(id);
        Book b = bookRepository.save(book);
        return b;
    }


}
