<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Details</title>
    <style type="text/css">
     h1,form,label{
      text-align: center;
     }
    </style>
</head>
<body>
    <h1>Employee Details</h1><br>
    <form id="searchForm" action="get-employee-details">
        <label for="employeeId">Employee ID:</label>
        <input type="text" id="employeeId" name="id">
        <button type="submit">Search</button>
    </form>
    <div id="employeeDetails"></div>
</body>
</html>
