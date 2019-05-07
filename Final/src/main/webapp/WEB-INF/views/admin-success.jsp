<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
Welcome ${requestScope.user.username}
<h1>Admin page</h1>

<a href="adminpost.htm">Manage Post</a>
<a href="adminuser.htm">Manage User</a>




</body>
</html>