        function loadEmployeeList() {
    	$.ajax({
        	url: "employeeListDelete", 
        	method: "GET",
        	success: function(response) {
            	$("#employeeList").html(response);
        	},
        	error: function(xhr, status, error) {
            	console.log("Error loading employee list: " + error);
        	}
    	});
	}
        
    loadEmployeeList();
    setInterval(loadEmployeeList, 2000);/**
 * 
 */