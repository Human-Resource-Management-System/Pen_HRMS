<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="models.LeaveValidationModel" %> 
<!DOCTYPE html>
<html>
<head>
<title>Leave Form</title>
  <link rel="stylesheet" type="text/css" href="./css/leaveform.css">

<script src="https://code.jquery.com/jquery-3.7.0.min.js"
	integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
	crossorigin="anonymous"></script>
</head>
<body>
   
    

	<h1>Leave Form</h1><br>

	<%
	LeaveValidationModel validationData = (LeaveValidationModel)request.getAttribute("validationData");
	%>
	 <div class="container">
	<form id="leave-form" method="post">
	
		<div class="form-group">
			<label for="employee-id">Employee ID:</label> <input type="number"
				id="employee-id" name="employeeId"
				value="<%=(Integer) session.getAttribute("employeeId")%>" readonly>
		</div>


		<div class="form-group">
			<label for="leave-start-date">Leave Start Date:</label> <input
				type="date" id="leave-start-date" name="leaveStartDate" required>
		</div>

		<div class="form-group">
			<label for="leave-end-date">Leave End Date:</label> <input
				type="date" id="leave-end-date" name="leaveEndDate" required>
		</div>

		<div class="form-group">
			<label for="leave-type">Leave Type:</label> <select id="leave-type"
				name="leaveType">
				<option value="CASL">CASL</option>
				<option value="SICK">SICK</option>
				<option value="OTHR">OTHR</option>
			</select>
		</div>

		<div class="form-group">
			<label for="reason">Reason:</label>
			<textarea id="reason" name="reason" required></textarea>
		</div>
		<input class="submit-button" type="button" value="Submit"
			onclick="submitLeave()">

		<div id="info-msg"></div>
	</form>
	</div>
	<script>
		function submitLeave() {

			console.log($("#leave-form").serialize())

			$("#info-msg").removeClass().addClass("process-msg").html("Applying ... ");
			
			
			// validation
			
			  var validationData = {
        allowedTotalLeaves: <%= validationData.getAllowedTotalLeaves() %>,
        allowedSickLeaves: <%= validationData.getAllowedSickLeaves() %>,
        allowedCasualLeaves: <%= validationData.getAllowedCasualLeaves() %>,
        allowedOtherLeaves: <%= validationData.getAllowedOtherLeaves() %>,
        takenTotalLeaves: <%= validationData.getTakenTotalLeaves() %>,
        takenSickLeaves: <%= validationData.getTakenSickLeaves() %>,
        takenCasualLeaves: <%= validationData.getTakenCasualLeaves() %>,
        takenOtherLeaves: <%= validationData.getTakenOtherLeaves() %>,
        pendingTotalLeaves: <%= validationData.getPendingTotalNoOfLeaves()%>,
        pendingCasualLeaves: <%= validationData.getPendingCasualLeaves()%>,
        pendingSickLeaves:  <%= validationData.getPendingSickLeaves()%>,
        pendingOtherLeaves: <%= validationData.getPendingOtherLeaves()%>
    };

    // Check if the leave is within the allowed limits
    var leaveType = $("#leave-type").val();
    var leaveStartDate = new Date($("#leave-start-date").val());
    var leaveEndDate = new Date($("#leave-end-date").val());
    var numberOfDays = Math.round((leaveEndDate - leaveStartDate) / (24 * 60 * 60 * 1000));

    // Perform validation
    if (leaveType === "SICK" && numberOfDays > (validationData.allowedSickLeaves - validationData.takenSickLeaves - validationData.pendingSickLeaves)) {
    	if(validationData.pendingSickLeaves != 0)
            $("#info-msg").removeClass().addClass("leave-error-msg").html("You have Pending Sick Leave Requests.");
    	else
        $("#info-msg").removeClass().addClass("leave-error-msg").html("You have exceeded the allowed number of sick leaves.");
        return;
    } 
    if (leaveType === "CASL" && numberOfDays > (validationData.allowedCasualLeaves - validationData.takenCasualLeaves - validationData.pendingCasualLeaves)) {
    	if(validationData.pendingCasualLeaves != 0)
            $("#info-msg").removeClass().addClass("leave-error-msg").html("You have Pending casual leave Requests.");
        else
        $("#info-msg").removeClass().addClass("leave-error-msg").html("You have exceeded the allowed number of casual leaves.");
        return;
    } 
    if (leaveType === "OTHR" && numberOfDays > (validationData.allowedOtherLeaves - validationData.takenOtherLeaves - validationData.pendingOtherLeaves)) {
    	if(validationData.pendingOtherLeaves != 0)
            $("#info-msg").removeClass().addClass("leave-error-msg").html("You have Pending other leave Requests");
    	else
        $("#info-msg").removeClass().addClass("leave-error-msg").html("You have exceeded the allowed number of other leaves.");
        return;
    } 
			
			// Send the Ajax request
			$.ajax({
				url : "submitleave",
				type : "POST",
				data : $("#leave-form").serialize(),
				success : function(response) {
					console.log("Leave request submitted successfully");
					$("#info-msg").removeClass().addClass("leave-success-msg")
							.html("leave applied successfully");
					
					setTimeout(function() {
			            location.reload();
			        }, 1500);
					
				},
				error : function(xhr, status, error) {
					console.log("Error submitting leave request:", error);
					$("#info-msg").removeClass().addClass("leave-error-msg")
							.html("something went wrong");

				}
			});

		}
	</script>
</body>
</html>