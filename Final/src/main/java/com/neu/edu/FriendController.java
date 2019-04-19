package com.neu.edu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.dao.UserDao;
import com.neu.edu.pojo.User;

@Controller
@RequestMapping("/friend.htm")
public class FriendController {
    
	private int userid;
	
	public FriendController() {
		
		
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String formView(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("userid");
		System.out.println(id);
		this.userid = Integer.parseInt(id);
		UserDao userdao = new UserDao();
		List<String> list = userdao.getFriend(this.userid);
		//System.out.println(list.get(0));
		HttpSession session = request.getSession();
		//request.setAttribute("friendlist", list);
		session.setAttribute("friendlist", list);
		return "friend-search";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String successView(HttpServletRequest request, HttpServletResponse response) {
		String number = request.getParameter("number");
		String type = request.getParameter("type");
		UserDao userdao = new UserDao();
		User user = new User();
		if(type.equals("id")) {
			user = userdao.searchById(Integer.parseInt(number));
		}else {
			user = userdao.login(number);
		}
		request.setAttribute("result", user);
		return "friend-result";
	}
	
	
	
	
}
