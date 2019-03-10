<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

    <title>Community</title>

    <!-- Bootstrap core CSS -->
    <style><%@include file="/css/min.css"%></style> 
    
     <!-- Custom styles for this template -->
     <style><%@include file="/css/offcanvas.css"%></style> 
     
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
          <li class="active"><a href="home">Home</a></li>
          <li ><a href="index">About</a></li>
          <li ><a href="account">Account</a></li>
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
  <div class="container">

      <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-12 col-sm-9">
          <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
          </p>
          <div class="jumbotron">
            <h2>Hello, ${empDto.firstName} !</h2>
            <p>Welcome to Community. Here you can engage, and share your view with other community members. </p>
          </div>
           
          
          
          
          
          <core:if test="${switchNav  == 1}">
	
		<ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="showPosts">Post</a></li>
            <li role="presentation"><a href="showProfile">Profile</a></li>
            <li role="presentation"><a href="showMessages">Messages</a></li>
          </ul>
          <br>
          <br>
          <core:set var="j" value="${fn:length(postsList)}" />
           <core:forEach var = "i" begin = "1" end = "${postsList.size()}">
          <div class="col-sm-8">
          <div class="row">
                <div class="panel panel-${postsList.get(j-i).getPostColor()}">
                  <div class="panel-heading">
                    <h3 class="panel-title">@${postsList.get(j-i).getPostEmp().getLoginId()} </h3>
                  </div>
                  <div class="panel-body">
                    ${postsList.get(j-i).getPostContents()}
                    <p></p>
                    <p>	${postsList.get(j-i).getAuthorName()}, ${postsList.get(j-i).getPostEmp().getCompany().getName()}</p>
                  </div>
                </div>
                    </div></div>
                    
          </core:forEach>
       </core:if>
       
       <core:if test="${switchNav  == 2}">
	
		<ul class="nav nav-tabs" role="tablist">
            <li role="presentation" ><a href="showPosts">Post</a></li>
            <li role="presentation"class="active"><a href="showProfile">Profile</a></li>
            <li role="presentation"><a href="showMessages">Messages</a></li>
          </ul>
          <br>
          <br>
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

   
       </core:if>
       
        <core:if test="${switchNav  == 3}">
	
		<ul class="nav nav-tabs" role="tablist">
            <li role="presentation" ><a href="showPosts">Post</a></li>
            <li role="presentation"><a href="showProfile">Profile</a></li>
            <li role="presentation"class="active"><a href="showMessages">Messages</a></li>
          </ul>
          <br>
          <br>
          <p>Working on this.</p>
         
       </core:if>
       
       
	</div>
        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
            
           
          <div class="list-group">
    
            <a href="home" class="list-group-item active">Latest Posts (${postsList.size()})</a>
            <core:set var="a" value="${fn:length(postsList)}" />
            <a href="#" class="list-group-item"> @<core:out value = "${postsList.get(a-1).getPostEmp().getLoginId()}"/></a>
            <a href="#" class="list-group-item">@<core:out value = "${postsList.get(a-2).getPostEmp().getLoginId()}"/></a>
            <a href="#" class="list-group-item">@<core:out value = "${postsList.get(a-3).getPostEmp().getLoginId()}"/></a>
            <a href="#" class="list-group-item">@<core:out value = "${postsList.get(a-4).getPostEmp().getLoginId()}"/></a>
            <a href="#" class="list-group-item">@<core:out value = "${postsList.get(a-5).getPostEmp().getLoginId()}"/></a>
        
          </div>
          <br>
          <br>
        
          <form action="savePost" method="POST">
              <div class="form-group">
             <label for="db">@${empDto.loginId}</label>
                   <textarea class="form-control rounded-0 " name="postContents" placeholder="Hey ${empDto.firstName} ! Tell us what you did today."
                       required></textarea>
           </div>
           <div class="form-group">
              <label for="postColor"> Color :</label> 
              <input type="radio" name="postColor" value="success"required> <label for="postColor">Green</label> 
               <input type="radio" name="postColor" value="info"> <label for="postColor">Blue</label>
               <input type="radio" name="postColor" value="default"> <label for="postColor">Grey</label> 
               <input type="radio" name="postColor" value="danger"> <label for="postColor">Red</label> 
						</div>
           <div class="form-group">
           <button class="btn btn-primary" >Post</button>
           </div>
           </form>
           <br>
          <br>
          <div class="sidebar-module sidebar-module-inset">
              <h4>About</h4>
              <p>Keep community clean. </p>
            </div>
            <br>
            <br>
        </div><!--/.sidebar-offcanvas-->
      </div><!--/row-->

      <hr>

      <footer>
        <p></p>
      </footer>

    </div><!--/.container-->


</div><!--/.container-->


     
    </html>
