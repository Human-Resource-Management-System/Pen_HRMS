<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="models.ApplyPermissions" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Permission Requests</title>

 <link rel="stylesheet" type="text/css" href="./css/adminViewPermission.css">
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script src="./js/adminViewPermission.js"></script>
</head>
<body>
    <h1>Permission Requests</h1><br>
    <table>
        <thead>
            <tr>
                <th>Emp ID</th>
                <th>Permission Date</th>
                <th>Start Time</th>
                <th>End Time</th>
                <th>Reason</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% List<ApplyPermissions> permissions = (List<ApplyPermissions>) request.getAttribute("permissions");
            if (permissions != null) {
                for (ApplyPermissions permi : permissions) {
            %>
            <tr>
                <td align="center"><%= permi.getId().getId() %></td>
                <td align="center"><%= permi.getCurrent_date() %></td> 
                <td align="center"><%= permi.getStart_time() %></td>
                <td align="center"><%= permi.getEnd_time() %></td>
                <td align="center"><%=permi.getReason() %></td>
                <td class="action-buttons">
                    <button class="accept-button" onclick="acceptPermission(<%= permi.getId().getId() %>,<%= permi.getId().getEp_index() %>)">Accept</button>
                    <button class="reject-button" onclick="rejectPermission(<%= permi.getId().getId() %>,<%= permi.getId().getEp_index() %>)">Reject</button>
                </td>             
            </tr>
            <% }
            }
            %>
        </tbody>
    </table>


</body>
</html>
