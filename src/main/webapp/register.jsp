<jsp:include page="views/header.jsp"></jsp:include>


<div class="container">
	<div class="row">
		<div class="col-sm-8 offset-sm-2">
			<form action="signup" method="post">
			  <div class="form-group">
			    <label for="u-email">Email address</label>
			    <input name="u-email" type="email" class="form-control" id="u-email" aria-describedby="emailHelp">
			  </div>
			  <div class="form-group">
			    <label for="u-pass">Password</label>
			    <input name="u-pass" type="password" class="form-control" id="u-pass">
			  </div>
			   <div class="form-group">
			    <label for="u-username">Username</label>
			    <input name="u-username" type="text" class="form-control" id="u-username">
			  </div>
			   <div class="form-group">
			    <label for="u-role">Select the user role</label>
			    <select name="u-role" class="form-control" id="u-role">
			      <option>STANDARD</option>
			      <option>LOYALITY</option>
			      <option>MANAGER</option>
			      <option>ADMIN</option>
			    </select>
			  </div>
			  <button name="btn-submit" type="submit" class="btn btn-primary">Sign up</button>
			</form>
		</div>
	</div>
</div>

<jsp:include page="views/footer.jsp"></jsp:include>