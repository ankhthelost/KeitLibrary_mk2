package jp.co.keit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.keit.bean.BookBean;
import jp.co.keit.entity.Book;
import jp.co.keit.form.BookForm;
import jp.co.keit.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;

	public List<BookBean> getBookByNameLike(BookForm bookForm) {
		List<Book> books = bookRepository.findByBookNameLike("%" + bookForm.getBookName() + "%");
		return getBooks(books);
	}
	
	public BookBean getBook(String bookName) {
		Book book = bookRepository.findByBookName(bookName);
		return getBook(book);
	}
	
	public BookBean getBook(Book book) {
		BookBean bookBean = new BookBean();
		bookBean.setBookId(book.getBookId());
		bookBean.setBookName(book.getBookName());
		bookBean.setPublisherName(book.getPublisher().getPublisherName());
		bookBean.setPublishDate(book.getPublishDate());
		bookBean.setStatusName(book.getStatus().getStatusName());
		bookBean.setSummary(book.getSummary());
		return bookBean;
	}
	
	
	
	public List<BookBean> getBooks(List<Book> books) {
		List<BookBean> bookBeans = new ArrayList<>();
		
		for(Book book : books) {
			BookBean bookBean = new BookBean();
			bookBean.setBookId(book.getBookId());
			bookBean.setBookName(book.getBookName());
			bookBean.setPublisherName(book.getPublisher().getPublisherName());
			bookBean.setPublishDate(book.getPublishDate());
			bookBean.setStatusName(book.getStatus().getStatusName());
			bookBean.setSummary(book.getSummary());
			bookBeans.add(bookBean);
		}
		return bookBeans;
		
	}
}
