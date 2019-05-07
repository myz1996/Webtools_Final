package com.neu.edu;

import java.util.List;
import java.util.Map;

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
@RequestMapping("/viewmessage.htm")
public class ViewMessageController {

	public ViewMessageController() {
		
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String formView(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid");
		System.out.println("view message user id"+userid);
		UserDao userdao = new UserDao();
		Map map = userdao.getMessage(Integer.parseInt(userid));
		HttpSession session = request.getSession();
		session.setAttribute("messagelist", map);
		return "message-view";
	}

	@RequestMapping(method = RequestMethod.POST)
	public void successView(HttpServletRequest request, HttpServletResponse response) {
		
		
		
	}
}
