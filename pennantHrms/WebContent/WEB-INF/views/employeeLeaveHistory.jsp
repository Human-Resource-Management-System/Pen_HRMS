<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Approved Leaves</title>
 <style>
        body {
            font-family: Arial, sans-serif;
        }
        
        h1,h3 {
           
            text-align: center;
        }
        
        table {
            border-collapse: collapse;
            width: 100%;
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
        }
        
        th, td {
            padding: 8px;
            text-align: left;
        }
        
        th {
            background-color: #f2f2f2;
            font-weight: bold;
            color: #333;
        }
       
        .rejected {
            background-color: #FFCCCC;
        }
        
        .in-progress {
            background-color: #FFFFCC;
        }
        
        .approved {
            background-color: #CCFFCC;
        }
 
 </style>

</head>
<body>
    <%@ page import="java.util.List, java.util.ArrayList , models.EmployeeLeaveModel" %>
    
    <h1>Leaves History</h1><br>
    
    <table>
       
        <% 
        List<EmployeeLeaveModel> approvedLeaves = (List<EmployeeLeaveModel>) request.getAttribute("leavehistory");
        
        if(approvedLeaves.size()!=0){
        	
      %>
         <tr>
            <th>Leave Id</th>
            <th>Approved Start Date</th>
            <th>Approved End Date</th>
            <th>Leave Type</th>
            <th>Reason</th>
            <th>Leave Request Date</th>
            <th>Status</th>
            <th>Remarks</th>
        </tr>
        
      <%
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
           <td><%= leave.getLeaveRequestDate() %></td>
           <td><%= statusClass%></td>
           <td><%= leave.getRemarks() %></td>
        </tr>
        <% } } else { %>
         <h3>No Leaves Found</h3>
         <%} %>
    </table>
    
</body>
</html>