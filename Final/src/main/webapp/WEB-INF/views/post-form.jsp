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
<title>Post</title>
</head>
<body>
<h2 align="center" style="color:red">New Post</h2>
<br/><br/><br/><br/>
<form:form commandName="post" role="form">
   <div class="form-group">
     <label for="name">Title </label> <form:input path="title" class="form-control"  placeholder="title"/>
   </div>
   <div class="form-group">
     <label for="name">Content </label> 
     <form:textarea path="content" rows="5" cols="30" placeholder="title" class="form-control"/>
     <form:errors path="content"/>
   </div>   
   <div align="center"> 
     <input class="btn btn-default" type="submit" value="new post"/>
   </div>
</form:form>

</body>
</html>