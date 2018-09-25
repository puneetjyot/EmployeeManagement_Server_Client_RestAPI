<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 
<!DOCTYPE html>
<html>
<head>
	<title>Page Title</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<style>
	</style>

</head>
<body>

	<div class="bg-info d-flex justify-content-between shadow">
		<h2 class="text-light font-weight-light p-3">Employee Managment</h2>
		
	<div class="d-flex">
		<h3 class="text-light font-weight-light p-3">WELCOME ${username}!</h3>
		<form action="logout" method="post">
		<input type="submit" class="btn btn-outline-light h-50 m-3" value="Logout">
	</form>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4 d-flex justify-content-between">
				<div class="my-5 w-100">
					<form:form action="employeeedit" method="post">
						<div class="form-group">
					    		<label for="empName">Employee Code</label>
					    		<h5>${empcode}</h5>
					       <input name="employeecode" type="hidden" class="form-control" id="employeecode" value=${empcode} required >
					    		
						  </div>
						  <div class="form-group">
						    <label for="empName">Employee Name</label>
						   <input name="employeename" maxlength="100" type="text" class="form-control" id="empName" value=${name} required >
						  </div>
						  <div class="form-group">
						    <label for="location">Location</label>
						    <input name="location" maxlength="500" type="text" class="form-control" id="location" value=${location} required>
						  </div>
						  <div class="form-group">
						    <label for="email">Email</label>
						    <input name="email" type="text" class="form-control" id="email" value=${email}  required>
						  </div>
						  <div class="form-group">
						    <label for="dob">Date of Birth</label>
						    <input name="dateofbirth" type="date" class="form-control" id="dob" value=${dob}  required>
						  </div> 
						  <input type="submit" value="Save" class="btn btn-info"/>
						  <input type="reset" value="Clear" class="btn btn-danger"/>
					</form:form>
				</div>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>

</body>
</html>
