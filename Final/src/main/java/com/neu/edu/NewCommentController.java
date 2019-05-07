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

import com.neu.edu.dao.CommentDao;
import com.neu.edu.dao.PostDao;
import com.neu.edu.pojo.Comment;
import com.neu.edu.pojo.Post;

import com.neu.edu.validator.CommentValidator;


@Controller
@RequestMapping("/newcomment.htm")
public class NewCommentController {

	
	public NewCommentController() {
		
	}
	
	@Autowired
	CommentValidator commentvalidator;
	
	

	// Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(commentvalidator);
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String formView(ModelMap model, Comment comment,HttpServletRequest request) {
		comment.setContent("content");
		model.addAttribute("comment",comment);
		//this.postid = request.getParameter("id");
		return "comment-add";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String successView(@Validated @ModelAttribute("comment") Comment comment, BindingResult bindingResult,Locale locale,HttpServletRequest request, ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "post-detail";  
		}
		//String postid = request.getParameter("postId");
		PostDao postdao = new PostDao();
		
		HttpSession session = request.getSession();
		Post p2 = (Post)session.getAttribute("postdetail");
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		comment.setDate(formattedDate); 
		comment.setPostid(p2);
		CommentDao cdao = new CommentDao();
		cdao.add(comment);
		
		return "comment-newsuccess";
	}
}
