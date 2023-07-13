 $(document).ready(function() {
    	var today = new Date().toISOString().split("T")[0];
    	document.getElementById("current-date").setAttribute("max", today);
    	document.getElementById("current-date").setAttribute("min", today);


      // Update end time when start time changes
      $("#start-time").on("change", function() {
        var startTime = $("#start-time").val();
        if (startTime !== "") {
          var startDateTime = new Date("1970-01-01T" + startTime);
          var endDateTime = new Date(startDateTime.getTime() + 2 * 60 * 60 * 1000);
          var endTime = endDateTime.toTimeString().split(" ")[0];
          $("#end-time").val(endTime);
        }
      });
    });

