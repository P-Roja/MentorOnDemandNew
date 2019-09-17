<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@page
	import="java.util.*"%>
<%@page import="com.MentorOnDemand.model.Skills"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="Style/RegisterStyle.css">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container register">
		<div class="row">
			<div class="col-md-3 register-left">
				<img src="https://image.ibb.co/n7oTvU/logo_white.png" alt="" />
				<h3>Welcome</h3>
				<p>Mentor On Demand</p>
				<input type="submit" name="" value="Login" /><br />
			</div>
			<div class="col-md-9 register-right">
				<ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
					<li class="nav-item"><a class="nav-link active" id="home-tab"
						data-toggle="tab" href="#home" role="tab" aria-controls="home"
						aria-selected="true">User</a></li>

				</ul>
				<div class="tab-content" id="myTabContent">
					<form:form action="registerMentor" method="post"
						modelAttribute="mentor" class="well form-horizontal">
						<div class="tab-pane fade show" id="profile" role="tabpanel"
							aria-labelledby="profile-tab">


							<h3 class="register-heading">Apply as a Mentor</h3>
							<div class="row register-form">
								<div class="col-md-6">
									<div class="form-group">
										<form:input type="text" class="form-control"
											placeholder="First Name *" path="userName" value="" />
									</div>
									<div class="form-group">
										<form:input type="email" class="form-control" path="email"
											placeholder="email *" value="" />
									</div>
									<div class="form-group">
										<form:input type="password" class="form-control"
											path="password" placeholder="Password *" value="" />
									</div>
									<div class="form-group">
										<form:input type="text" class="form-control" path="role"
											readonly="true" value="mentor" />
									</div>
									<div class="form-group">
										<form:input type="text" maxlength="10" minlength="10"
											class="form-control" path="contactNumber"
											placeholder="Phone *" value="" />
									</div>
									<div class="form-group">
										<form:input type="text" class="form-control"
											placeholder="Linked In URL *" path="linkedinUrl" value="" />
									</div>

									<div class="form-group">
										<form:input type="text" class="form-control"
											placeholder="Training Completed *" path="trainingCompleted"
											value="" />
									</div>
								</div>
								<div class="col-md-6">

									<div class="form-group">

										<form:textarea path="address" rows="5" cols="30"
											class="form-control" placeholder="Your Address *" value="" />
									</div>

									<div class="form-group">

										<form:select class="form-control" id="email2" path="skills">
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
									</div>
									<div class="form-group">
										<form:input type="text" class="form-control"
											placeholder="Experience *" path="yearOfExperience" value="" />
									</div>
									<div class="form-group">
										<form:select class="form-control" path="slotTime">
											<option class="hidden" selected disabled>Slot Time</option>
											<option>10.00 AM to 12.00 AM</option>
											<option>2.00 PM to 4.00 PM</option>
											<option>4.00 PM to 6.00 PM</option>
										</form:select>
									</div>
									<div class="form-group">
										<form:input type="date" class="form-control" path="fromDate"
											placeholder="Register Date Time" value="" />
									</div>
									<div class="form-group">
										<form:input type="text" class="form-control" path="status"
											readonly="true" value="active" />
									</div>
									<button type="submit" id="registerUser" class="btnRegister"
										name="registerUser">Register</button>
								</div>
							</div>

						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>