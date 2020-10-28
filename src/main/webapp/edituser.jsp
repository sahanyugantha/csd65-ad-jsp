<jsp:include page="views/header.jsp"></jsp:include>


<div class="container">
	<div class="row">
		<div class="col-sm-8 offset-sm-2">
			<h3>Please edit the necessary fields</h3>
			
			<% 
				String email = session.getAttribute("u_email").toString();
				String pass = session.getAttribute("u_pass").toString();
				String username = session.getAttribute("u_username").toString();
				String role = session.getAttribute("u_role").toString().trim().toUpperCase();
			%>
			
			<form action="edituser" method="post">
			  <div class="form-group">
			    <label for="u-email">Email address</label>
			    <input value="<% out.print(email); %>" name="u-email" type="email" class="form-control" id="u-email" aria-describedby="emailHelp">
			  </div>
			  <div class="form-group">
			    <label for="u-pass">Password</label>
			    <input value="<% out.print(pass); %>" name="u-pass" type="password" class="form-control" id="u-pass">
			  </div>
			   <div class="form-group">
			    <label for="u-username">Username</label>
			    <input value="<% out.print(username); %>" name="u-username" type="text" class="form-control" id="u-username">
			  </div>
			  <div class="form-group">
			    <label for="u-role">Select the user role</label>
			    <select name="u-role" class="form-control" id="u-role">
			    	
			      <option <% if(role.equals("STANDARD")){ out.print("selected"); } %>>STANDARD</option>
			      <option <% if(role.equals("LOYALITY")){ out.print("selected");} %>>LOYALITY</option>
			      <option <% if(role.equals("MANAGER")){ out.print("selected") ;} %>>MANAGER</option>
			      <option <% if(role.equals("ADMIN")){ out.print("selected"); } %>>ADMIN</option>
			    </select>
			  </div>
			  <button name="btn-update" type="submit" class="btn btn-primary">Update</button>
			</form>
		</div>
	</div>
</div>

<jsp:include page="views/footer.jsp"></jsp:include>