<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title><core:if test="${empDto.firstName != null}">
		${empDto.firstName}</core:if>&nbsp;
		<core:if test="${empDto.lastName != null}">
		${empDto.lastName}</core:if> : Update profile</title>

 <!-- Bootstrap core CSS -->
    
    <style><%@include file="/css/min.css"%></style> 
    

    <!-- Custom styles for this template -->
    
    <style><%@include file="/css/main-page.css"%></style>


</head>

<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<core:if test="${empDto.company.name != null}">
			<a class="navbar-brand" href="index">${empDto.company.name}</a>
			</core:if></a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="home">Home</a></li>
				<li><a href="index">About</a></li>
				<li><a href="account">Account</a></li>
				<li class="active"><a href="profile">Profile</a></li>
			</ul>
			</ul>
        <core:if test="${empDto.id != null}">
			 <ul class=" nav navbar-nav navbar-right" >
          <li ><a href="logout">Logout </a></li>
        </ul>
			</core:if>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>

<!-- Begin page content -->
<div class="container">
	<div class="page-header">
		<h3>Update Profile</h3>
	</div>
	<p class="lead">
		<code>Update Profile</code>
		:
		<code> Change Your Account Data</code>
	</p>
	<p></p>
	<p></p>
	
	 <core:if test="${error != null}">
		<div class="alert alert-danger" role="alert">${error}</div>
	</core:if>
	<p></p>
	<div class="container">
		<div class="col-md-4 ">

		<p class="lead"><code>Basic Information</code>  </p>
			<form action="updateEmp" method="post">
				<div class="form-group">
					<label for="fn"> First Name</label> <input class="form-control"
						type="text" name="firstName" text" value="${emp.firstName}">
				</div>

				<div class="form-group">
					<label for="ln"> Last Name</label> <input class="form-control"
						type="text" name="lastName" text" value="${emp.lastName}">
				</div>


				
				<div class="form-group">
					<label for="username"> User Id</label> <input class="form-control"
						name="loginId" type="text" value="${emp.loginId}">
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input class="form-control"
						name="password" type="text" value="${emp.password}">
				</div>
				 <p class="lead"><code>Address</code>  </p>
                <div class="form-group">
                <label for="addressDto.street">Street</label> <input
                    class="form-control" name="addressDto.street"  type="text" value="${emp.addressDto.street}">
                </div>
                <div class="form-group">
                <label for="addressDto.city">City</label> 
                <input class="form-control" name="addressDto.city"  type="text" value="${emp.addressDto.city}">
                </div>
                <div class="form-group">
                  <label for="addressDto.state">State</label> <input
                      class="form-control" name="addressDto.state"  type="text" value="${emp.addressDto.state}">
                  </div>
                  <div class="form-group">
                  <label for="addressDto.pincode">Pincode</label> 
                  <input class="form-control" name="addressDto.pincode"  type="text" value="${emp.addressDto.pincode}">
                  </div>


				<div class="form-group">
					<button class="btn btn-primary">Update Details</button>
			</form>
		</div>
	</div>
</div>
</div>
<footer class="footer">
    <div class="container">
    <core:if test="${empDto.company.name != null}">
			<p class="text-muted">${empDto.company.name}&nbsp;Inc,&nbsp;${empDto.company.address.street},&nbsp;
			${empDto.company.address.city},&nbsp;${empDto.company.address.state},&nbsp;${empDto.company.address.pincode}
			 </p>
			</core:if>
    </div>
  </footer>
</html>
