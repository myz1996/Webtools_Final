<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post</title>
</head>
<body>
   Welcome ${requestScope.post.author}
   ${requestScope.post.content}  
</body>
</html>