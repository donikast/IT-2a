<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="repositories.Repository" %>
<%@ page import="models.User" %>

<!DOCTYPE html>
<html lang="bg">
<jsp:include page="shared/head.jsp"></jsp:include>
<body>
<jsp:include page="shared/header.jsp"></jsp:include>
	<div class="content">
	<% Repository collection = Repository.getInstance(); %>
	
	<table>
	<tr>
	<th>Име</th>
	<th>Месторабота</th>
	<th>Описание</th>
	</tr>
	<% for(User u:Repository.getCollection()) {%>
	<tr>
	<td><a href="user?id=<%= u.getId() %>"><%= u.getPersonalName() %></a></td>
	<td><%= u.getJobTitle() %></td>
	<td><%= u.getDescription() %></td>	
	</tr>
	<%} %>
	
	</table>
 
	</div>
<jsp:include page="shared/footer.jsp"></jsp:include>

</body>
</html>