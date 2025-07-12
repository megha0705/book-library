package com.bookLibrary.books.repository;

import com.bookLibrary.books.entity.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<BooksEntity , Integer> {
}
