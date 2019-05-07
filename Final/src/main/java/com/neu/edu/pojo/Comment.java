package com.neu.edu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="comment")
public class Comment {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentid;
	
	@Column(name="content")
	private String content;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="postid")
	private Post postid;
	
	@Column(name="date")
	private String date;
	
	//@Transient
	//private long userid;
	
	
	public long getCommentid() {
		return commentid;
	}

	public void setCommentid(long commentid) {
		this.commentid = commentid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Post getPostid() {
		return postid;
	}

	public void setPostid(Post postid) {
		this.postid = postid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

//	public long getUserid() {
//		return userid;
//	}
//
//	public void setUserid(long userid) {
//		this.userid = userid;
//	}

	
	
	
	
}
