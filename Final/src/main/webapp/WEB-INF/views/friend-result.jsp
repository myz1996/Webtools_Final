<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Result</title>
</head>
<body>
    <h1>Friend Search Result</h1>
    
    User id: ${requestScope.result.userid} 
    <br/>
    Username:${requestScope.result.username} 
    
    
    <form method="post" action="addfriend.htm">
         
         <input type="hidden" value="${requestScope.result.userid}" name="friendid" />
         <input type="submit" value="add"/>
         
    </form>
</body>
</html>