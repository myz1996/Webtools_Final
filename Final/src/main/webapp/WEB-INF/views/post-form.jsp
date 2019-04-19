<%@ page session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome ${requestScope.user.username} 
<form:form commandName="post">

title: <form:input path="title"/><br/>
content: <form:textarea path="content" rows="5" cols="30"/> <form:errors path="content"/><br/>

<input type="submit" value="new post"/>
</form:form>

</body>
</html>