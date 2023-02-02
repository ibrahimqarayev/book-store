package com.company.bookstore.repository;

import com.company.bookstore.entity.MyBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyBooksRepository extends JpaRepository<MyBooks, Integer> {
}
