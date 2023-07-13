<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="models.input.output.EmployeeOutput" %>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
 
	 <link rel="stylesheet" type="text/css" href="./css/employee.css">
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script src="./js/employee.js"></script>
   
</head>

<body>
    <h1>Employee List</h1><br>
    <% List<EmployeeOutput> employees = (List<EmployeeOutput>) request.getAttribute("employees"); %>
    <% if (employees != null && !employees.isEmpty()) { %>
        <table>
            <thead>
                <tr>
                    <th>Employee ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Surname</th>
                    <th>Gender</th>
                    <th>Manager Id</th>
                    <th>HR Id</th>
                    <th>Job Grade</th>
                    <th>Joining Date</th>
                    <th>Date of Birth</th>
                    <th>Designation</th>
                    <th>Office Email</th>
                    <th>Personal Email</th>
                    <th>Mobile number</th>                               
                </tr>
            </thead>
            <tbody>
                <% for (EmployeeOutput employee : employees) { %>
                    <tr onclick="openModal('<%= employee.getEmplId() %>')">
                        <td><%= employee.getEmplId() %></td>
                        <td><%= employee.getEmplFirstname() %></td>
                        <td><%= employee.getEmplLastname() %></td>
                        <td><%= employee.getEmplSurname() %></td>
                        <td><%= employee.getEmplGender() %></td>
                        <td><%= employee.getEmplRmanagerEmplId() %></td>
                        <td><%= employee.getEmplHrEmplId() %></td>
                        <td><%= employee.getEmplJbgrId() %></td>
                        <td><%= employee.getEmplJondate() %></td>
                        <td><%= employee.getEmplDob() %></td>
                        <td><%= employee.getEmplDesignation() %></td>
                        <td><%= employee.getEmplOffemail() %></td>
                        <td><%= employee.getEmplPemail() %></td>
                        <td><%= employee.getEmplMobile() %></td>                       
                    </tr>
                <% } %>
            </tbody>
        </table>

        <!-- Modal content -->
        <div id="myModal" class="modal">
            <div class="modal-content">
                <span class="close" onclick="closeModal()">&times;</span>
                <div id="modalContent"></div>
            </div>
        </div>

         <!-- Add and delete buttons -->
        <div class="center">       
            <button onclick="openAddEmployeePopup();">Add</a>
            <button onclick="openDeleteEmployeePopup()">Delete</button>
        </div>
        
    <% } else { %>
        <p class="no-employees">No employees found.</p>
    <% } %>
    
</body>
</html>
