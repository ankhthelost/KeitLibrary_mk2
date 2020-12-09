package jp.co.keit.util;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;

import jp.co.keit.repository.UserRepository;

public class LoginValidator implements ConstraintValidator<Login, Object> {
	
	private String mailAddress;
	private String password;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	HttpSession session;
	
	@Override
	public void initialize(Login annotation) {
		this.mailAddress = annotation.fieldMailAddress();
		this.password = annotation.fieldPassword();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		BeanWrapper wrapper = new BeanWrapperImpl(value);
		
		String mailAddress = (String)wrapper.getPropertyValue(this.mailAddress);
		String password = (String)wrapper.getPropertyValue(this.password);
		
		System.out.println(mailAddress);
		System.out.println(password);
		
		if(userRepository.findByMailAddressAndPassword(mailAddress, password) != null) {
			session.setAttribute("user", userRepository.findByMailAddressAndPassword(mailAddress, password));
			return true;
		}else {
			return false;
		}
	}
}
