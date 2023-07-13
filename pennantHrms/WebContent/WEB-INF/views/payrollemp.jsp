<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="models.input.output.EmployeeOutput" %>

<!DOCTYPE html>
<html>
<head>
    <title>Enter Employee ID</title>

    <style>
        body {
            font-family: Arial, sans-serif;
        }
        
        #tableContainer {
            width: 80%;
            margin: 20px auto;
        }
        
        #filterInput {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        
        #dataTable {
            width: 100%;
            border-collapse: collapse;
        }
        
        #dataTable th,
        #dataTable td {
            padding: 10px;
            border: 1px solid #ccc;
        }
        
        #dataTable th {
            background-color: #f2f2f2;
        }
        
        .view-link {
            display: inline-block;
            padding: 5px 10px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        .payroll-button {
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            background-color: #4CAF50;
            color: white;
        }

        .payroll-button:hover {
            background-color: #45a049;
        }
        
        <style>
#spinner-container {
  display: none; /* Initially hide the spinner */
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5); /* Semi-transparent background */
  z-index: 9999; /* Ensure the spinner is on top */
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 0 auto;
}

#spinner {
  width: 40px;
  height: 40px;
  border: 4px solid #f3f3f3;
  border-top: 4px solid #3498db;
  border-radius: 50%;
  animation: spin 1s linear infinite;
  margin: 0 auto;
}

@keyframes spin {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}
</style>
    </style>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        function payroll(button) {
            var row = button.parentNode.parentNode;
            var employeeId = row.cells[0].innerText.trim();
            var selectedMonth = row.querySelector("select").value;

            // Show the loading spinner
            showSpinner(); 
            $("#msg").html('<div class="loading-spinner"></div>');

            $.ajax({
                type: "POST",
                url: "getpayslip",
                data: {
                    empl_id: employeeId,
                    month: selectedMonth
                },
                success: function(response) {
                    // Hide the loading spinner
                    $("#msg").empty();

                    var containerDiv = $(".main");
                    containerDiv.html(response);
                },
                error: function() {
                    // Hide the loading spinner
                    hideSpinner();
                    $("#msg").empty();

                    $("#msg").text("Error Occurred");
                    alert("**Already Generated**");
                }
            });
        }
        
        

        function showSpinner() {
          var spinnerContainer = document.getElementById('spinner-container');
          spinnerContainer.style.display = 'flex';
        }

        function hideSpinner() {
          var spinnerContainer = document.getElementById('spinner-container');
          spinnerContainer.style.display = 'none';
        }
    </script>
</head>
<body>
   
    <% List<EmployeeOutput> employees = (List<EmployeeOutput>) request.getAttribute("employeeList"); %>
    <% if (employees != null && !employees.isEmpty()) { %>
        <div id="tableContainer">
            <table id="dataTable">
                <thead>
                    <tr>
                        <th>Employee ID</th>
                        <th>Name</th>
                        <th>Designation</th>
                        <th>Office Email</th>
                        <th>Select month</th>
                        <th>Generate payslip</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (EmployeeOutput employee : employees) { %>
                        <tr>
                            <td><%= employee.getEmplId() %></td>
                            <td><%= employee.getEmplFirstname() + " " + employee.getEmplLastname() + " " + employee.getEmplSurname() %></td>
                            <td><%= employee.getEmplDesignation() %></td>
                            <td><%= employee.getEmplOffemail() %></td>
                            <td>
                                <select id="month_<%= employee.getEmplId() %>" name="month">
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
                                </select>
                            </td>
                            <td>
                                <button type="button" onclick="payroll(this);" class="payroll-button">Generate</button>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    <% } else { %>
        <p class="no-employees">No employees found.</p>
    <% } %>

  
<center>
  <div id="spinner-container" style="display: none;">
    <div id="spinner"></div>
  </div>
</center>


</body>
</html>
