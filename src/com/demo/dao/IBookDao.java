package com.demo.dao;

import java.util.List;

import com.demo.entity.Book;

public interface IBookDao {
public List<Book> getBookList();
	
	public void addBook(Book book);
	
	public Book getBookByName (String bookName);
	
	public void delBook(Book book);
}
