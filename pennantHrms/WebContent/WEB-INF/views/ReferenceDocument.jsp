<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Reference Document</title>
    <style>
        .document-details {
            margin-bottom: 20px;
        }
        .document-content {
            border: 1px solid #ccc;
            padding: 10px;
        }
    </style>
</head>
<body>
    <h1>Reference Document</h1>

    <div class="document-details">
        <h2>Document Details:</h2>
        <p>Document Path: ${document.documentPath}</p>
        <!-- Add more document details fields here -->
    </div>

    <div class="document-content">
        <h2>Document Content:</h2>
        <iframe src="${document.documentPath}" style="width: 100%; height: 500px;"></iframe>
    </div>

    <!-- Add additional fields or styling as needed -->
</body>
</html>
