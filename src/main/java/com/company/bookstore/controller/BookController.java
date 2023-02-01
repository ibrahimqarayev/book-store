package com.company.bookstore.controller;

import com.company.bookstore.dto.BookDto;
import com.company.bookstore.entity.BookEntity;
import com.company.bookstore.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/index")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/books")
    public ModelAndView getAllBooks() {
        List<BookDto> list = bookService.getAllBooks();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("books");
//        modelAndView.addObject("book", list);
//        return modelAndView;
        return new ModelAndView("books", "book", list);
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

    @GetMapping("/questions")
    public String questtions() {
        return "questions";
    }

    @GetMapping("/faqs")
    public String faqs() {
        return "faqs";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute BookEntity bookEntity) {
        bookService.addBook(bookEntity);
        return "redirect:/books";
    }


}
