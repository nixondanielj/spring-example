<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dogs</title>
</head>
<body>
	<c:choose>
		<c:when test="${ not empty message }">
			<h1>${ message }</h1>
		</c:when>
		<c:otherwise>
			<h1>Dogs</h1>
			<form action="/springapp/dogs">
				Search: <input type="text" name="search">
			</form>
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Age</th>
						<th>Breed</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dog" items="${ dogs }">
						<tr>
							<td>${ dog.id }</td>
							<td>${ dog.name }</td>
							<td>${ dog.age }</td>
							<td>${ dog.breed }</td>
							<td>
								<a href="/springapp/dogs/edit/${ dog.id }">Edit</a>
							</td>
							<td>
								<a href="/springapp/dogs/delete/${ dog.id }">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
	<a href="/springapp/dogs/add">Add Dog</a>
</body>
</html>