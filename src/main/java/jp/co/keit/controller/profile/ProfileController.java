package jp.co.keit.controller.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
	
	@RequestMapping(path = "/profile")
	public String showProfile() {
		return "profile";
	}
}
