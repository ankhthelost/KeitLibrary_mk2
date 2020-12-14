package jp.co.keit.controller.user;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.keit.bean.UserBean;
import jp.co.keit.form.UserForm;

@Controller
public class UserController {
	
	@Autowired
	EntityManager entityManager;
	
	@RequestMapping(path = "/user/regist", method = RequestMethod.GET)
	public String moveToUserRegist(@ModelAttribute UserForm userForm) {
		return "user/user_regist";
	}
	
	@RequestMapping(path = "/user/check", method = RequestMethod.POST)
	public String userRegistCheck(@Valid @ModelAttribute UserForm userForm, BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			return "user/user_regist";
		}else{
			
			UserBean userBean = new UserBean();
			
			userBean.setUserName(userForm.getUserName());
			userBean.setMailAddress(userForm.getMailAddress());
			userBean.setPassword(userForm.getPassword());
			
			model.addAttribute(userBean);
			
			return "user/user_check";
		}
	}
	
	@Transactional
	@RequestMapping(path = "/user/complete", method = RequestMethod.POST)
	public String usetRegistComplete(@Valid @ModelAttribute UserForm userForm, BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			return "user/user_check";
		}
		
		Query query = entityManager.createNativeQuery("INSERT INTO users(USER_ID, USER_NAME, MAIL_ADDRESS, PASSWORD, ROLE, DELETE_FLG) VALUES (seq_users.NEXTVAL, :userName, :mailAddress, ORA_HASH(:password), :role, :deleteFlg)");
		
		
		query.setParameter("userName", userForm.getUserName());
		query.setParameter("mailAddress", userForm.getMailAddress());
        query.setParameter("password", userForm.getPassword());
        query.setParameter("role", 1);
        query.setParameter("deleteFlg", 0);
        
        
        query.executeUpdate();
		
		
		return "user/user_detail";
	}
	
}
