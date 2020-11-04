
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.csd65.jspapp.config.DbConfiguration"%>
<%@page import="java.sql.Connection"%>
<jsp:include page="views/header.jsp"></jsp:include>

<div class="container">
	<div  class="row">
		<div  class="col-sm-10 offset-sm-1">
		
				
				<%
					String demoCookie = "NA";
					Cookie[] cookies = request.getCookies();
					
					for(int i=0; i < cookies.length; i++ ){
						
						//This is just for testing.
						//out.print("Name : "+cookies[i].getName()+ " value : "+cookies[i].getValue()+"<br/>");
						
						if(cookies[i].getName().equals("sample")){
							demoCookie = cookies[i].getValue();
						}
						
					}
				
				
				%>
				
		
			<% if(session.getAttribute("logged_in") != null &&
					(Boolean)session.getAttribute("logged_in") == true){%>
				
				<div class="alert alert-success" role="alert">
				  Welcome back, <% out.print(session.getAttribute("u_username").toString()); %>
				</div>
			
				<%
					Connection conn = DbConfiguration.getDatabaseConnection();
					String sql = "SELECT * FROM tbl_post ORDER BY `id` desc";
					PreparedStatement stmt = conn.prepareStatement(sql);
					
					ResultSet rs = stmt.executeQuery();
					
					int rows = 0;
					while(rs.next()){
						rows++;
						%>
							<div class="card post-card">
								<div class="card-header">
								    <h5 class="card-title"><% out.print(rs.getString("title")); %></h5>
									<small><% out.print(rs.getString("time")); %></small>
								</div>
								<div class="card-body">
								    <% out.print(rs.getString("body")); %>
								</div>
								<div class="card-footer">
								    <button class="btn btn-primary">Like</button>
								</div>
							</div>
						<%
					}
					
					//if no post available.
					if(rows < 1 ){
					%>
						<div class="alert alert-secondary" role="alert">
						  No posts yet!.
						</div>
					<%
					}
				
				%>
			
				
				
				
			<% } %>
		
		</div>
	</div>
</div>


<jsp:include page="views/footer.jsp"></jsp:include>