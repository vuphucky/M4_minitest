package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @GetMapping("")
    public ModelAndView showAllBook(){
        return new ModelAndView("/allBook","listBook", iBookService.findAll());
    }

    @GetMapping("/showCreate")
    public String showCreate(Model model){
        model.addAttribute("book",new Book());
        return "/create";
    }


}
