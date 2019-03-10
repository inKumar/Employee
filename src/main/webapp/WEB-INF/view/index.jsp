<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
	</core:if> : About</title>

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
			</core:if></a>
      </div>
      <div id="navbar" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
        <li><a href="home">Home</a></li>
          <li class="active"><a href="index">About</a></li>
         <li><a href=account>Account</a></li>
          <li><a href="profile">Profile</a></li>
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
      
      <core:if test="${empDto.company.name != null}">
			<h2>${empDto.company.name}</h2>
			</core:if>
    </div>
    
    <core:set var = "cname" scope = "session" value = "${empDto.company.name}" />

      <core:if test = "${fn:contains(cname, 'Lyft')}">
         <p class="lead"><code>${empDto.company.name}</code> : <code>Lyft is an on-demand transportation company primarily providing ride-hailing services and based in San Francisco, California. It develops, markets, and operates the Lyft car transportation mobile app.</code></p>
      </core:if>
      <core:if test = "${fn:contains(cname, 'Spotify')}">
       <p class="lead"><code>${empDto.company.name}</code> : <code>Spotify is an audio streaming platform launched by Spotify AB on 7 October 2008. It provides DRM-protected music and podcasts from record labels and media companies.</code></p>
   
      </core:if>
      <core:if test = "${fn:contains(cname, 'Netflix')}">
        <p class="lead"><code>${empDto.company.name}</code> : <code>Netflix, Inc. is an American media-services provider headquartered in Los Gatos, California, founded in 1997 by Reed Hastings and Marc Randolph in Scotts Valley, California.</code></p>
   
      </core:if>
    <p></p>
    <p>Functionlity Overview</p>
    <p></p>
    <p class="lead"><code>1</code> . <code>Different types of roles availble.</code></p>
    <p class="lead"><code>2</code> . <code>Employee can modify their own data.</code></p>
    <p class="lead"><code>3</code> . <code>Admin can add new employee & modify existing employee.</code></p>
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

