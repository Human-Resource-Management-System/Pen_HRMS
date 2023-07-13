<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employment Induction Documents</title>
      <style>
        body {
            font-family: Arial, sans-serif;
        }
        
        h1, h2 {
            color: #333;
            margin-bottom: 20px;
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
        }
        
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ccc;
        }
        
        tr:hover {
            background-color: #f5f5f5;
        }
        
        label {
            display: inline-block;
            width: 150px;
            margin-bottom: 10px;
            font-weight: bold;
        }
        
        input[type="text"],
        input[type="file"] {
            padding: 5px;
            width: 300px;
        }
        
        button[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        
        button[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Employment Induction Documents</h1>
    
    <table>
        <thead>
            <tr>
           <th>Document Index</th>
                <th>Employee ID</th>
                <th>Employment Offer</th>
                <th>Document Type</th>
                <th>Document Data</th>
                <th>Processed User</th>
                <th>Verified</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${documents}" var="document">
                <tr>
                    <td>${document.documentIndex}</td>
                    <td>${document.emplid}</td>
                    <td>${document.employmentOffer}</td>
                    <td>${document.documentType}</td>
                    <td>${document.documentData}</td>
                    <td>${document.processedUser}</td>
                    <td>${document.verified}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>