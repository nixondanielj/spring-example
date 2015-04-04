<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dogs</title>
</head>
<body>
	<a href="/springapp/dogs">Back to List</a>
	<form:form action="/springapp/dogs/add" method="POST" modelAttribute="dog">
		Name: <form:input path="name" type="text"></form:input>
		<br>
		Age: <form:input path="age"></form:input>
		<br>
		<form:select path="breed">
			<form:options items="${ breeds }" />
		</form:select>
		<br>
		<input type="submit" value="Add Dog">
	</form:form>
</body>
</html>