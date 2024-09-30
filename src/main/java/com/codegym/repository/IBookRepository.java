package com.codegym.repository;

import com.codegym.model.Book;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface IBookRepository extends CrudRepository<Book,Long> {
    Iterable<Book> findAllByCategory(Category category);
    Page<Book> findAll(Pageable pageable);
    Iterable<Book> findAllByName(String name);
    Iterable<Book> findAllByAuthor(String author);
}
