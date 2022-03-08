<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>KANBAN TOOL</title>
</head>
<body>
<h1>Add Project Here</h1>
<br>
<form action="./projects/processForm.ds" method="post">
	<table>
	<tr>
		<td>Project Name</td>
		<td><input type="text" name="projectName" /></td>
	</tr>
	
	<tr>
		<td>Project Identifier</td>
		<td><input type="text" name="projectIdentifier" /></td>
	</tr>
	
	<tr>
		<td>Description</td>
		<td><textarea rows="4" cols="50" name="description"></textarea></td>
	</tr>
	
	<tr>
		<td>Project Name</td>
		<td colspan="2" align="right"><input type="submit" value="Add Project" /></td>
	</tr>

	</table> 

</form>

</body>
</html>