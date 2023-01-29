package com.company.bookstore.converter;

import com.company.bookstore.dto.BookDto;
import com.company.bookstore.entity.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

    public BookEntity toBookEntity(BookDto from) {
        return new BookEntity(
                from.getId(),
                from.getName(),
                from.getAuthor(),
                from.getTitle(),
                from.getPrice()
        );
    }

    public BookDto toBookDto(BookDto from) {
        return new BookDto(
                from.getId(),
                from.getName(),
                from.getAuthor(),
                from.getTitle(),
                from.getPrice()
        );
    }

}
