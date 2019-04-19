<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

     <%
        String id = request.getParameter("id");     
    %>
    
    <h2>id = <%=id%> </h2>
     
  ${requestScope.postdetail.title}   <br/>
  ${requestScope.postdetail.content} <br/>
  ${requestScope.postdetail.author}   <br/>
  ${requestScope.postdetail.date]}    <br/><br/>
  
  
</body>
</html>