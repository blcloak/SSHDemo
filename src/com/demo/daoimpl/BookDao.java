package com.demo.daoimpl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.demo.dao.IBookDao;
import com.demo.entity.Book;

public class BookDao extends HibernateDaoSupport implements IBookDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBookList() {
		return (List<Book>) this.getHibernateTemplate().find("from Book");
	}

	@Override
	public void addBook(Book book) {
		this.getHibernateTemplate().save(book);

	}

	@Override
	public Book getBookByName(String bookName) {
		@SuppressWarnings("unchecked")
		List<Book> bookList = (List<Book>)this.getHibernateTemplate().find("from Book where bookName = '" + bookName +"'");
		if(bookList != null && bookList.size() > 0 ){
			return bookList.get(0);
		}
		return null;
	}

	@Override
	public void delBook(Book book) {
		this.getHibernateTemplate().delete(book);

	}

}
