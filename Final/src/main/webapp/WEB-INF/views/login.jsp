<%@ page session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Login Final version</title>
</head>
<body>
<br/><br/><br/><br/>
<p align="center" class="text-info" style="font-size:20px">Login</p><br/><br/>
<form action="login.htm" method="post" role="form">
   <div class="form-group">
      <label for="name">Username </label> 
      <input type="text" name="username" class="form-control" placeholder="username"/>
   </div>
   <div class="form-group">
      <label for="name">Password </label>
      <input type="text" name="password" class="form-control" placeholder="password"/>
   </div>
   <div align="center"> 
      <input type="submit" class="btn btn-default" value="Login"/>
   </div>
</form>

</body>
</html>