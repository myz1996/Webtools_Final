<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Post</title>
</head>
<body>
   <h2>Delete a Post</h2>
   <form action="adminpost.htm" method="post">
       Post id: <input type="text" name="id"/>
       <input type="submit" value="delete"/>
   </form>
   
  <c:if test="${requestScope.post!=null}">
   <table>
   <tr>
       <th>Post Id</th><th>Title</th><th>Date</th><th>Author Id</th>
   </tr>
   
   <c:forEach items="${requestScope.post}" var="rs" >
   <tr>
      <td>${rs.getPostId()}</td>
      <td><a href="postdetail.htm?id=${rs.getPostId()}">${rs.getTitle()}</a></td>
      <td>${rs.getDate()}</td>
      <td>${rs.getAuthorid()}</td>
   </tr>
   
   </c:forEach>
  
   </table>
</c:if>
   


 
</body>
</html>