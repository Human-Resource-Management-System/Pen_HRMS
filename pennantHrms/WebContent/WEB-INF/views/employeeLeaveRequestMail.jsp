<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leave Request Details</title>
<!-- Add Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body style="background-color: #f4f4f4;">
	<div class="container"
		style="background-color: #fff; padding: 20px; border-radius: 5px;">
		<h1 style="color: #007bff; text-align: center;">Leave Request
			Details</h1>
		<table class="table table-bordered">

			<tbody>
				<tr>
					<th>Employee ID</th>
					<td>${leaverequest.employeeId}</td>
				</tr>
				<tr>
					<th>Employee Name</th>
					<td>${leaverequest.name}</td>
				</tr>
				<tr>
					<th>Leave Start Date</th>
					<td>${leaverequest.leaveStartDate}</td>
				</tr>
				<tr>
					<th>Leave End Date</th>
					<td>${leaverequest.leaveEndDate}</td>
				</tr>
				<tr>
					<th>Leave Type</th>
					<td>${leaverequest.leaveType}</td>
				</tr>
				<tr>
					<th>Reason</th>
					<td>${leaverequest.reason}</td>
				</tr>
			</tbody>


		</table>
	</div>
	<!-- Add Bootstrap JS (optional) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>