<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Permission Application</title>


 <link rel="stylesheet" type="text/css" href="./css/employeePermission.css">
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script src="./js/employeePermission.js"></script>
  <script>

  function permissionApplied() {
    // Prevent default form submission
    var validationData = {
      permissionsDayCount: <%= (Long)request.getAttribute("PermissionDayCount")%>,
		permissionsMonthCount : <%= (Long)request.getAttribute("PermissionMonthCount")%>
    };

    if (validationData.permissionsMonthCount >= 2) {
        alert("Maximum permissions applied for this Month");
        return;
    }
    
    if (validationData.permissionsDayCount > 0) {
      alert("Maximum permissions applied for today");
      return;
    }
    
    $("#msg").text("Applying....");

    $.ajax({
      type: "POST",
      url: "applyPermission",
      data: $("#permissionForm").serialize(), // Serialize form data
      success: function(response) {
        var containerDiv = $("#msg");
        containerDiv.text("successfully Applied");
        setTimeout(() => {
			location.reload();
		}, 1000);
      },
      error: function() {
        alert("Error occurred. Please try again later.");
      }
    });
  }
  </script>
</head>
<body>
  <h1>Permission Form</h1>
  <div class="container">
    <form id="permissionForm">
      <label for="id">ID:</label>
      <input type="number" id="id" name="id" value="<%=(Integer) session.getAttribute("employeeId")%>" readonly>

      <label for="current-date">Current Date:</label>
      <input type="date" id="current-date" name="current_date" required>

      <label for="start-time">Permission Start Time:</label>
      <input type="time" id="start-time" name="start_time"  required >
 
      <label for="end-time">Permission End Time:</label>
      <input type="time" id="end-time" name="end_time"  required >

      <label for="reason">Reason:</label>
      <textarea id="reason" name="reason" required></textarea>

      <button type="button" onclick="permissionApplied();">Apply</button>
    </form>
    
    <div id="msg"></div>
  </div>
  <div class="main"></div>
</body>
</html>
