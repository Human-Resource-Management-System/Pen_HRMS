 function goBack() {
  	  $.ajax({
  	    type: "POST",
  	    url: "inductionlist",
  	  
  	    success: function(response) {
  	      var containerDiv = $("#main");
  	      containerDiv.html(response);
  	    },
  	    error: function() {
  	      alert("Error occurred. Please try again later.");
  	    }
  	  });
  	}