<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 
<!DOCTYPE html>
<html>
<head>
	<title>Page Title</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<style>
		.edit-btn {
			background: url('https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Edit_icon_%28the_Noun_Project_30184%29.svg/1024px-Edit_icon_%28the_Noun_Project_30184%29.svg.png');
			height: 20px;
			width: 20px;
			background-size: cover;
			background-repeat: no-repeat;
    			background-position: center;
			margin: auto;
		}
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
		<div class="row my-5">
			<div class="col-md-4"></div>
			<form action="uploadEmployee" method="post" class="mr-2">
		<input type='button' class='form-control btn-link btn-outline-info text-info mx-2' data-toggle='modal' data-target='#exampleModal' value='Upload Employee Details' />
			
			</form>
			<form action="downloadEmployee" method="post">
			<input type="submit" class="form-control btn-link btn-outline-info text-info mx-2" value="Download Employee Details">
			
			<!-- <button class="btn btn-info col-md-3 py-2">Download Employee Details</button>
			 -->
			</form>
		</div>
		<table class="table text-sm-center text-info">
			<thead>
				<tr>
					<th>Employee Code</th>
					<th>Employee Name</th>
					<th>Location</th>
					<th>Email</th>
					<th>Date of Birth</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				
					<c:forEach var="employeedetail" items="${employeeresult}">
						<tr>
							<td>${employeedetail.employeecode}</td>
							<td>${employeedetail.employeename}</td>
							<td>${employeedetail.location}</td>
							<td>${employeedetail.email}</td>
							<td>${employeedetail.dateofbirth}</td>
							<td>
							
						<form:form  action="employeedetails" method="post"> 
						
					<input type="submit" class="edit-btn"  value="" onclick="updateClicked(${employeedetail.employeecode})"></form:form>
					</td>
							
						</tr>
					</c:forEach>
				</tbody>
		</table>
	</div>
	<script type="text/javascript">
	
		function updateClicked(id) 
		
		{
			
			document.cookie = "empid=" + id;
		
		}
		
	</script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
      
      <div class="modal" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">Update</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <form class="form-group" method="post" action="uploadEmployee" enctype="multipart/form-data">
                  <input class="form-control" type="file" class="file" placeholder="Upload file" name="file">
                  <input class="btn btn-info py-1 px-3" type="submit" id="upload-btn" value="Upload file"/>
              </form>
            </div>
          </div>
        </div>
      </div>
	
	

</body>
</html>
