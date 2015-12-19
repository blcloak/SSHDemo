package com.demo.serviceimpl;

import java.util.List;

import com.demo.dao.IBookDao;
import com.demo.entity.Book;
import com.demo.service.IBookService;

public class BookService implements IBookService {
	
	private IBookDao bookDao;
	
	

	public IBookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> getBookList() {
		return bookDao.getBookList();
	}

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Override
	public Book getBookByName(String bookName) {
		return bookDao.getBookByName(bookName);
	}

	@Override
	public void delBook(Book book) {
		bookDao.delBook(book);
	}

}
