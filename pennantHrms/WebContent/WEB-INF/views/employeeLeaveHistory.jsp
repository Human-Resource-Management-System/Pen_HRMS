<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Approved Leaves</title>
 <link rel="stylesheet" type="text/css" href="./css/employeeLeaveHistory.css">
 
</head>
<body>
    <%@ page import="java.util.List, java.util.ArrayList" %>
    <%@ page import="models.EmployeeLeaveModel" %>
    
    <h1>Leaves History</h1><br>
    
    <table>
        <tr>
            <th>Leave Id</th>
            <th>Approved Start Date</th>
            <th>Approved End Date</th>
            <th>Leave Type</th>
            <th>Reason</th>
            <th>Leave Request Date</th>
            <th>Status</th>
        </tr>
        
        <% 
        List<EmployeeLeaveModel> approvedLeaves = (List<EmployeeLeaveModel>) request.getAttribute("leavehistory");
        
        for (EmployeeLeaveModel leave : approvedLeaves) { 
            String statusClass = "";
            if (leave.getStatus() == -1) {
                statusClass = "rejected";
            } else if (leave.getStatus() == 0) {
                statusClass = "in-progress";
            } else {
                statusClass = "approved";
            }
        %>
        <tr class="<%= statusClass %>">
           <td><%= leave.getLeaveRequestIndex() %></td>
           <td><%= leave.getLeaveStartDate() %></td>
           <td><%= leave.getLeaveEndDate() %></td>
           <td><%= leave.getLeaveType() %></td>
           <td><%= leave.getReason() %></td>
           <td><%= leave.getLeaveRequestDate()%></td>
           <td><%= statusClass%></td>
        </tr>
        <% } %>
    </table>
    
</body>
</html>