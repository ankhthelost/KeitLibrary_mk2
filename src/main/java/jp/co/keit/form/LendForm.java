package jp.co.keit.form;

import javax.validation.constraints.NotBlank;

public class LendForm {
	// 貸出する人の名前
	@NotBlank
	private String userName;
	
	// メールアドレス
	@NotBlank
	private String mailAddress;
	
	// 住所
	@NotBlank
	private String address;
	
	// 電話番号
	@NotBlank
	private String phoneNumber;
	
	// 書籍ID
	private Integer bookId;

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

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	
}
