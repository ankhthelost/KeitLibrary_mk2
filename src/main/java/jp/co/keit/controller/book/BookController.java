package jp.co.keit.controller.book;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import jp.co.keit.bean.BookBean;
import jp.co.keit.form.BookForm;
import jp.co.keit.repository.AuthorRepository;
import jp.co.keit.repository.BookRepository;
import jp.co.keit.repository.GenreRepository;
import jp.co.keit.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	GenreRepository genreRepository;
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	BookService bookService;

	@RequestMapping (path = "/book",  method = RequestMethod.GET)
	public String moveToBookList(@ModelAttribute BookForm bookForm,  Model model) {
				
		return "book/book_list";
	}
	
	@RequestMapping (path = "/book/result", method = RequestMethod.POST)
	public String showResultByName(@Valid @ModelAttribute BookForm bookForm, BindingResult result, 
			Model model) {
		if(result.hasErrors()) {
			return "book/book_list";
		}else {
			
			List<BookBean> bookBeans = bookService.getBookByNameLike(bookForm);
			
			model.addAttribute("bookBeans", bookBeans);
			
			return "book/book_list";
		}
	}
	
	@RequestMapping (path = "/book/detail/{bookName}", method = RequestMethod.GET)
	public String showBookDetail (@PathVariable String bookName, Model model) {
		
		BookBean bookBean = bookService.getBook(bookName);
		
		model.addAttribute("book", bookBean);
		
		return "book/book_detail";
	}
}
