<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Post Detail</title>
</head>
<body>
     <br/><br/><br/><br/>
     <%
        String id = request.getParameter("id");     
     %>
     <p class="text-info" align="center" style="font-size:20px">Post Id <%=id%> </p><br/><br/>
     
     <table class="table table-hover">
        <caption>Post Detail</caption>
        <tr>
           <th><p class="text-info">Title</p></th>
           <th><p class="text-success"> ${requestScope.postdetail.title} </p></th>
        </tr>
        <tr>
           <th><p class="text-info">Content</p></th>
           <th><p class="text-success"> ${requestScope.postdetail.content} </p></th>
        </tr>
        <tr>
           <th><p class="text-info">Author Id</p></th>
           <th><p class="text-success"> ${requestScope.postdetail.author} </p></th>
        </tr>  
        <tr>
           <th><p class="text-info">Date</p></th>
           <th><p class="text-success"> ${requestScope.postdetail.date} </p></th>
        </tr>
     </table>
  <div align="right">    
 <a href="newcomment.htm">New Comment!</a>
  </div>  
  
  
  
  <table class="table table-hover">
   <caption>Comment List</caption>
   <tr>
       <th>NO.</th><th>Content</th><th>Date</th>
   </tr>
   
   
   <c:forEach items="${sessionScope.comment}" var="rs" varStatus="status">
   <tr>
      <td>${status.index+1}</td>
      <td>${rs.getContent()}</td>
      <td>${rs.getDate()}</td>
      

   
        
   </tr>
   
   </c:forEach>
   
</table>
  
</body>
</html>