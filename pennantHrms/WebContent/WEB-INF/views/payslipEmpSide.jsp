<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Select Payslips by Month</title>
 	 <link rel="stylesheet" type="text/css" href="./css/paySlipEmpSide.css">
  

</head>
<body>
    <h2>Select Payslips by Month</h2>
    <form action="EmployeeSidePaySlip" method="post">
        <label for="month">Select Month:</label>
 		<select id="month" name="month">
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
            <!-- Add more options for each month -->
        </select>
        <br><br>
        <input type="submit" value="View Payslips">
    </form>
</body>
</html>
