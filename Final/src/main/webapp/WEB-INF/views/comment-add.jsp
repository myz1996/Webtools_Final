<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>New Comment</title>
</head>
<body>
<br/><br/><br/><br/>
<p align="center" class="text-info" style="font-size:20px">New Comment</p>
<form:form commandName="comment" role="form">
       <div class="form-group">
         <label for="name">content </label>
         <form:input path="content" class="form-control" placeholder="content"/>
         <form:errors path="content"/>  
       </div>
       <div align="center">
         <input type="submit" value="new!" class="btn btn-default"/>
       </div>
    </form:form>
</body>
</html>