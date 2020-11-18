<jsp:include page="views/header.jsp"></jsp:include>
<div class="container">
	<div class="row">
		<div class="col-sm-6 offset-sm-3">
			<h3>Upload avatar</h3>
			
			<form class="mt-3" action="avatarUpload" method="post" enctype="multipart/form-data">
			
				<div class="form-group">
				    <label for="exampleFormControlFile1">Please select an image to upload</label>
				    <input type="file" name="avatar" class="form-control-file" id="exampleFormControlFile1">
				    <button type="submit" class="btn btn-primary mt-4">Submit</button>
			  	</div>
			
			</form>
			
		</div>
	</div>
</div>
			

<jsp:include page="views/footer.jsp"></jsp:include>