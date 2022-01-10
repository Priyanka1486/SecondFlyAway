<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation Page</title>
<link rel="stylesheet" type="text/css" href="navbar.css" >
</head>
<body>
<ul>
	<li><a>FlyAway</a></li>
	<li><a href="homePage.html">Home</a></li>
  	<li style="float:right"><a href="logout">Logout</a></li>
</ul>
	 <h1>	Welcome : <%= session.getAttribute("name") %></h1>
	 <h2> Ticket Confirmation </h2>
	 
</body>
</html>