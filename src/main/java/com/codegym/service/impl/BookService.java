package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.model.Category;
import com.codegym.repository.IBookRepository;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Iterable<Book> finAllByCategory(Category category) {
        return iBookRepository.findAllByCategory(category);
    }

    @Override
    public Iterable<Book> findAllByName(String name) {
        return iBookRepository.findAllByName(name);
    }

    @Override
    public Iterable<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return iBookRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
         iBookRepository.deleteById(id);
    }

    @Override
    public Iterable<Book> findAllByAuthor(String author) {
        return iBookRepository.findAllByAuthor(author);
    }
}
