package com.neu.edu;


import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

import com.neu.edu.dao.UserDao;
import com.neu.edu.pojo.User;

@Controller
@RequestMapping("/photo.htm")
public class PhotoController {

	
public PhotoController() {
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void formView(HttpServletRequest request, HttpServletResponse response) {
   
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		UserDao userdao = new UserDao();
		User user = userdao.searchById(u.getUserid());
		byte[] photo = user.getPhoto();
		
		try {
			
			OutputStream out = response.getOutputStream();
			response.setContentType("image/jpeg");
			if(photo!=null) {
			out.write(photo);
			}
		    out.flush();
		    out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public void successView(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		
		FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        InputStream input = null;
        byte[] buffer=null;
        try {
			List<FileItem> list = upload.parseRequest(request);
			System.out.println("list"+list.isEmpty());
			for (FileItem item : list) {
				input = item.getInputStream();
				//System.out.println("input"+input);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				buffer = new byte[input.available()];
				int num = input.read(buffer);
				while (num != -1) {
	                baos.write(buffer, 0, num);
	                num = input.read(buffer);
	            }
	            baos.flush();
	            
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (input!= null) {
                input.close();
            }
		}
        
		UserDao userdao = new UserDao();
		User user = userdao.searchById(u.getUserid());
		userdao.uploadPhoto(user,buffer);
		
		
	}  
	
	
	
	
}
