<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
        }

        .error-container {
            max-width: 500px;
            margin: 100px auto;
            padding: 20px;
            background-color: #ffcccc;
            border: 2px solid #ff0000;
            border-radius: 5px;
        }

        h1 {
            font-size: 28px;
            color: #ff0000;
            margin-bottom: 10px;
        }

        p {
            font-size: 18px;
            color: #333333;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h1>Error</h1>
        <p>${errorMessage}</p>
    </div>
</body>
</html>