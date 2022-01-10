<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Result</title>
<link rel="stylesheet" type="text/css" href="navbar.css" >
</head>
<body>
<ul>
	<li><a>FlyAway</a></li>
	<li><a href="homePage.html">Home</a></li>
  	<li style="float:right"><a href="logout">Logout</a></li>
</ul>
  <h1>	Welcome : <%= session.getAttribute("name") %></h1> 
	<form action="checkoutPage" method="post"> 
		<table>
			<c:forEach var="flight" items="${flights}" >				
				<tr>
					<td>Flight Number</td>
					<td>:</td>	
					<td>${flight.flight_no}</td>
					<td></td>
				</tr>
				<tr>   
					<td>Airline</td>
					<td>:</td>
					<td>${flight.airline}</td>
					<td></td>
				</tr>
				<tr>
					<td>Cost per Person</td>
					<td>:</td>			
					<td>${flight.price}</td>
					<td></td> 					
				</tr>
				<tr>
					<td>Departure Time</td>
					<td>:</td>			
					<td>${flight.departure_time}</td>
					<td></td> 					
				</tr>

				<tr>
					<td>Duration</td>
					<td>:</td>			
					<td>${flight.duration}</td>
					<td></td> 					
				</tr>

				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td><input type="submit"  name="${flight.flight_no}" value="Book" ></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>