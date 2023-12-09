<!DOCTYPE html>
<%@page import="dto.Task"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Task</title>
<style>
div {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}
</style>
</head>
<body>
<div>
<%Task task=(Task)request.getAttribute("task"); %>
		<h1>Edit Task</h1>
		<!-- action is address where the values are carried to  -->
		<form action="update-task" method="post">
			<fieldset>
				<legend>Enter Task here,</legend>
				<input type="hidden" name="id" value="<%=task.getId()%>">
				<table>
					<tr>
						<th>Task Name: </th>
						<!-- Name attribute is Complusory to carry value  -->
						<th><input type="text" value="<%=task.getName()%>" name="tname"></th>
					</tr>
					<tr>
						<th>Task Description: </th>
						<!-- Name attribute is Complusory to carry value  -->
						<th><input type="text" value="<%=task.getDescription()%>" name="tdescription"></th>
					</tr>
					<tr>
						<!-- Clicking this button will carry the values to action Location  -->
						<th><button>Update</button></th>
						<th><button type="reset">Cancel</button></th>
					</tr>
				</table>
			</fieldset>
		</form>
		<br>
		<br>
		<!-- This is for Loading Home Page Servlet -->					
		<a href="home"><button>Back</button></a>
	</div>
</body>
</html>