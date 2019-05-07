package com.neu.edu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.dao.UserDao;
import com.neu.edu.pojo.User;

@Controller
@RequestMapping("/deletefriend.htm")
public class DeleteFriendController {

	public DeleteFriendController() {
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String formView(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		UserDao userdao = new UserDao();
		User user2 = userdao.searchById(user.getUserid());
		for(String s:user2.getFriendlist()) {
			if(s.equals(id)) {
				user.getFriendlist().remove(s);
			}
		}
		userdao.addFriend(user2);
		return "friend-success";
	}

	@RequestMapping(method = RequestMethod.POST)
	public void successView(HttpServletRequest request, HttpServletResponse response) {
		
		
	}
	
}
