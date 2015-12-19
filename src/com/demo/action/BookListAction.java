package com.demo.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Book;
import com.demo.service.IBookService;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("basePackage")
@Namespace("/")
public class BookListAction extends ActionSupport {


	private static final long serialVersionUID = 1L;
	
	private List<Book> bookList;
	

	public List<Book> getBookList() {
		return bookList;
	}


	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	private Book newBook;
	
	
	
	public Book getNewBook() {
		return newBook;
	}


	public void setNewBook(Book newBook) {
		this.newBook = newBook;
	}

	private IBookService bookService;
	


	public IBookService getBookService() {
		return bookService;
	}


	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	
	List<String> delName;


	public List<String> getDelName() {
		return delName;
	}


	public void setDelName(List<String> delName) {
		this.delName = delName;
	}


	@Override
	@Transactional
	@Action(value = "getBookList", results = {
			@Result(name = "success", location = "/jsp/bookList.jsp"),
			@Result(name = "fail", location = "/jsp/fail.jsp") })
	public String execute() throws Exception {
		bookList = bookService.getBookList();
		
		
		return SUCCESS;
	}
	
	
	@Transactional
	@Action(value = "addBook", results = {
			@Result(name = "success", type="redirectAction", location = "getBookList"),
			@Result(name = "fail", location = "/jsp/fail.jsp") })
	public String addBook() throws Exception{
		if(newBook != null){
			bookService.addBook(newBook);
		}
		
		return SUCCESS;
	}
	@Transactional
	@Action(value = "delBook", results = {
			@Result(name = "success", type="redirectAction", location = "getBookList"),
			@Result(name = "fail", location = "/jsp/fail.jsp") })
	public String delBook() throws Exception{
		if(delName != null && delName.size() > 0){
			for(String name: delName){
				Book delBook = new Book();
				delBook.setBookNo(Integer.valueOf(name));
				bookService.delBook(delBook);
			}
		}
		
		return SUCCESS;
	}
	

}
