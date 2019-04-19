package com.neu.edu.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.pojo.User;


public class UserDao extends DAO {

	public UserDao() {
		
	}
	
	public User register(User u){
		try {
			begin();
			getSession().save(u);
			commit();
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
	
	public User searchById(int userid) {
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
	
	public User addFriend(User user,String friendid) {
		try {
			begin();
			user.getFriendlist().add(friendid);
			getSession().update(user);
			getSession().flush();
			commit();
			getSession().flush();
			return user;
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
