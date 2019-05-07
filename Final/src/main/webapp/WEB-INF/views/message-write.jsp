<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>write a message</title>
</head>
<body>
      <br/><br/><br/><br/>
      <p align="center" class="text-info" style="font-size:20px">Write a Message</p>
     <form action="sendmessage.htm" method="post" role="form">
       <div class="form-group">
         <label for="name">Message </label>
         <input type="text" name="messagecontent" class="form-control" placeholder="message"/>
       </div>
       <div align="center">
          <input type="submit" value="send now" class="btn btn-default"/>
       </div> 
       
     </form>
</body>
</html>