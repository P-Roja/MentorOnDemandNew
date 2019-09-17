<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@page import="java.util.*"%>
<%@page import="com.MentorOnDemand.model.*"%><%@ taglib
	uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style/StockStyle.css">
<link rel="stylesheet" type="text/css" href="Style/style.css">
<script src="Script/script.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="topnav" id="myTopnav">

		<a href="#"> <form:form class="form-inline" action="searchMentor"
				modelAttribute="mentor">

				<label for="email2" class="mb-2 mr-sm-2">Skills</label>


				<form:select class="form-control mb-2 mr-sm-2" id="email2"
					path="skills">
					<%
						ArrayList skillDetails = (ArrayList) request.getAttribute("skillsList");
								Iterator itr = skillDetails.iterator();
								String skillSet = null;
					%>
					<option class="hidden" value="" selected disabled>Choose
						Skill</option>
					<%
						while (itr.hasNext()) {
									Skills skill = (Skills) itr.next();
									skillSet = skill.getSkillName();
					%>
					<option value="<%=skillSet%>"><%=skillSet%></option>
					<%
						}
					%>


				</form:select>
				<button type="submit" class="button">Search</button>
			</form:form>




		</a> <a href="#home">Notifications</a> <a href="#news">Search
			Trainings </a> <a href="#contact">Current Trainings</a> <a href="#about">Completed
			Trainings</a> <a href="logout"><button class="btn-primary">Logout</button></a>
		<a href="javascript:void(0);" class="icon" onclick="myFunction()">
			<i class="fa fa-bars"></i>
		</a>
	</div>

	<div id="content">

		<h4 align="center">Mentor Search Result</h4>
		<br>

		<%
			List mentorList = (List) request.getAttribute("mentorList");
			List proposeList = (List) request.getAttribute("proposeList");

			long orgId = (Long) session.getAttribute("name");
		%>

		<table class="table table-bordered" align="center">

			<tbody>
				<tr>
					<th class="text-center">Image</th>
					<th>User Id</th>
					<th>Mentor Id</th>
					<th>Trainer Name</th>
					<th>No.of Trainings completed</th>
					<th>Propose</th>
				</tr>

				<%
					for (int i = 0; i < mentorList.size(); i++) {

						Mentor mentor = (Mentor) mentorList.get(i);
				%>
				<tr>
					<td></td>
					<td><%=orgId%>
					<td><%=mentor.getMentorId()%>
					<td><%=mentor.getUserName()%></td>
					<td><%=mentor.getTrainingCompleted()%></td>

					<%
						if (proposeList.size() == 0) {
					%>
					<td><a
						href="proposeTraining?id=<%=mentor.getMentorId()%>&userId=<%=orgId%>"
						class="btn btn-info btn-lg">Propose training</a></td>
					<%
						} else {
								for (int j = 0; j < proposeList.size(); j++) {

									ProposalRequest pr = (ProposalRequest) proposeList.get(j);
									if (pr.getUserId() == orgId) {

										if (pr.getStatus().equalsIgnoreCase("approved")) {
					%>
					<td><a href="#" class="btn btn-info btn-lg">Approved</a></td>
					<%
						}

										else if (pr.getStatus().equalsIgnoreCase("pending")) {
					%>

					<td><a href="#" class="btn btn-info btn-lg">Pending</a></td>
					<%
						}
									}
								}
							}
					%>


					<!-- <td><button type="submit" class="btn btn-primary">Propose Training</button></td> -->

				</tr>
				<%
					}
				%>
			</tbody>
		</table>

	</div>

</body>
</html>