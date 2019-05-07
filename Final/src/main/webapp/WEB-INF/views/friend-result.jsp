<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Search Result</title>
</head>
<body>
    <p align="center" class="text-info" style="font-size:20px">Friend Search Result</p>
    <table  class="table table-hover">
       <tr>
          <th><p class="text-info">User ID</p></th>
          <th><p class="text-success">${requestScope.result.userid}</p></th>
       </tr>
       <tr>
          <th><p class="text-info">Username</p></th>
          <th><p class=text-success">${requestScope.result.username}</p> </th>
       </tr>
  </table>
    
    <form method="post" action="addfriend.htm" role="form">
         
         <input type="hidden" value="${requestScope.result.userid}" name="friendid" />
         <div align="center">
            <input type="submit" value="add" class="btn btn-default"/>
         </div>
    </form>
</body>
</html>