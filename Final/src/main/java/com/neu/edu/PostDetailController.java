package com.neu.edu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.dao.CommentDao;
import com.neu.edu.dao.PostDao;
import com.neu.edu.pojo.Comment;
import com.neu.edu.pojo.Post;
import com.neu.edu.pojo.User;


@Controller
@RequestMapping("/postdetail.htm")
public class PostDetailController {

	public PostDetailController() {
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String formView(HttpServletRequest request, HttpServletResponse response) {
		String postid = request.getParameter("id");
        System.out.println("request .getParameter "+postid);	
        HttpSession session = request.getSession();
        User u = (User)session.getAttribute("user");
        long userid = u.getUserid();
		
        PostDao postdao = new PostDao();
        Post post = postdao.searchById(Integer.parseInt(postid));
        System.out.println("result "+post.getTitle());
        
        session.setAttribute("postdetail", post);
        request.setAttribute("postdetail", post);
        
        CommentDao commentdao = new CommentDao();
        System.out.println(postid);
        List<Comment> list = commentdao.getComment(Integer.parseInt(postid));
        System.out.println("comment list"+list.isEmpty());
        session.setAttribute("comment", list);
        request.setAttribute("comment", list);
		return "post-detail";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "post-detail";
	}
}
