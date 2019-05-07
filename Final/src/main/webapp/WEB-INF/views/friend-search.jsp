<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>View Friend</title>
</head>
<body>
  <br/><br/><br/><br/>
  <p align="center" class="text-info" style="font-size:20px">View Friends</p>
 <table class="table table-hover">
   <tr>
       <th>User Id</th> <th>Message Now</th><th>Break up</th>
   </tr>
   <c:forEach items="${sessionScope.friendlist}" var="rs" >
   <tr>
      
      <td>${rs}</td>
      <td><a href="sendmessage.htm?sendid=${rs}">Send a Message!</a></td>
      <td><a href="">Delete!</a></td>
   </tr>
   </c:forEach>
 </table>
 
 <p align="center" class="text-info" style="font-size:20px">Search a Friend</p>
   <form action="friend.htm" method="post" role="form">
      <div class="form-group">
         <input type="text" name="number" class="form-control" placeholder="id/username"/>
      </div>
      <div class="form-group" align="center">
          <label for="name">Search By </label>
          <input type="radio" name="type" value="id" checked="checked"/>
          <label for="name">id </label>
          <input type="radio" name="type" value="username"/>
          <label for="name">username </label>
      </div>
      <div align="center"> 
          <input type="submit" value="Search Now!" class="btn btn-default">
      </div>
   </form>
</body>
</html>