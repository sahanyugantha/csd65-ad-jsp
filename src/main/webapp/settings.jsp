<jsp:include page="views/header.jsp"></jsp:include>

	<div class="col-sm-6 offset-sm-3">
		<form action="themeChange" method="get">
			<div class="form-group">
		    <label for="themeSelect">Select the theme</label>
		    <select name="theme" class="form-control" id="themeSelect">
		      <option>Light</option>
		      <option>Dark</option>
		    </select>
		  </div>
		   <button name="btn-submit" type="submit" class="btn btn-primary">Save Changes</button>
		</form>
	</div>

<jsp:include page="views/footer.jsp"></jsp:include>