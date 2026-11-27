package com.shaoyi.bookdemo.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BookInfo {
    //图书id
    private Integer id;
    //书名
    private String bookName;
    //作者
    private String author;
    //库存数量
    private Integer count;
    //定价
    private BigDecimal price;
    //出版商
    private String publish;
    //状态 0-无效 1-允许借阅 2-不允许借阅
    private Integer status;
    //状态中文描述
    private String statusCN;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

}
