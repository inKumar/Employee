<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

     <title><core:if test="${empDto.company.name != null}">
		${empDto.company.name}
	</core:if>:<core:if test="${empDto.firstName != null}">
		${empDto.firstName}
	</core:if>&nbsp;<core:if test="${empDto.lastName != null}">
		${empDto.lastName}
	</core:if>
	  </title>

    <!-- Bootstrap core CSS -->
    <style><%@include file="/css/min.css"%></style> 
    
     <!-- Custom styles for this template -->
     <style><%@include file="/css/grid.css"%></style> 
     
    <!-- Custom styles for this template -->
    <style><%@include file="/css/main-page.css"%></style> 
   
    
  </head>

   <!-- Fixed navbar -->
   <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
       <core:if test="${empDto.company.name != null}">
			<a class="navbar-brand" href="index">${empDto.company.name}</a>
			</core:if></a>
      </div>
      <div id="navbar" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
        <li><a href="home">Home</a></li>
          <li ><a href="index">About</a></li>
          <li ><a href="account">Account</a></li>
          <li class="active"><a href="profile">Profile</a></li>
        </ul>
        </ul>
        <core:if test="${empDto.id != null}">
			 <ul class=" nav navbar-nav navbar-right" >
          <li ><a href="logout">Logout </a></li>
        </ul>
			</core:if>
      </div><!--/.nav-collapse -->
    </div>
  </nav>

   <!-- Begin page content -->
  <div class="container">
    <div class="page-header">
      <h3>Profile</h3>
    </div>
    <p class="lead"><code>Profile</code> : <code> Your Account Data</code></p>
    <p></p>
    
    <core:if test="${updateStatusMsg != null}">
		<div class="alert alert-success" role="alert">${updateStatusMsg}</div>
	</core:if>
    <p></p>
    <p>Basic information</p>
    <p></p>
     <div class="row">
        <div class="col-md-4">First name</div>
        <div class="col-md-4">${empDto.firstName}</div>
      </div>
      <div class="row">
          <div class="col-md-4">Last name</div>
          <div class="col-md-4">${empDto.lastName}</div>
        </div>
       <div class="row">
            <div class="col-md-4">User Id</div>
            <div class="col-md-4">${empDto.loginId}</div>
          </div>
          <br>
     <p></p>
    <p>Address</p>
    <p></p>
      <div class="row">
        <div class="col-md-4">City</div>
        <div class="col-md-4">${empDto.addressDto.city}</div>
      </div>
      <div class="row">
          <div class="col-md-4">Street</div>
          <div class="col-md-4">${empDto.addressDto.street}</div>
        </div>
        <div class="row">
            <div class="col-md-4">Pincode</div>
            <div class="col-md-4">${empDto.addressDto.pincode}</div>
          </div>
          <p></p>
          <p class="lead"><code>^</code> . <a href="udateProfile"> <code>Update Profile</code></a></p>
          <p></p>

   
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
