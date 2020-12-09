package jp.co.keit.form;

import javax.validation.constraints.NotBlank;

public class BookForm {
	
	@NotBlank
	private String bookName;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

}
