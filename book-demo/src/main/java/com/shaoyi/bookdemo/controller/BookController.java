package com.shaoyi.bookdemo.controller;

import com.shaoyi.bookdemo.model.BookInfo;
import com.shaoyi.bookdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("/getlist")
    public List<BookInfo> getList(){
        List<BookInfo> books = bookService.getList();
        return books;
    }


}
