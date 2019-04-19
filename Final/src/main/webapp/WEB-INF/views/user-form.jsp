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

<form:form commandName="user">
username: <form:input path="username"/> <form:errors path="username"/><br/>
password: <form:input path="password"/> <form:errors path="password"/><br/>
type: <form:radiobutton path="type" value="admin" checked="true"/>Admin 
      <form:radiobutton path="type" value="user"/>User<br/>
<input type="submit"/>
</form:form>

</body>
</html>