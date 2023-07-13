<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Retrieve Employee ID</title>
    <link rel="stylesheet" type="text/css" href="./css/delEmpl.css">
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <script src="./js/delempl.js"></script>
   
</head>

<body>

    <h1>Enter Employee ID</h1>
    
    <form action="employeeListDelete" method="post">
        <label for="emplId">Employee ID:</label>
        <input type="text" name="emplId" id="emplId" required><br>
        <input type="submit" value="Submit">
    </form>
    
    <div id="employeeList">    
    </div>
    
    
</body>
</html>