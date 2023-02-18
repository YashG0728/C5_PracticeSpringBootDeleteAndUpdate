package com.example.c1_bootjpaexample.controller;

import com.example.c1_bootjpaexample.model.BookModel;
import com.example.c1_bootjpaexample.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;


    @GetMapping("/getbook")
    public String getBooks() {
        return "I am learning springboot from youtube";
    }

    @PostMapping("/postbook")
    public BookModel postBooks() {
        BookModel bookModel = new BookModel();
        bookModel.setId(1);
        bookModel.setTitle("Java Refrence");
        bookModel.setAuthor("xyz");
        return bookModel;
    }

    @GetMapping("/getallbook")
    public List<BookModel> getlistofbooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/getbookusingid/{id}")
    public BookModel getbookusingid(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/addingbooks")
    public BookModel addDataBook(@RequestBody BookModel bookModel) {
        this.bookService.addDataIntoList(bookModel);
        System.out.println(bookModel);
        return bookModel;
    }

    @DeleteMapping("/deletedata/{id}")
    public String deleteData(@PathVariable("id") int id) {
        this.bookService.deleteData(id);
        return "This Id Deleted Successfully"+" "+ id;
    }

    @PutMapping("/update/{id}")
    public BookModel update(@RequestBody BookModel bookmodel, @PathVariable("id") int id){
        this.bookService.updateBook(bookmodel,id);
        return bookmodel;
    }

}
