<jsp:include page="views/header.jsp"></jsp:include>


<div class="container">
	<div class="row">
		<div class="col-sm-8 offset-sm-2">
			<form action="auth" method="post">
			  <div class="form-group">
			    <label for="exampleInputEmail1">Email address</label>
			    <input name="u-email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Password</label>
			    <input name="u-pass" type="password" class="form-control" id="exampleInputPassword1">
			  </div>
			  <button name="btn-submit" type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>
</div>

<jsp:include page="views/footer.jsp"></jsp:include>