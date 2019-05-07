package com.neu.edu.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.neu.edu.pojo.Post;
import com.neu.edu.pojo.User;

public class PostDao extends DAO{

public PostDao() {
		
	}
	
	public Post create(Post p){
		try {
			begin();
			getSession().save(p);
			commit();
			return p;
		} catch (HibernateException e) {
			rollback();
			return null;
		}
		
	}
	
	public List getAll() {
		try {
		    begin();
		    List li = getSession().createSQLQuery("select * from post").list();
		    commit();
		    List<Post> list = new ArrayList<Post>();
		    Iterator it = li.iterator();
		    
		    while(it.hasNext()){
		    Post post = new Post();
		    Object[] objs = (Object[])it.next();
		    post.setPostId(Integer.parseInt(objs[0].toString()));
		    post.setTitle(objs[3].toString());
		    post.setContent(objs[1].toString());
		    post.setDate(objs[2].toString());
		    post.setAuthorid(objs[4].toString());
		    list.add(post);
		    }
		    
		    //System.out.println("Postdao "+list.isEmpty()+" "+list.size());
		    HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		    request.setAttribute("post", list);
		    return list;
		    
		}catch(HibernateException e) {
			rollback();
			return null;
		}
		
	}
	
	
	public Post searchById(int postId) {
		try {
			begin();
			Query q = getSession().createQuery("from Post where postId = :postId");
			q.setLong("postId", postId);
			Post post = (Post) q.uniqueResult();
			commit();
			return post;
			
		}catch(HibernateException e) {
			rollback();
			return null;
		}
	}
	
	
	public void delete(Post post) {
		try {
			begin();
			getSession().delete(post);
			commit();
		}catch(HibernateException e) {
			rollback();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
