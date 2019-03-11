<%@page contentType="text/html" pageEncoding="UTF-8"%>

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

    <title>Login : Employee Project</title>

    <!-- Bootstrap core CSS -->
	<style><%@include file="/css/min.css"%></style>
    
    <!-- IE10 viewport hack for Surface/desk	top Windows 8 bug -->
    <link href="ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->

    <style><%@include file="/css/login.css"%></style>
	
  </head>

  
  <body>

    <div class="container">

      <form class="form-signin"action="loginEmp"  method="post">
          <h3 class="form-signin-heading">Employee Management</h3>
          <p></p>
          <p></p>
           <p></p>
          <p></p>	
        <h3 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">User Id</label>
        <input type="text" id="loginId"name="loginId" class="form-control" placeholder="Login Id" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
