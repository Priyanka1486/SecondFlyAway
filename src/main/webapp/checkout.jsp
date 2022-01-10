<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout Page</title>
<link rel="stylesheet" type="text/css" href="navbar.css" >
</head>
<body>
<ul>
	<li><a>FlyAway</a></li>
	<li><a href="homePage.html">Home</a></li>
  	<li style="float:right"><a href="logout">Logout</a></li>
</ul>
	<h1>Welcome : <%= session.getAttribute("name") %></h1>
	<%  Enumeration<String> enum1 = request.getParameterNames(); %>
	<c:set var="fid" scope="session" value="<%= enum1.nextElement() %>" > </c:set>
	<form action="confirmation" method="post">
		<table>
			<c:forEach var="flight" items="${flights}" >				
			<c:if test="${flight.flight_no == fid}">
				<tr>
					<td>Source</td>
					<td>:</td>	
					<td>${source}</td>
				</tr>
				<tr>
					<td>Destination</td>	
					<td>:</td>
					<td>${destination}</td>
				</tr>
				<tr>
					<td>Travel Date</td>	
					<td>:</td>
					<td>${traveldate}</td>
				</tr>
				<tr>
					<td>Flight Number</td>
					<td>:</td>	
					<td>${flight.flight_no}</td>
				</tr>
				<tr>
					<td>Airline</td>
					<td>:</td>
					<td>${flight.airline}</td>
				</tr>
				<tr>
					<td>Cost per Person</td>
					<td>:</td>			
					<td>${flight.price}</td>	
				</tr>
				<tr>
					<td>Number of Passengers</td>
					<td>:</td>			
					<td>${passengers}</td>
				</tr>
				<tr>
					<td>Departure Time</td>
					<td>:</td>			
					<td>${flight.departure_time}</td>
				</tr>

				<tr>
					<td>Duration</td>
					<td>:</td>			
					<td>${flight.duration}</td>
				</tr>
				<tr>
					<td>Available seats</td>
					<td>:</td>			
					<td>${flight.available_seat}</td>
					<c:set var="available_seat" scope="session" value="${flight.available_seat}" > </c:set>	
				</tr>

				<tr>
					<td>Total Cost</td>
					<td>:</td>			
					<td>${passengers*flight.price}</td>					
				</tr>
				</c:if>			
			</c:forEach>
			<tr>
			<td><input type="submit" value="Book Tickets" ></td>
			</tr>
		</table>	
	</form>
</body>
</html>