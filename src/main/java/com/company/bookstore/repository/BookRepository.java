package com.company.bookstore.repository;

import com.company.bookstore.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    Optional<BookEntity> findByName(String name);
}
