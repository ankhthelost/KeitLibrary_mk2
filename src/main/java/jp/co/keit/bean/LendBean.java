package jp.co.keit.bean;

import jp.co.keit.entity.Book;

public class LendBean {
	// 貸出する人の名前
	private String userName;
	
	// メールアドレス
	private String mailAddress;
	
	// 住所
	private String address;
	
	// 電話番号
	private String phoneNumber;
	
	// 借りる本の情報
	private Book book;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	

}
