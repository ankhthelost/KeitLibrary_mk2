package jp.co.keit.controller.contact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
	
	@RequestMapping(path = "/contact")
	public String showContact() {
		return "contact";
	}
}
