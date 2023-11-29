<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
div {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}
</style>
<meta charset="ISO-8859-1">
<title>To-do Home</title>
</head>
<body>
	<div>
		<h1>To-do Home</h1>
		<table border="1px solid black">
			<tr>
				<th>Task Name</th>
				<th>Task Description</th>
				<th>Date Created</th>
				<th>Status</th>
				<th>Delete</th>
				<th>Edit</th>
			</tr>
			<tr>
				<td>Swimming</td>
				<td>Water</td>
				<td>12-nov-2023</td>
				<td>Complete</td>
				<td><button>Delete</button></td>
				<td><button>Edit</button></td>
			</tr>
		</table>
		<br>
		<a href="session-add-task"><button>Add Task</button></a><br>
		<a href="logout"><button>Logout</button></a>
	</div>
</body>
</html>