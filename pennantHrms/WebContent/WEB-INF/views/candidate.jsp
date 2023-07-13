<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Enter Candidate Details</title>
        <style>
        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
            padding-left: 150px;
            padding-right: 350px;
            padding-top: 40px;
            padding-bottom: 40px;
            
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #333;
            text-align: center;
            margin-top: 0;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #333;
            font-weight: bold;
        }

        input[type="text"],
        input[type="date"],
        input[type="email"],
        textarea {
            width: 200%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 14px;
            margin-bottom: 10px;
        }

        textarea {
            height: 100px;
        }

        input[type="submit"] {
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }

        .error {
            color: red;
            font-size: 12px;
        }
    </style>
    
</head>
<body>
    <h1>Enter Candidate Details</h1><br>
    <div class="container">
    <form:form method="post" action="candidateadded" modelAttribute="candidate" id="candidateForm">
        <label for="candFirstName">First Name:</label>
        <form:input path="candFirstName" id="candFirstName" /><br>
        <form:errors path="candFirstName" cssClass="error"/><br><br>
        
        <label for="candMiddleName">Middle Name:</label>
        <form:input path="candMiddleName" id="candMiddleName"/><br><br>
        
        <label for="candLastName">Last Name:</label>
        <form:input path="candLastName" id="candLastName"/><br>
        <form:errors path="candLastName" cssClass="error"/><br><br>
        
        <label for="candRDate">Registration Date:</label>
        <form:input path="candRDate" id="candRDate" type="date" /><br>
        <form:errors path="candRDate" cssClass="error"/><br><br>
        
        <label for="candGender">Gender:</label>
        <form:input path="candGender" id="candGender" /><br>
        <form:errors path="candGender" cssClass="error"/><br><br>
        
        <label for="candDOB">Date of Birth:</label>
        <form:input path="candDOB" id="candDOB" type="date" /><br>
        <form:errors path="candDOB" cssClass="error"/><br><br>
        
        <label for="candEmail">Email:</label>
        <form:input path="candEmail" id="candEmail" /><br>
        <form:errors path="candEmail" cssClass="error"/><br><br>
        
        <label for="candMobile">Mobile Number:</label>
        <form:input path="candMobile" id="candMobile" /><br>
        <form:errors path="candMobile" cssClass="error"/><br><br>
        
        <label for="candAddress">Address:</label>
        <form:textarea path="candAddress" id="candAddress" rows="3" /><br>
        <form:errors path="candAddress" cssClass="error"/><br><br>
        
        <label for="candLUDate">Last Update Date:</label>
        <form:input path="candLUDate" id="candLUDate" type="date" /><br>
        <form:errors path="candLUDate" cssClass="error"/><br><br>
        
        <label for="candStatus">Status:</label>
        <form:input path="candStatus" id="candStatus" /><br>
        <form:errors path="candStatus" cssClass="error"/><br><br>
        
        <input class= "submit-button" type="submit" value="Submit">
    </form:form>
    </div>
    
     
</body>
</html>
