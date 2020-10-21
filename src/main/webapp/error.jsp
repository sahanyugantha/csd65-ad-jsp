<jsp:include page="views/header.jsp"></jsp:include>

<%
	if(session.getAttribute("error") != null){
	%>				
		<div class='alert alert-danger' role='alert'>
		 	<% out.print(session.getAttribute("error").toString()); %>
		</div>
	<% 
	}
%>

<jsp:include page="views/footer.jsp"></jsp:include>