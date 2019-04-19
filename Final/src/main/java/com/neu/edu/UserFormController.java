package com.neu.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.dao.UserDao;
import com.neu.edu.pojo.User;
import com.neu.edu.validator.UserValidator;

@Controller
@RequestMapping("/user.htm")
public class UserFormController {

	@Autowired
	UserValidator uservalidator;
	
	

	// Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(uservalidator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, User user) {
		user.setUsername("input your username"); // if object has values, these would populate the form view automatically
		 // if an existing object populates the form fields, it is called
									// form-backing-object
        user.setPassword("password");
		model.addAttribute("user", user);
		return "user-form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "user-form";  
		}
		user.getFriendlist().add("1");
		user.getFriendlist().add("2");
		UserDao userdao = new UserDao();
		userdao.register(user);
		if(user.getType().equals("user")) {
		    
			return "user-success";
		}else {
			 
			return "admin-success";
		}
	}
	
}
