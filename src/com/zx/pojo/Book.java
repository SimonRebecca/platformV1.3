package com.zx.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zhangxin on 2015-07-30.
 */
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_price")
    private Integer bookPrice;

    public Book() {
    }

    public Book(String isbn, String bookName, Integer bookPrice) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Integer bookPrice) {
        this.bookPrice = bookPrice;
    }

}
