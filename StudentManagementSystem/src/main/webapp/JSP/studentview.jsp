<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

</head>
<body>
	<nav class="d-flex justify-content-between p-2 border border-primary">
		<img src="images/cjclogo.jpg" width="100px" height="50px">
		<div class="pt-2">
			
				<button class="btn btn-outline-primary">Logout</button>
			</a>
		</div>
	</nav>

	<h1 class="text-center">Student Details..!</h1>
	<table class="table table-hover" style="font-size: small">
		<thead>
			<tr>
				<th>ID</th>
				<th>Student Name</th>
				<th>Student Email</th>
				<th>Age</th>
				<th>College Name</th>
				<th>Course Name</th>
				<th>Bath No</th>
				<th>Mode</th>
				<th>Fess Recived</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>

			<tr>
				<td>${stu.studentId}</td>
				<td>${stu.studentFullName}</td>
				<td>${stu.studentEmail}</td>
				<td>${stu.studentAge}</td>
				<td>${stu.studentCollegeName}</td>
				<td>${stu.studentCourse}</td>
				<td>${stu.batchNumber}</td>
				<td>${stu.batchMode}</td>
				<td>${stu.feesPaid}</td>
				<td>
					<div class="btn-group btn-group-sm" role="group" aria-label="...">
						<button class="btn btn-outline-success">PayFees</button>
						<button class="btn btn-outline-primary">ShiftBatch</button>
						<button class="btn btn-outline-danger">Remove</button>

					</div>

				</td>

			</tr>


		</tbody>

	</table>

</body>
</html>