package com.neu.edu;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.neu.edu.dao.PostDao;
import com.neu.edu.dao.UserDao;
import com.neu.edu.pojo.User;


@Controller
@RequestMapping("/login")
public class LoginController {

	public LoginController() {
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void formView() {
		
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao userdao = new UserDao();
		User u = userdao.login(username);
		//System.out.println("dao : "+u.getUsername());
		//System.out.println("dao : "+u.getPassword());
		//System.out.println(password);
		if(u.getPassword().equals(password)) {
		    HttpSession session = request.getSession();
		    session.setAttribute("user", u);
		    PostDao postdao = new PostDao();
		    List list = postdao.getAll();
		    
		    //System.out.println(list.isEmpty());
		    //System.out.println(list.size());
         if(u.getType().equals("user")) {
			    
				return "user-success";
			}else {
				 
				return "admin-success";
			}
			
		}
			
		
		return "login";

	}

	
}
