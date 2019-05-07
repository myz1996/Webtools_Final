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
<title>Register</title>
</head>
<body>
<br/><br/><br/><br/>
<h2 align="center">Register</h2><br/><br/>
<form:form commandName="user" role="form">
  <div class="form-group">
   <label for="name">username:</label> 
   <form:input path="username" class="form-control" id="name" placeholder="username"/>
   <form:errors path="username"/>
  </div>
  <div class="form-group">
   <label for="name">password: </label>
   <form:input path="password" class="form-control" id="name" placeholder="password" /> 
   <form:errors path="password"/>
  </div>
  <div align="center">
       type: <form:radiobutton path="type" value="admin" checked="true" />Admin 
      <form:radiobutton path="type" value="user" />User
      </div>
    <div align="center"> 
    <input type="submit" class="btn btn-default" value="Register"/>
   </div> 
</form:form>

</body>
</html>