package com.company.bookstore.controller;

import com.company.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping({"/", "/index"})
    public String indexPage() {
        return "index";
    }

    @GetMapping("/books")
    public String getAllBooks() {
        return "books";
    }

    @GetMapping("/search")
    public String searchBook() {
        return "search";
    }

    @GetMapping("/new_releases")
    public String newReleases() {
        return "newReleases";
    }

    @GetMapping("/contact")
    public String contactUs() {
        return "contact";
    }

    @GetMapping("/company")
    public String aboutCompany() {
        return "company";
    }

    @GetMapping("/details")
    public String details() {
        return "subpage";
    }


}
