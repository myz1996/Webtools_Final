<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>User</title>
</head>
<body>
<h1 align="center" style="color:red ">Welcome ${sessionScope.user.username}   </h1>
        
<img align="middle" src="photo.htm" width="100" height="100" class="img-circle"/>
<a href="friend.htm?userid=${sessionScope.user.userid}">View Friends</a>&nbsp;&nbsp;
<a href="viewmessage.htm?userid=${sessionScope.user.userid}">View Message</a>


<form action="photo.htm" method="post" enctype="multipart/form-data" role="form">
    <div class="form-group">
    <label for="inputfile">Select a photo: </label><input type="file" name="photo" />
    <input type="submit" value="confirm">
    </div>
</form>


<h2 align="right" style="color:red "><a href="post.htm"> New Post</a></h2>

<c:if test="${requestScope.post!=null}">
<table class="table table-hover">
   <caption align="top">Post List</caption>
   <tr>
       <th>Post Id</th><th>Title</th><th>Date</th><th>Author Id</th>
   </tr>
   
   
   <c:forEach items="${requestScope.post}" var="rs" >
   <tr>
      <td>${rs.getPostId()}</td>
      <td><a href="postdetail.htm?id=${rs.getPostId()}">${rs.getTitle()}</a></td>
      <td>${rs.getDate()}</td>
      <td>${rs.getAuthorid()}</td>
   </tr>
   
   </c:forEach>
   
</table>
</c:if>

</body>
</html>