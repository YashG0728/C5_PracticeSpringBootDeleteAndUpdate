package com.example.c1_bootjpaexample.service;

import com.example.c1_bootjpaexample.model.BookModel;
import com.example.c1_bootjpaexample.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private static List<BookModel> list = new ArrayList<>();
    private final UserRepository userRepository;

    public BookService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    static {
        list.add(new BookModel(2, "java complete reference", "xyz"));
        list.add(new BookModel(3, "java complete reference", "abc"));
        list.add(new BookModel(4, "java complete reference", "def"));
    }

    //get all books
    public List<BookModel> getAllBooks() {
        return list;
    }

    //get book by id
    public BookModel getBookById(int id) {
        BookModel bookModel = list.stream().filter(e -> e.getId() == id).findFirst().get();
        return bookModel;
    }

    //adding the book
    public void addDataIntoList(BookModel bookModel) {
        list.add(bookModel);
    }

    //delete the book
    public void deleteData(int id) {
        list = list.stream().filter(e -> e.getId() != id).collect(Collectors.toList());
    }

    public void updateBook(BookModel bookModel, int id) {
        list = list.stream().map(e -> {
            if (e.getId() == id) {
                e.setTitle(bookModel.getTitle());
                e.setAuthor(bookModel.getAuthor());
            }
            return e;
        }).collect(Collectors.toList());

    }
}
