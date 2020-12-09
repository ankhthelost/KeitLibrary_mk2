package jp.co.keit.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jp.co.keit.util.Login;

@Login
public class LoginForm {
	
	@NotBlank
	@Email
	private String mailAddress;
	
	@NotBlank
	@Size(min = 8, max = 16)
	@Pattern(regexp="^[a-zA-Z0-9]+$")
	private String password;

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
