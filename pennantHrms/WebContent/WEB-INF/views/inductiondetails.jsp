<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="models.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Induction Details</title>
 <link rel="stylesheet" type="text/css" href="./css/inductiondetails.css">
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script src="./js/inductiondetails.js"></script>
</head>
<body>
    <% 
        List<Induction> inductions = (List<Induction>) request.getAttribute("indid");
        Integer i = (Integer) request.getAttribute("ID");
    %>
    <h1>Induction-<%= i %> Details </h1><br>
    
    <% if (inductions != null && !inductions.isEmpty()) { %>
        <table>
            <thead>
                <tr>
                    <th>Employee Offer ID</th>
                    <th>Date</th>
                    <th>Handled By</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <% for (Induction induction : inductions) { %>
                    <tr>
                       <td><%= induction.getIndcEmofId() %></td>
                       <td><%= induction.getIndcDate() %></td>
                       <td><%= induction.getIndcProcessedAusrId() %></td>
                       <td><%= induction.getIndcStatus() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } else { %>
        <p class="no-inductions">No inductions found.</p>
    <% } %>
    <br><br>
    <div>
        <button type="button" onclick="goBack()">Back</button>
       </div> 
</body>
</html>

