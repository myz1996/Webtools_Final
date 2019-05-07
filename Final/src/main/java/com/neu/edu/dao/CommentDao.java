package com.neu.edu.dao;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.edu.pojo.Comment;

public class CommentDao extends DAO {

	public CommentDao() {
		
	}
	
	public Comment add(Comment c) {
		try {
			begin();
			getSession().save(c);
			commit();
			return c;
		}catch(HibernateException e) {
			rollback();
			return null;
		}
	}
	
	
	
	public List getComment(int postid) {
		try {
			begin();
			Query q = getSession().createSQLQuery("select * from comment where postid = :postid");
		    q.setLong("postid", postid);
		    List li = q.list();
		    commit();
		    
		    List<Comment> list  = new ArrayList<Comment>();
		    Iterator it = li.iterator();
		    
		    while(it.hasNext()){
		    Object[] ob = (Object[])it.next();
		    Comment c = new Comment();
		    //c.setCommentid((Long)ob[0]);
		    c.setContent(ob[1].toString());
		    
		    c.setDate(ob[2].toString());
		    list.add(c);
		    }
		    return list;
		}catch(HibernateException e) {
			rollback();
			return null;
		}
	}
}
