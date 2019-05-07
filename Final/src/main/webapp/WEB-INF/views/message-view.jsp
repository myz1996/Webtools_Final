<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>View Message</title>
</head>
<body>
   <br/><br/><br/><br/>
      <p align="center" class="text-info" style="font-size:20px">Message View</p>
   
   <table class="table table-hover">
      <tr>
         <th><p class="text-success">Message Content</p></th>
         <th><p class="text-success">Sender id</p></th>
      </tr>
      <c:forEach items="${sessionScope.messagelist}" var="rs" >
      <tr>
         <td><p class="text-info">${rs.key}</p></td>
         <td><p class="text-info">${rs.value}</p></td>
      </tr>
   
     </c:forEach>
   </table>
</body>
</html>