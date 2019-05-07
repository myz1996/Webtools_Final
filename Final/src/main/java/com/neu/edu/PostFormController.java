package com.neu.edu;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.neu.edu.dao.PostDao;

import com.neu.edu.pojo.Post;
import com.neu.edu.pojo.User;
import com.neu.edu.validator.PostValidator;


@Controller
@RequestMapping("/post.htm")
public class PostFormController {

	@Autowired
	PostValidator postvalidator;
	
	

	// Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(postvalidator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, Post post) {
		post.setContent("input content");; // if object has values, these would populate the form view automatically
		 // if an existing object populates the form fields, it is called
									// form-backing-object
        
		model.addAttribute("post", post);
		return "post-form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(@Validated @ModelAttribute("post") Post post, BindingResult bindingResult,HttpServletRequest request,Locale locale, ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "post-form";  
		}
		PostDao postdao = new PostDao();
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		post.setDate(formattedDate);  //set date
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		System.out.println(user);
		post.setAuthor(user);        //set author
		postdao.create(post);
		
		return "post-success";
	}
	
}
