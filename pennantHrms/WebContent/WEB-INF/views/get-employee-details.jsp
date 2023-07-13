<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="models.input.output.EmployeeOutput" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Details</title>
    <style>
    .modal {
        display: block;
        position: fixed;
        z-index: 1;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgba(0, 0, 0, 0.4);
    }

    .modal-content {
        background-color: #fefefe;
        margin: 2% auto;
        padding: 20px;
        border: 1px solid #888;
        width: 80%;
        max-width: 800px;
        border-radius: 5px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        text-align: center; /* Center the content */
    }

    .close {
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
        cursor: pointer;
    }


    img {
        display: block;
        margin: 0 auto;
        max-width: 100%;
        height: auto;
        margin-bottom: 20px;
    }
    
     button.back-button {
    		 background-color: #333;
             color: white;
             border: none;
             padding: 10px 20px;
             margin-top: 10px;
             cursor: pointer;
             border-radius: 3px;
		}		
		
		 button.back-buttons {
    		 background-color: #333;
             color: white;
             border: none;
             padding: 10px 20px;
             margin-top: 10px;
             cursor: pointer;
             border-radius: 3px;
		}		
     </style>
</head>

<body>
    
    <div id="myModal" class="modal">
        <div class="modal-content">
            
            <span class="close" onclick="closeModal()">&times;</span>
            
            <h1>Employee Details</h1>            
           
            <% EmployeeOutput employee = (EmployeeOutput) request.getAttribute("employee");
               String imagePath = request.getContextPath() + "/";
               String employeeId = request.getParameter("id"); %>
           
            <% if (employee != null) { %>
                <img src="<%= imagePath + employee.getEmplPhoto() %>" alt="Employee Photo">
                <div class="details">
                    <h2>Employee Details for Employee ID: <%= employee.getEmplId() %></h2>
                    <p>Employee ID: <%= employee.getEmplId() %></p>
                    <p>First Name: <%= employee.getEmplFirstname() %></p>
                    <p>Last Name: <%= employee.getEmplLastname() %></p>
                    <p>Surname: <%= employee.getEmplSurname() %></p>
                    <p>Reporting Manager ID: <%= employee.getEmplRmanagerEmplId() %></p>
                    <p>HR Manager ID: <%= employee.getEmplHrEmplId() %></p>
                    <p>Job Group ID: <%= employee.getEmplJbgrId() %></p>
                    <p>Join Date: <%= employee.getEmplJondate() %></p>
                    <p>Date of Birth: <%= employee.getEmplDob() %></p>
                    <p>Designation: <%= employee.getEmplDesignation() %></p>
                    <p>Official Email: <%= employee.getEmplOffemail() %></p>
                    <p>Personal Email: <%= employee.getEmplPemail() %></p>
                    <p>Mobile: <%= employee.getEmplMobile() %></p>
                    <p>Alternate Email: <%= employee.getEmplAlemail() %></p>
                    <p>Blood Group: <%= employee.getEmplBloodgroup() %></p>
                    <p>Gender: <%= employee.getEmplGender() %></p>
                    <p>Address: <%= employee.getEmplAddress() %></p>
                    <p>Father's Name: <%= employee.getEmplFname() %></p>
                    <p>Last Update Date: <%= employee.getEmplLuudate() %></p>
                    <p>Last Update User ID: <%= employee.getEmplLuuser() %></p>
                    <p>Employee CTC: <%= employee.getEmpl_ctc() %></p>
                    <p>Basic Salary: <%= employee.getEmpl_basicsal() %></p>
                    <p>Fixed Salary: <%= employee.getEmpl_fixedsal() %></p>
                    <p>Variable Salary: <%= employee.getEmpl_variablesal() %></p>
                    <p>Status: <%= employee.getEmpl_status() %></p>
                    <button class="back-button" data-id="<%= employee.getEmplId() %>">Edit</button>
                    <button class="back-buttons" data-id="<%= employee.getEmplId() %>">Parameters</button>

                </div>
                
            <% } else { %>
                <p>No employees found </p>
            <% } %>
            
        </div>
    </div>
</body>
</html>
