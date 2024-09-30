package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.Category;
import com.codegym.service.IBookService;
import com.codegym.service.ICatergoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private ICatergoryService categoryService;
    @ModelAttribute("category")
    public Iterable<Category> listCategories() {
        return categoryService.findAll();
    }

    @GetMapping("")
    public String showAllBook(Model model){
        Iterable<Book> listBook = iBookService.findAll();
        model.addAttribute("listBook",listBook);
        return "/allBook";
    }

    @GetMapping("/showCreate")
    public String showCreate(Model model){
        model.addAttribute("book",new Book());
        return "/create";
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Book book){
        iBookService.save(book);
        return new ModelAndView("redirect:/books");
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        iBookService.remove(id);
        return "redirect:/books";
    }

    @GetMapping("/showUpdate/{id}")
    public String showUpdate(@PathVariable ("id") Long id, Model model){
        Optional<Book> book = iBookService.findById(id);
        model.addAttribute("book", book.get());
        return "/update";
    }

    @GetMapping("/update/{id}")
    public String update(@ModelAttribute("book") Book book, @PathVariable("id") Long id){
        iBookService.save(book);
        return "redirect:/books";
    }

}
