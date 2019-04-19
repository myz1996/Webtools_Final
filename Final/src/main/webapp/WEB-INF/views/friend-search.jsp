<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <table>
   <tr>
       <th>user Id</th>
   </tr>
   <c:forEach items="${sessionScope.friendlist}" var="rs" >
   <tr>
      <td>${rs}</td>
   </tr>
   </c:forEach>
 </table>
 
 <h2>Search a Friend</h2>
   <form action="friend.htm" method="post">
      <input type="text" name="number"/><br/>
      
      Search By <input type="radio" name="type" value="id"/>id<input type="radio" name="type" value="username"/>username<br/>
      <input type="submit" value="Search Now!">
      
   </form>
</body>
</html>