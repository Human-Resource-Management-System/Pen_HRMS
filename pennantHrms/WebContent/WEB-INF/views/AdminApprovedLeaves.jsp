<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Approved Leaves</title>
    
 <link rel="stylesheet" type="text/css" href="./css/AdminApprovedLeaves.css">

</head>
<body>
    <%@ page import="java.util.List, java.util.ArrayList" %>
    <%@ page import="models.ApprovedLeaveModel" %>
    
    <h1>Approved Leaves</h1><br>
    
    <table>
        <tr>
            <th>Employee ID</th>
            <th>Employee Name</th>
            <th>Approved Start Date</th>
            <th>Approved End Date</th>
        </tr>
        
        <% 
        List<ApprovedLeaveModel> approvedLeaves = (List<ApprovedLeaveModel>) request.getAttribute("approvedLeaves");
        
        for (ApprovedLeaveModel leave : approvedLeaves) { 
        %>
        <tr>
            <td><%= leave.getEmployeeId() %></td>
            <td><%= leave.getEmployeeName() %></td>
            <td><%= leave.getApprovedStartDate() %></td>
            <td><%= leave.getApprovedEndDate() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
