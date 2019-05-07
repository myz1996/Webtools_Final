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
		
		
		UserDao userdao = new UserDao();
		User user2 = userdao.searchById(user.getUserid());
		
		for(String s:user2.getFriendlist()) {
			if(s.equals(friendid)) {
				System.out.println("already friends");
				return "friend-fail";
			}
		}
		user2.getFriendlist().add(friendid);
		userdao.addFriend(user2);   //one add friend
		
		//User user1 = userdao.searchById(Integer.parseInt(friendid));
		//user1.getFriendlist().add(String(user.getUserid()));
		//userdao.addFriend(user1);    //the other add friend
		//System.out.println();
		
		
		return "friend-search";
	}

	private String String(long userid) {
		// TODO Auto-generated method stub
		return null;
	}
}
