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
@RequestMapping("/sendmessage.htm")
public class SendMessageController {

	private String sendid;
	
	public SendMessageController() {
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String formView(HttpServletRequest request, HttpServletResponse response) {
		
		String sendid = request.getParameter("sendid");
		this.sendid = sendid;
		return "message-write";
		
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String content = request.getParameter("messagecontent");
		User user = (User) session.getAttribute("user");
		System.out.println("content is " +content);
		System.out.println("user "+user.getUsername());
		
		UserDao userdao = new UserDao();
		User user2 = userdao.searchById(user.getUserid());
		user2.getMessagelist().put(this.sendid, content);
		userdao.addFriend(user2);
		
		
		
		return "message-success";
	}
}
