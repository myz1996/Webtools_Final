package com.neu.edu.pojo;


import java.util.HashMap;
import java.util.HashSet;

import java.util.Map;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name="photo")
	private byte[] photo;
	
	@OneToMany(targetEntity=Post.class,mappedBy="author",cascade = {CascadeType.ALL})	
	@LazyCollection(LazyCollectionOption.EXTRA)
	//@JoinColumn(name = "USER_ID")
	private Set<Post> postlist;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="friend", joinColumns= {@JoinColumn(name="userid",referencedColumnName = "userid")})
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@Column(name="friendid")
	private Set<String> friendlist;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="message",joinColumns ={@JoinColumn(name = "userid", referencedColumnName = "userid")}) 
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@Column(name = "message_content")
	@MapKeyColumn(name="sendid") 
	private Map<String,String> messagelist;
	
	@Column(name="type")
	private String type;
	

	public User() {
      postlist = new HashSet<Post>();
      friendlist = new HashSet<String>();
      messagelist = new HashMap<String,String>();
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPostlist(Set<Post> postlist) {
		this.postlist = postlist;
	}

	public Set<String> getFriendlist() {
		return friendlist;
	}

	public void setFriendlist(Set<String> friendlist) {
		this.friendlist = friendlist;
	}

	public Set<Post> getPostlist() {
		return postlist;
	}

	public String toString() {
		return username;
	}

	public Map<String, String> getMessagelist() {
		return messagelist;
	}

	public void setMessagelist(Map<String, String> messagelist) {
		this.messagelist = messagelist;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	
}
