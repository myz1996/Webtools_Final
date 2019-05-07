package com.neu.edu.dao;

import java.io.File;
import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.neu.edu.pojo.User;


public class UserDao extends DAO {

	public UserDao() {
		
	}
	
	public User register(User u){
		try {
			begin();
			getSession().save(u);
			commit();
			close();
			return u;
		} catch (HibernateException e) {
			rollback();
			return null;
		}
		
	}
	
	
	
	public void delete(User user) {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			
		}
	}
	
	public boolean checkUsername(String username) {
		try {
			begin();
			Query q = getSession().createQuery("from User where username = :username");
			q.setString("username", username);
			List list = q.list();
			commit();
			if(list.size()==0) {
				return true;
			}else
			 return false;
		}catch(HibernateException e) {
			rollback();
			return false;
		}
	}
	
	
	
	public User login(String username) {
		try {
			
			begin();
			Query q = getSession().createQuery("from User where username = :username");
			q.setString("username", username);
			User user = (User) q.uniqueResult();
			commit();
			return user;
			
		}catch(HibernateException e) {
			rollback();
			return null;
		}
		
	}
	
	public User searchById(long userid) {
		try {
			
			begin();
			Query q = getSession().createQuery("from User where userid = :userid");
			q.setLong("userid", userid);
			User user = (User) q.uniqueResult();
			commit();
			return user;
			
		}catch(HibernateException e) {
			rollback();
			return null;
		}
		
	}
	
	public User uploadPhoto(User user,byte[] bFile) {
		try {
			begin();
//			File file = new File("/Users/miao/Desktop/112233.jpeg");
//	        byte[] bFile = new byte[(int) file.length()];
//	        
//	        try {
//		     FileInputStream fileInputStream = new FileInputStream(file);
//		     //convert file into array of bytes
//		     fileInputStream.read(bFile);
//		     fileInputStream.close();
//	        } catch (Exception e) {
//		     e.printStackTrace();
//	        }
	        
	        
	        user.setPhoto(bFile);
			
			getSession().update(user);
			getSession().flush();
			commit();
			return user;
		}catch(HibernateException e) {
			rollback();
			return null;
		}
	}
	
	public byte[] getPhoto(String username) {
		try {
			begin();
			//Session session = getSession();
			//User user2 = (User)session.get(User.class, user.getPhoto());
			Query q = getSession().createSQLQuery("select * from message where username = :username");
		    q.setString("username", username);
			//byte[] photo = user2.getPhoto();
			commit();
			return null;
		}catch(HibernateException e) {
			rollback();
			return null;
		}
	}
	
	public User addFriend(User user) {
		try {
			begin();
			//user.setUsername("daqiang");
			getSession().update(user);
			getSession().flush();
			commit();
			return user;
		}catch(HibernateException e) {
			rollback();
			return null;
		}
	}
	
	public Map getMessage(int sendid) {
		try {
			begin();
			Query q = getSession().createSQLQuery("select * from message where sendid = :sendid");
		    q.setLong("sendid",sendid);
		    List li = q.list();
		    commit();
		    //List<String> list = new ArrayList<String>();
		    Map<String,String> map = new HashMap<String,String>();
		    
		    Iterator it = li.iterator();
		    
		    while(it.hasNext()){
		    Object[] ob = (Object[])it.next();
		    map.put(ob[1].toString(), ob[2].toString());
		    }
		    
		    for (String v : map.values()) {
		      System.out.println("value= " + v);
		    }
		    
		    return map;
		}catch(HibernateException e) {
			rollback();
			return null;
		}
	}
	
	
	
	public List getFriend(int userid) {
		try {
			begin();
		    //List li = getSession().createSQLQuery("select * from Friend where userid = :userid").list();
		    Query q = getSession().createSQLQuery("select * from friend where userid = :userid");
		    q.setLong("userid", userid);
		    List li = q.list();
		    commit();
		    List<String> list = new ArrayList<String>();
		    Iterator it = li.iterator();
		    
		    while(it.hasNext()){
		    Object[] ob = (Object[])it.next();
		    list.add(ob[1].toString());
		    }
		    
		    System.out.println("userdao friend list "+list.isEmpty()+" "+list.size());
		   
		    return list;
		    
		}catch(HibernateException e) {
			rollback();
			return null;
		}
		
	}
	
	
	
	
	
	
	
}
