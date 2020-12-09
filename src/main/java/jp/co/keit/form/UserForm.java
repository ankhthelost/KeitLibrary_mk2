package jp.co.keit.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class UserForm {
	
	@NotBlank
	private String userName;
	
	@NotBlank
	private String mailAddress;
	
	@NotBlank
	@Length(min = 8, max = 16)
	@Pattern(regexp="^[a-zA-Z0-9]+$")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
