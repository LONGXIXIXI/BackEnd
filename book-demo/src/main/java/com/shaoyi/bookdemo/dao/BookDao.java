package com.shaoyi.bookdemo.dao;

import com.shaoyi.bookdemo.model.BookInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class BookDao {
    public List<BookInfo> mockData() {
        List<BookInfo> books = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            BookInfo book = new BookInfo();
            book.setId(i);
            book.setBookName("书籍" + i);
            book.setAuthor("作者" + i);
            book.setCount(i * 5 + 3);
            book.setPrice(new BigDecimal(new Random().nextInt(100)));
            book.setPublish("出版社" + i);
            book.setStatus(i%5==0?2:1);
            books.add(book);
        }
        return books;
    }
}
