
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page
	import="java.util.*"%>
<%@page import="com.MentorOnDemand.model.Skills"%>

<!DOCTYPE html>
<html>
<head>
<script src="Script/script.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" type="text/css" href="Style/style.css">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<%long id = (Long)session.getAttribute("name");%>

	<div class="topnav" id="myTopnav">

		<a href="notification">Notifications</a> <a href="#contact">Current
			Trainings</a> <a href="#about">Completed Trainings</a> <a href="#home">EditSkills</a>
		<a href="#"><h5 class="pull-left login-person-head">
				Welcome
				<%=session.getAttribute("name")%></h5></a>
				<a href="mentorUpdate?id=<%=id%>">Update Details</a>
			 <a href="logout"><button class="btn-primary">Logout</button></a> <a
			href="javascript:void(0);" class="icon" onclick="myFunction()"> <i
			class="fa fa-bars"></i>
		</a>
	</div>

	<div id="content"></div>

</body>
</html>

