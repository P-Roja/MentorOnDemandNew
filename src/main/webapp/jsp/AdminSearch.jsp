<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@page import="java.util.*"%>
<%@page import="com.MentorOnDemand.model.*"%><%@ taglib
	uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style/StockStyle.css">

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="topnav" id="myTopnav"></div>
	<div id="content">

		<h4 align="center">Mentor Search Result</h4>
		<br>

		<%
			List mentorList = (List) request.getAttribute("mentorList");
		%>

		<table class="table table-bordered" align="center">

			<tbody>
				<tr>
					<th class="text-center">Image</th>
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
					<td><%=mentor.getUserName()%></td>
					<td><%=mentor.getTrainingCompleted()%>
					<td><button type="submit" class="btn btn-primary">Propose
							Training</button></td>

				</tr>
				<%
					}
				%>
			</tbody>
		</table>

	</div>

</body>
</html>