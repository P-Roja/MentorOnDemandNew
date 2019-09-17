
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page
	import="java.util.*"%>
<%@page import="com.MentorOnDemand.model.User"%>

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

		<h4 align="center">USer List</h4>
		<br>

		<%
			List userList = (List) request.getAttribute("userList");
		
		%>

		<table class="table table-bordered" align="center">

			<tbody>
				<tr>

					<th>User Id</th>
					<th>User Name</th>
					<th>Contact</th>
					<th>Email</th>
					<th>Block</th>
					<th>Unblock</th>
				</tr>

				<%
					for (int i = 0; i  <userList.size(); i++) {
					
					
						User user = (User)userList.get(i);
				%>
				<tr>
					<td></td>
					<td><%= user.getUserId() %>
					<td><%=user.getUserName() %>
					<td><%=  user.getPassword() %></td>
					<td><%= user.getEmail() %></td>

					<%  if(user.getAccess()==0)
					{
%>
					<td><a href="block?userId=<%=user.getUserId() %>"
						class="btn btn-info btn-lg">block</a></td>

					<td><a href="unblock?userId=<%=user.getUserId() %>"
						class="btn btn-info btn-lg">unblock</a></td>
					<%
						
					}
					else  if(user.getAccess()==1)
					{
%>
					<td><a href="block?userId=<%=user.getUserId() %>"
						class="btn btn-info btn-lg" id="isDisabled">block</a></td>

					<td><a href="unblock?userId=<%=user.getUserId() %>"
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