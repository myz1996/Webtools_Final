package com.neu.edu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.dao.PostDao;
import com.neu.edu.pojo.Post;



@Controller
@RequestMapping("/adminpost.htm")
public class AdminPostController {

	public AdminPostController() {
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String formView(HttpServletRequest request,HttpServletResponse response) {
		
		return "admin-post";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(HttpServletRequest request,HttpServletResponse response) {
		String id = request.getParameter("id");
		PostDao postdao = new PostDao();
		Post post = postdao.searchById(Integer.parseInt(id));
		postdao.delete(post);
		return "admin-post";
	}
	
	
	
	
}
