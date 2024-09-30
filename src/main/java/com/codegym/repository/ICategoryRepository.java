package com.codegym.repository;

import com.codegym.model.Book;
import com.codegym.model.Category;
import com.codegym.service.impl.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category, Long> {
    Page<Category> findAll(Pageable pageable);
}
