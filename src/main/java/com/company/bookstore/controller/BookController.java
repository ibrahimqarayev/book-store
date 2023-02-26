package com.company.bookstore.controller;

import com.company.bookstore.converter.BookConverter;
import com.company.bookstore.dto.BookDto;
import com.company.bookstore.entity.BookEntity;
import com.company.bookstore.entity.MyBooks;
import com.company.bookstore.service.BookService;
import com.company.bookstore.service.MyBooksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;
    private final MyBooksService myBooksService;
    private final BookConverter bookConverter;

    public BookController(BookService bookService, MyBooksService myBooksService, BookConverter bookConverter) {
        this.bookService = bookService;
        this.myBooksService = myBooksService;
        this.bookConverter = bookConverter;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBook() {

        List<BookDto> list = bookService.getAllBooks();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bookList");
        modelAndView.addObject("book", list);
        //return new ModelAndView("bookList", "book", list);
        return modelAndView;

    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute BookEntity bookEntity) {
        bookService.save(bookEntity);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model) {
        List<MyBooks> list = myBooksService.getAllMyBooks();
        model.addAttribute("book", list);
        return "myBooks";
    }

    @GetMapping("/myList/{id}")
    public String getMyBooksById(@PathVariable Integer id) {
        BookDto bookDto = bookService.getBookById(id);
        myBooksService.saveMyBooks(bookConverter.toMyBooks(bookDto));
        return "redirect:/my_books";
    }

    @GetMapping("/editBook/{id}")
    public String editBook(@PathVariable Integer id,Model model) {
        BookDto b = bookService.getBookById(id);
        model.addAttribute("book",b);
        return "bookEdit";
    }


}
