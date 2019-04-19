package com.neu.edu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.dao.UserDao;
import com.neu.edu.pojo.User;

@Controller
@RequestMapping("/addfriend.htm")
public class AddFriendController {

	
	@RequestMapping(method = RequestMethod.GET)
	public void formView(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String friendid = request.getParameter("friendid");
		User user = (User) session.getAttribute("user");
		System.out.println("friend id " +friendid);
		System.out.println("user "+user.getUsername());
		//user.getFriendlist().add(friendid);
		UserDao userdao = new UserDao();
		userdao.addFriend(user,friendid);
		
		return "friend-search";
	}
}
