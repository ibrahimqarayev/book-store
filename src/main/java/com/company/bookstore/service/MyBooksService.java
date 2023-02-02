package com.company.bookstore.service;

import com.company.bookstore.entity.MyBooks;
import com.company.bookstore.repository.MyBooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBooksService {

    private final MyBooksRepository myBooksRepository;

    public MyBooksService(MyBooksRepository myBooksRepository) {
        this.myBooksRepository = myBooksRepository;
    }

    public void saveMyBooks(MyBooks myBooks) {
        myBooksRepository.save(myBooks);
    }

    public List<MyBooks> getAllMyBooks() {
        return myBooksRepository.findAll();
    }
}
