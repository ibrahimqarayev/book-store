package com.company.bookstore.controller;

import com.company.bookstore.service.MyBooksService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyBooksController {
    private final MyBooksService myBooksService;

    public MyBooksController(MyBooksService myBooksService) {
        this.myBooksService = myBooksService;
    }

    @GetMapping("/deleteMyList/{id}")
    public String deleteMyBooks(@PathVariable Integer id) {
        myBooksService.deleteById(id);
        return "redirect:/my_books";
    }
}
