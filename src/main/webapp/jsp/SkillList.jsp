
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
<link rel="stylesheet" type="text/css" href="Style/StockStyle.css">
<link rel="stylesheet" type="text/css" href="Style/style.css">
<script src="Script/script.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<div class="topnav" id="myTopnav">

		<a href="addSkill">Add skill</a> <a href="mentorList">View Mentor</a>
		<a href="userList">View User</a> <a href="skillList">EditSkills</a> <a
			href="#"><h5 class="pull-left login-person-head">
				Welcome
				<%=session.getAttribute("name")%>
			</h5></a> <a href="logout"><button class="btn-primary">Logout</button></a> <a
			href="javascript:void(0);" class="icon" onclick="myFunction()"> <i
			class="fa fa-bars"></i>
		</a>
	</div>

	<div id="content">

		<h4 align="center">Skill List</h4>
		<br>

		<%
			List skillList = (List)request.getAttribute("skillList");
		
		%>

		<table class="table table-bordered" align="center">

			<tbody>
				<tr>

					<th>Skill Name</th>
					<th>Base Amount</th>
					<th>update</th>

				</tr>

				<%
					for (int i = 0; i  <skillList.size(); i++) {
					
					
						Skills skill = (Skills)skillList.get(i);
				%>
				<tr>
					<td><%= skill.getSkillName() %>
					<td><%=skill.getBaseAmount() %></td>


					<td><a href="updateSkill?id=<%=skill.getSkillId() %>"
						class="btn btn-info btn-lg">Update</a></td>

				</tr>
				<% }%>
			</tbody>
		</table>

	</div>

</body>
</html>