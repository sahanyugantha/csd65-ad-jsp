
<jsp:include page="views/header.jsp"></jsp:include>

<div class="container">
	<div  class="row">
		<div  class="col-sm-10 offset-sm-1">
		
			<% if(session.getAttribute("logged_in") != null &&
					(Boolean)session.getAttribute("logged_in") == true){%>
				
				<h1>Welcome back, <% out.print(session.getAttribute("u_username").toString()); %></h1>
			
			<% } %>
		
		</div>
	</div>
</div>


<jsp:include page="views/footer.jsp"></jsp:include>