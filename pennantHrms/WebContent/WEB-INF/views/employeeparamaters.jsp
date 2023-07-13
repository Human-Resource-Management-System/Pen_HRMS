<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="models.input.output.EmployeeParameterIO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Parameters</title>
    <style>
       

        h1 {
            color: #333;
            margin-bottom: 30px;
            text-align: center;
        }

        table {
            width: 60%;
            border-collapse: collapse;  
            margin: 0 auto;     
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }

        th, td {
            
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold;
            color: #333;
            text-transform: uppercase;
        }


        .no-employees {
            margin-top: 20px;
            color: #888;
            text-align: center;
        }

        .table-container {
            overflow-x: auto;
        }

        .table-container::-webkit-scrollbar {
            height: 5px;
            background-color: #f4f4f4;
        }

        .table-container::-webkit-scrollbar-thumb {
            background-color: #888;
            border-radius: 4px;
        }

        .table-container::-webkit-scrollbar-track {
            background-color: #f4f4f4;
        }

         .center {
            text-align: center;
            margin-top: 10px;
        }
        </style>
</head>
<body>
<h1>Employee Parameters</h1>

<%
    List<EmployeeParameterIO> employeeParameters = (List<EmployeeParameterIO>) request.getAttribute("employeeParameters");
%>

<table>
    <tr>
        <th>Employee ID</th>
        <th>Employer ID</th>
        <th>Employer Name</th>
        <th>Employer Value</th>
        <th>Last Updated Date</th>
        <th>Last Updated User</th>
    </tr>

    <% for (EmployeeParameterIO employeeParam : employeeParameters) { %>
        <tr>
            <td><%= employeeParam.getEmployeeId() %></td>
            <td><%= employeeParam.getParameterId() %></td>
            <td><%= employeeParam.getParameterName() %></td>
            <td><%= employeeParam.getParameterValue() %></td>
            <td><%= employeeParam.getLastUpdatedDate() %></td>
            <td><%= employeeParam.getLastUpdatedUser() %></td>
        </tr>
    <% } %>
</table>

<%
    if (employeeParameters.isEmpty()) {
%>
    <p>No employee parameters found for the provided ID.</p>
<%
    }
%>
</body>
</html>
