
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page
	import="java.util.*"%>
<%@page import="com.MentorOnDemand.model.Mentor"%>

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

		<a href="addSkill">Add skill</a> <a href="#contact">View Mentor</a> <a
			href="#about">View User</a> <a href="#home">EditSkills</a> <a
			href="#"><h5 class="pull-left login-person-head">
				Welcome
				<%=session.getAttribute("name")%>
			</h5></a> <a href="logout"><button class="btn-primary">Logout</button></a> <a
			href="javascript:void(0);" class="icon" onclick="myFunction()"> <i
			class="fa fa-bars"></i>
		</a>
	</div>

	<div id="content">

		<h4 align="center">Mentor List</h4>
		<br>

		<%
			List mentorList = (List) request.getAttribute("mentorList");
		
		%>

		<table class="table table-bordered" align="center">

			<tbody>
				<tr>

					<th>Mentor Id</th>
					<th>Mentor Name</th>
					<th>Contact</th>
					<th>Email</th>
					<th>Skill</th>
					<th>Experience</th>
					<th>Block</th>
					<th>Unblock</th>
				</tr>

				<%
					for (int i = 0; i  <mentorList.size(); i++) {
					
					
						Mentor mentor = (Mentor)mentorList.get(i);
				%>
				<tr>
					<td></td>
					<td><%= mentor.getMentorId() %>
					<td><%=mentor.getUserName() %>
					<td><%= mentor.getContactNumber() %></td>
					<td><%= mentor.getEmail() %></td>
					<td><%=mentor.getSkills() %></td>
					<td><%=mentor.getYearOfExperience() %></td>

					<%  if(mentor.getAccess()==0)
					{
%>
					<td><a href="mentorblock?userId=<%=mentor.getMentorId() %>"
						class="btn btn-info btn-lg">block</a></td>

					<td><a href="mentorunblock?userId=<%=mentor.getMentorId() %>"
						class="btn btn-info btn-lg">unblock</a></td>
					<%
						
					}
					else  if(mentor.getAccess()==1)
					{
%>
					<td><a href="mentorblock?userId=<%=mentor.getMentorId() %>"
						class="btn btn-info btn-lg" id="isDisabled">block</a></td>

					<td><a href="mentorunblock?userId=<%=mentor.getMentorId() %>"
						class="btn btn-info btn-lg">unblock</a></td>
					<%
						
					}%>

				</tr>
				<% }%>
			</tbody>
		</table>

	</div>

</body>
</html>