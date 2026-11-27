package com.shaoyi.bookdemo.service;

import com.shaoyi.bookdemo.model.BookInfo;
import com.shaoyi.bookdemo.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    @RequestMapping("/getlist")
    public List<BookInfo> getList(){

        List<BookInfo> books = bookDao.mockData();
        for(BookInfo book : books){
            if(book.getStatus() == 1)
                book.setStatusCN("可借");
            else
                book.setStatusCN("不可借");
        }
        return books;
    }
}
