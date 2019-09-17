<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@page
	import="com.MentorOnDemand.model.Skills"%><%@ taglib
	uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Style/Register.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container contact-form">
		<div class="contact-image">
			<img src="https://image.ibb.co/kUagtU/rocket_contact.png"
				alt="rocket_contact" />
		</div>

		<form:form action="skillUpdate" modelAttribute="skill" method="put">
			<h3>Add Skill</h3>
			<%Skills skill = (Skills) request.getAttribute("skillList"); %>
			<div class="row">
				<div class="col-md-6">

					<div class="form-group">
						<form:input type="text" name="txtName" class="form-control"
							placeholder="Enter Skill Name *" path="skillName"
							value="<%=skill.getSkillName() %>" readonly="true" />
					</div>
					<div class="form-group">
						<form:input type="text" name="txtEmail" class="form-control"
							placeholder="Enter Base Amount*" path="baseAmount"
							value="<%=skill.getBaseAmount() %>" />
					</div>
					<div class="form-group">
						<input type="submit" name="btnSubmit" class="btnContact"
							value="update" />
					</div>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>