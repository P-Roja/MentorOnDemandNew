<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@page
	import="java.util.*"%>
<%@page import="com.MentorOnDemand.model.Skills"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style/StockStyle.css">
<link rel="stylesheet" type="text/css" href="Style/Register.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
#content {
	background-color: #66b3ff;
}
</style>
</head>
<body>
	<%
		if (request.getAttribute("blocked") != null) {
	%>

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		swal( "Your account is blocked......")
	</script>

	<%
		}
	%>
	<div class="topnav" id="myTopnav">
		<form:form class="form-inline" action="searchAdminMentor"
			modelAttribute="mentor">

			<label for="email2" class="mb-2 mr-sm-2" style="text-color: white">Skills</label>

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

			<label for="email2" class="mb-2 mr-sm-2">Slot Time</label>


			<form:select class="form-control mb-2 mr-sm-2" id="email2"
				path="slotTime">
				<option class="hidden" selected disabled>Slot Time</option>
				<option>10.00 AM to 12.00 AM</option>
				<option>2.00 PM to 4.00 PM</option>
				<option>4.00 PM to 6.00 PM</option>
			</form:select>
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form:form>
	</div>

	<div id="content">

		<div class="wrapper">
			<h1>Mentor On Demand</h1>
			<div id="formContent">
				<!-- Tabs Titles -->
				<h2 class="active">Sign In</h2>


				<!-- Icon -->
				<div class="fadeIn first">
					<img src="Images/download.png" id="icon" alt="User Icon" />
				</div>

				<!-- Login Form -->
				<form:form action="loginAdmin" method="post" modelAttribute="login"
					class="well form-horizontal">
					<form:input id="login" class="fadeIn second" name="login" value=" "
						placeholder="User Name" type="text" path="email"
						required="required" />
					<form:input id="password" class="fadeIn sthird" name="password"
						value=" " placeholder="Password" type="password" path="password"
						required="required" />
					<input type="submit" name="loginAdmin" id="loginAdmin"
						class="fadeIn fourth" value="Log In">
				</form:form>

				<!-- Remind Passowrd -->
				<div id="formFooter">
					<a class="underlineHover" href="registerUser">Don't Have an
						Account..Register as User Here</a> <a class="underlineHover"
						href="registerMentor">Don't Have an Account..Register as
						Mentor Here</a>

				</div>
			</div>
		</div>
	</div>
</body>
</html>