package com.company.bookstore.service;

import com.company.bookstore.converter.BookConverter;
import com.company.bookstore.dto.BookDto;
import com.company.bookstore.entity.BookEntity;
import com.company.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookConverter bookConverter;

    public BookService(BookRepository bookRepository, BookConverter bookConverter) {
        this.bookRepository = bookRepository;
        this.bookConverter = bookConverter;
    }

    public void save(BookEntity bookEntity) {
        bookRepository.save(bookEntity);
    }

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream().map(bookEntity -> bookConverter.toBookDto(bookEntity)).collect(Collectors.toList());
    }

    public BookDto getBookById(Integer id) {
       return bookConverter.toBookDto(bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book Not Found")));
    }

    public void deleteBookById(Integer id){
        bookRepository.deleteById(id);
    }

}
