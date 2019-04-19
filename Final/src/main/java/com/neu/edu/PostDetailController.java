package com.neu.edu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.dao.PostDao;
import com.neu.edu.pojo.Post;


@Controller
@RequestMapping("/postdetail.htm")
public class PostDetailController {

	public PostDetailController() {
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String formView(HttpServletRequest request, HttpServletResponse response) {
		String postid = request.getParameter("id");
        System.out.println("request .getParameter "+postid);	
		
        PostDao postdao = new PostDao();
        Post post = postdao.searchById(Integer.parseInt(postid));
        System.out.println("result "+post.getTitle());
        request.setAttribute("postdetail", post);
		return "post-detail";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "post-detail";
	}
}
