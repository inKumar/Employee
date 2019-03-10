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
	</core:if> : Account</title>

    <!-- Bootstrap core CSS -->
    
    <style><%@include file="/css/min.css"%></style> 
    

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
			</core:if>
      </div>
      <div id="navbar" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
        <li><a href="home">Home</a></li>
          <li ><a href="index">About</a></li>
          <li class="active"><a href=account>Account</a></li>
          <li ><a href="profile">Profile</a></li>
          
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
      <h3>Hello, ${empDto.firstName} ${empDto.lastName}</h3>
    </div>
    
    <core:if test="${postError != null}">
		<div class="alert alert-danger" role="alert">${postError}</div>
	</core:if>
	<core:if test="${postStatus != null}">
		<div class="alert alert-success" role="alert">${postStatus}</div>
	</core:if>
    
    
    <p class="lead"><code>Account</code> : <code>You can view, update & delete your account.</code></p>
    <p></p>
    
    <p></p>
    <p class="lead"><code>1</code> . <a href="userProfile"> <code>View Profile.</code></a></p>
    <p class="lead"><code>2</code> . <a href="udateProfile"> <code>Update Profile</code></a></p>
    <p class="lead"><code>3</code> . <a href="deleteAccount"> <code>Delete Account</code></a></p>
    <p class="lead"><code>4</code> . <a href="logout"> <code>Logout</code></a></p>


<div class="col-md-6">
      <br> 
      <p class="lead"><code>Post Something</code>
    <form action="savePost" method="POST">
       <div class="form-group">
			<label for="db">@${empDto.loginId}</label>
            <textarea class="form-control rounded-0 " name="postContents" placeholder="Hey ${empDto.firstName} ! Tell us what you did today."
              	required></textarea>
		</div>
		<div class="form-group">
              <label for="postColor"> Color :</label> 
              <input type="radio" name="postColor" value="success"> <label for="postColor">Green</label> 
                <input type="radio" name="postColor" value="info"> <label for="postColor">Blue</label>
               <input type="radio" name="postColor" value="default"> <label for="postColor">Grey</label> 
               <input type="radio" name="postColor" value="danger"> <label for="postColor">Red</label> 
						</div>
		<div class="form-group">
		<button class="btn btn-primary" >Post</button>
		</form>
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
