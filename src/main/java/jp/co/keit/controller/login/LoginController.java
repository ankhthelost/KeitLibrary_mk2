package jp.co.keit.controller.login;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.keit.form.LoginForm;
import jp.co.keit.repository.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String top() {
		return "index";
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login(@ModelAttribute LoginForm form){
		return "login";
	}
	
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute @Valid LoginForm form, BindingResult result) {
		if(result.hasErrors()) {
			return login(form);
		}else {
			return "index";
		}
	}
	
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout() {
		session.removeAttribute("user");
		return "redirect:/";
	}

}
