<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Students</title>
</head>
<body>
<section>
<div class="jumbotron">
<div class="container">
<h1>Students</h1>

</div>
</div>
</section>
<section class="container">
<div class="row">
<div class="col-sm-6 col-md-3">
<c:forEach items="${students}" var="student">
					<tr>
						<td>ID: ${student.id}</br></td>
						<td>Name: ${student.name}</br></td>
						<td>Email: ${student.email}</br></td>
						<td>Address: ${student.address}</br></td>
						<td>Roll No: ${student.mobile}</br></td>
						
					</tr>
				</c:forEach>

</div>
</div>

</section>
</body>
</html>