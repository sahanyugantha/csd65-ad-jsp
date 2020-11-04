<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CSD 65</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/style.css">

	 
	      		 <%
					String themeCookie = "Light";
					Cookie[] cookies = request.getCookies();
					
					for(int i=0; i < cookies.length; i++ ){
						
						if(cookies[i].getName().equals("theme")){
							themeCookie = cookies[i].getValue();
						}
						
					}
					

					System.out.println("Cookie-theme ----> "+themeCookie);
					
					if (themeCookie.equals("Dark")){
						%>
							<style>
								body {
									background-color : #868686;
								}
							</style>
						<% 
					}
				%>


</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">CSD65</a>
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
	      					
	      		<div class="d-flex" style="position: absolute;right: 20px;">
				  <div class="btn-group">
				    <button type="button" class="btn btn-secondary"><% out.print(session.getAttribute("u_username").toString()); %></button>
				    <button type="button" class="btn btn-secondary dropdown-toggle dropdown-toggle-split" id="dropdownMenuReference" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" data-reference="parent">
				      <span class="sr-only"></span>
				    </button>
				    <div class="dropdown-menu" aria-labelledby="dropdownMenuReference">
				      <a class="dropdown-item" href="edituser.jsp">Edit profile</a>
				      <a class="dropdown-item" href="settings.jsp">Settings</a>
				      <div class="dropdown-divider"></div>
				      <a class="dropdown-item" href="logout.jsp">Logout</a>
				    </div>
				  </div>
				</div>
				
			<% } else { %>
				<li class="nav-item" style="position: absolute;right: 80px;">
		        	<a class="nav-link" href="register.jsp">Signup</a>
	      		</li>
	      		<li class="nav-item" style="position: absolute;right: 20px;">
		        	<a class="nav-link" href="login.jsp">Login</a>
	      		</li>
      		<% } %>
     </ul>
     
  </div>
</nav>
