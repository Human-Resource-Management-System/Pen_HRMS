<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="models.input.output.EmployeeOutput" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }

        .container {
            width: 500px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 4px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
        }

        h1 {
            color: #333;
            text-align: center;
        }

        form {
            max-width: 500px;
            margin: 0 auto; 
            margin-top: 20px;
        }

        label {
            display: block;
            margin-top: 10px;
        }

        input[type="text"],
        input[type="date"],
        textarea {
            width: 100%;
            padding: 5px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
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

    <% EmployeeOutput employee = (EmployeeOutput) request.getAttribute("updating");
        %>
    <form method="post" action="update" >
    
      <label for="emplId">Employee ID:</label>
      <input type="number" id="emplId" name="emplId" value="<%= employee.getEmplId() %>" readonly ><br><br>

      <label for="emplFirstname">First Name:</label>
      <input type="text" id="emplFirstname" name="emplFirstname" value="<%= employee.getEmplFirstname() %>"><br><br>

      <label for="emplLastname">Last Name:</label>
      <input type="text" id="emplLastname" name="emplLastname" value="<%= employee.getEmplLastname() %>"><br><br>

      <label for="emplSurname">Surname:</label>
      <input type="text" id="emplSurname" name="emplSurname" value="<%= employee.getEmplSurname() %>"><br><br>

      <label for="emplRmanagerEmplId">Reporting Manager ID:</label>
      <input type="number" id="emplRmanagerEmplId" name="emplRmanagerEmplId" value="<%= employee.getEmplRmanagerEmplId() %>"><br><br>

      <label for="emplHrEmplId">HR Employee ID:</label>
      <input type="number" id="emplHrEmplId" name="emplHrEmplId" value="<%= employee.getEmplHrEmplId() %>"><br><br>

      <label for="emplJbgrId">Job Group ID:</label>
      <input type="text" id="emplJbgrId" name="emplJbgrId" value="<%= employee.getEmplJbgrId() %>"><br><br>

      <label for="emplPhoto">Photo:</label>
      <input type="text" id="emplPhoto" name="emplPhoto" value="<%= employee.getEmplPhoto() %>"><br><br>

      <label for="emplJondate">Joining Date:</label>
      <input type="date" id="emplJondate" name="emplJondate" value="<%= employee.getEmplJondate() %>" readonly><br><br>

      <label for="emplDob">Date of Birth:</label>
      <input type="date" id="emplDob" name="emplDob" value="<%= employee.getEmplDob() %>" readonly><br><br>

      <label for="emplDesignation">Designation:</label>
      <input type="text" id="emplDesignation" name="emplDesignation" value="<%= employee.getEmplDesignation() %>"><br><br>

      <label for="emplOffemail">Official Email:</label>
      <input type="text" id="emplOffemail" name="emplOffemail" value="<%= employee.getEmplOffemail() %>" readonly><br><br>

      <label for="emplPemail">Personal Email:</label> 
      <input type="text" id="emplPemail" name="emplPemail" value="<%= employee.getEmplPemail() %>"><br><br>

      <label for="emplMobile">Mobile:</label>
      <input type="number" id="emplMobile" name="emplMobile" value="<%= employee.getEmplMobile() %>"><br><br>

      <label for="emplAlemail">Alternate Email:</label>
      <input type="text" id="emplAlemail" name="emplAlemail" value="<%= employee.getEmplAlemail() %>"><br><br>

      <label for="emplBloodgroup">Blood Group:</label>
      <input type="text" id="emplBloodgroup" name="emplBloodgroup" value="<%= employee.getEmplBloodgroup() %>" readonly><br><br>

      <label for="emplGender">Gender:</label>
      <input type="text" id="emplGender" name="emplGender" value="<%= employee.getEmplGender() %>" readonly><br><br>

      <label for="emplAddress">Address:</label>
      <input type="text" id="emplAddress" name="emplAddress" value="<%= employee.getEmplAddress() %>"><br><br>

      <label for="emplFname">Fname:</label>
      <input type="text" id="emplFname" name="emplFname" value="<%= employee.getEmplFname() %>" readonly><br><br>

      <label for="empl_ctc">CTC:</label>
      <input type="number" id="empl_ctc" name="empl_ctc" value="<%= employee.getEmpl_ctc() %>"><br><br>

      <label for="empl_basicsal">Basic Salary:</label>
      <input type="number" id="empl_basicsal" name="empl_basicsal" value="<%= employee.getEmpl_basicsal() %>"><br><br>

      <label for="empl_fixedsal">Fixed Salary:</label>
      <input type="number" id="empl_fixedsal" name="empl_fixedsal" value="<%= employee.getEmpl_fixedsal() %>"><br><br>

      <label for="empl_variablesal">Variable Salary:</label>
      <input type="number" id="empl_variablesal" name="empl_variablesal" value="<%= employee.getEmpl_variablesal() %>"><br><br>

      <label for="empl_status">Status:</label>
      <input type=text id="empl_status" name="empl_status" value="<%= employee.getEmpl_status() %>" readonly><br><br>

      <input type="submit" class="saved" value="Save">
  </form>
  </div>
  </div>


</body>
</html>
