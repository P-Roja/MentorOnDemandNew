<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
					<form:form action="registerUser" method="post"
						modelAttribute="user" class="well form-horizontal">
						<div class="tab-pane fade show active" id="home" role="tabpanel"
							aria-labelledby="home-tab">

							<h3 class="register-heading">Apply as a User</h3>
							<div class="row register-form">
								<div class="col-md-6">

									<div class="form-group">
										<form:input type="text" class="form-control" path="userName"
											placeholder="Name *" value="" />
									</div>
									<div class="form-group">
										<form:input type="email" class="form-control" path="email"
											placeholder="email *" value="" />
									</div>
									<div class="form-group">
										<form:input type="password" class="form-control"
											path="password" placeholder="Password *" value="" />
									</div>

									<%-- 	<div class="form-group">
									<form:input type="password" class="form-control" path=" "
										placeholder="Confirm Password *" value="" />
								</div> --%>

									<div class="form-group">
										<div class="maxl">
											<form:label path="gender">Gender</form:label>
											<label class="radio inline"> <form:radiobutton
													path="gender" value="M" label="Male" />

											</label> <label class="radio inline"> <form:radiobutton
													path="gender" value="F" label="Female" />
											</label>
										</div>
									</div>
								</div>





								<div class="col-md-6">
									<div class="form-group">

										<form:textarea path="address" rows="5" cols="30"
											class="form-control" placeholder="Your Address *" value="" />
									</div>
									<div class="form-group">
										<form:input type="text" minlength="10" maxlength="10"
											path="contactNumber" name="txtEmpPhone" class="form-control"
											placeholder="Your Phone *" value="" />
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
