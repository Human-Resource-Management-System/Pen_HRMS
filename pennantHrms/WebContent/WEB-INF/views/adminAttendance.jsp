<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Attendance Details</title>
<link rel="stylesheet" type="text/css" href="./css/adminAttendance.css">
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script src="./js/adminAttendance.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
  
  
   <div class="empattendance">  

	<div class="attendance-container">
		<h1>Attendance Details</h1>

		<div class="attendance-info">
			<h2>Employee ID:</h2>
			<div class="select-container">
				<input type="text" id="employeeIdInput" class="month-select" placeholder="Enter Employee ID">
			</div>
			
			<div id="msg"></div>
			
			<h2>Year:</h2>
			<div class="select-container">
				<select id="yearSelect" class="month-select">
                  <option value="1">2022</option>
					<option value="2">2023</option>
				</select>
			</div>

			<h2>Month:</h2>
			<div class="select-container">
				<select id="monthSelect" class="month-select">
					<option value="1">January</option>
					<option value="2">February</option>
					<option value="3">March</option>
					<option value="4">April</option>
					<option value="5">May</option>
					<option value="6">June</option>
					<option value="7">July</option>
					<option value="8">August</option>
					<option value="9">September</option>
					<option value="10">October</option>
					<option value="11">November</option>
					<option value="12">December</option>
				</select>
			</div>
			<p class="minimum-hours">
				Minimum Working Hours per Day: <span id="minimumHours"></span>
			</p>
		</div>

		<table id="attendanceTable">
		</table>
	</div>

	
	
	</div>
</body>
</html>