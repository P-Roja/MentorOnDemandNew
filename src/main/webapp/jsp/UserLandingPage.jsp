
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

	<div class="topnav" id="myTopnav">

		<a href="#"> <form:form class="form-inline" action="searchMentor"
				modelAttribute="mentor">

				<label for="email2" class="mb-2 mr-sm-2">Skills</label>


				<form:select class="form-control mb-2 mr-sm-2" id="email2"
					path="skills">
					<% ArrayList skillDetails= (ArrayList) request.getAttribute("skillsList");
					Iterator itr = skillDetails.iterator();
					String skillSet=null;
 					%>
					<option class="hidden" value="" selected disabled>Choose
						Skill</option>
					<% while(itr.hasNext()) {
					Skills skill = (Skills) itr.next();
					skillSet = skill.getSkillName();%>
					<option value="<%=skillSet %>"><%=skillSet %></option>
					<% 
					}
					%>


				</form:select>
				<button type="submit" class="button">Search</button>
			</form:form>




		</a> <a href="userNotification">Notifications</a> <a href="#home"></a> <a
			href="#news">Search Trainings </a> <a href="#contact">Current
			Trainings</a> <a href="#about">Completed Trainings</a> <a href="#"><h5
				class="pull-left login-person-head">
				Welcome
				<%=session.getAttribute("name")%>
			</h5></a> <a href="logout"><button class="btn-primary">Logout</button></a> <a
			href="javascript:void(0);" class="icon" onclick="myFunction()"> <i
			class="fa fa-bars"></i>
		</a>
	</div>

	<div id="content"></div>

</body>
</html>

