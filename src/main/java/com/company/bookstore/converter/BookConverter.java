package com.company.bookstore.converter;

import com.company.bookstore.dto.BookDto;
import com.company.bookstore.entity.BookEntity;
import com.company.bookstore.entity.MyBooks;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

    public BookDto toBookDto(BookEntity from) {
        return new BookDto(
                from.getId(),
                from.getName(),
                from.getAuthor(),
                from.getDescription(),
                from.getPrice()
        );
    }

    public MyBooks toMyBooks(BookDto from) {
        return new MyBooks(
                from.getId(),
                from.getName(),
                from.getAuthor(),
                from.getPrice()
        );
    }

}
