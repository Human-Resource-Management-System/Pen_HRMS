<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
<script>
    var errorMessage = "${errorMessage}";
    if (errorMessage) {
        alert(errorMessage);
        window.history.back(); // Optional: Redirect the user back to the previous page
    }
</script>
</head>
<body>
    <h1>Error Page</h1>
    <!-- Your error page content -->
</body>
</html>
