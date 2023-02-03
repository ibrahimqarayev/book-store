package com.company.bookstore.controller;

import com.company.bookstore.service.MyBooksService;
import org.springframework.stereotype.Controller;

@Controller
public class MyBooksController {
    private final MyBooksService myBooksService;

    public MyBooksController(MyBooksService myBooksService) {
        this.myBooksService = myBooksService;
    }
}
