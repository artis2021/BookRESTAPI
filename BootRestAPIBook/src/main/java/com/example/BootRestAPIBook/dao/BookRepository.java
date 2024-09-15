package com.example.BootRestAPIBook.dao;

import com.example.BootRestAPIBook.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {
    public Book findById(int id);
//    public List<Book> findAll();
}
