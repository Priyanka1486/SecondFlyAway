<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="navbar.css" >
</head>
<body>
<ul>
	<li><a>FlyAway</a></li>
	<li><a href="homePage.html">Home</a></li>
  	<li style="float:right"><a href="logout">Logout</a></li>
</ul>
	
	<h1> Welcome, you are my best friend : <%= session.getAttribute("name") %> </h1>
	<form action="dashboard" method="post">
		<table>
			<tr>
				<td><label>From : </label></td>
				<td><input type="text" name="source" pattern="[A-Z][a-z]*" title="Enter name of place" required="required"></td>
			</tr>
			<tr></tr>
			<tr>
				<td><label>To : </label></td>
				<td><input type="text" name="destination" pattern="[A-Za-z]*" title="Enter name of place" required="required" ></td>
			</tr>
			<tr></tr>
			<tr>
				<td><label>Date : </label></td>
				<td><input type="date" name="traveldate"  required="required"></td>
			</tr>
			<tr></tr>
			<tr>
				<td><label>Number of Passengers : </label></td>
				<td><input type="number" name="passengers" pattern="[0-9]" title="Enter no. of Passengers" required="required" ></td>
			</tr>
			<tr></tr>
			<tr>
				<td><input type="submit" value="Search"></td>
				<td></td>
			</tr>
			<tr></tr>
			
		</table>
	</form>
</body>
</html>