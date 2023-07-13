    function loadEmployeeList() {
    	$.ajax({
        	url: "candidateadded", 
        	method: "GET",
        	success: function(response) {
            	$("#candidateadded").html(response);
        	},
        	error: function(xhr, status, error) {
            	console.log("Error loading employee list: " + error);
        	}
    	});
	}
    loadEmployeeList();
    setInterval(loadEmployeeList, 2000);
    /**
 * 
 */