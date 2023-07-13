/**
 * 
 */
function updateTableData() {
			var selectedYear = $("#yearSelect").val();
			var selectedMonth = $("#monthSelect").val();
			var employeeId = $("#employeeIdInput").val();

			// Update minimum working hours per day
			$("#minimumHours").text(8);

			console.log(selectedYear);
			console.log(selectedMonth);
			console.log(employeeId);
			var table = $("#attendanceTable");

			$.ajax({
			    url: "attendance",
			    type: "POST",
			    data: {"year": selectedYear, "month": selectedMonth, "employeeid": employeeId},
			    contentType: "application/x-www-form-urlencoded",
			    dataType:"json",
			    success: function(response) {
			        console.log(response);
			        var template = "<tr>" +
		            "<th>Days with Minimum Hours</th>" +
		            "<th>Total Days</th>" +
		            "<th>Attendance Percentage</th>" +
		            "</tr>" +
		            "<tr>" +
		            "<td>" + response.dayswithminhrs + "</td>" +
		            "<td>" + response.totaldays + "</td>" +
		            "<td>" + response.percentage + "%</td>" +
		            "</tr>";
		        
		        table.html(template);
			    },
			    error: function(error) {
			        console.log(error);
			    }
			});
		}

		// Add event listeners to the year, month, and employee ID input
		$("#yearSelect").change(updateTableData);
		$("#monthSelect").change(updateTableData);
		$("#employeeIdInput").on("input", getYearsList);

		
		function getYearsList(){
			
			var employeeId = $("#employeeIdInput").val();
			
			$("#msg").empty();
			
			$.ajax({
				url:"getYearsList",
				type:"POST",
				data: {employeeid:employeeId},
				success:function(response){
					console.log(response);
					var yearsList = JSON.parse(response);
					var selectElement = $('#yearSelect'); 
					  selectElement.empty();
					  for (var i = 0; i < yearsList.length; i++) {
					    var year = yearsList[i];
					    var optionElement = $('<option>').val(year).text(year);
					    selectElement.append(optionElement);
					  }
					
				},
				error:function(error){
					var selectElement = $('#yearSelect'); 
					  selectElement.empty();
					$("#msg").html("No Employee Found");
				}
			
			});
		}