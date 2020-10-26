<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CSD 65</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      	<% 	
      		if(session.getAttribute("logged_in") != null &&	(Boolean)session.getAttribute("logged_in") == true){ %>
				
			 	<li class="nav-item" style="position: absolute;right: 20px;">
		        	<a class="nav-link" href="logout.jsp">Logout</a>
	      		</li>
	      		
	      		<li class="nav-item" style="position: absolute;right: 100px;">
		        	<a class="nav-link" href="#"><% out.print(session.getAttribute("u_username").toString()); %></a>
	      		</li>
			
			<% } else { %>
				<li class="nav-item" style="position: absolute;right: 20px;">
		        	<a class="nav-link" href="login.jsp">Login</a>
	      		</li>
      		<% } %>
     </ul>
     
  </div>
</nav>
