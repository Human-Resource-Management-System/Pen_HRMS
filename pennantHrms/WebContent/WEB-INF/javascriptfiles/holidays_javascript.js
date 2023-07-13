    function filterTable() {
        // Get the input value and convert to lowercase
        console.log("function called");
        var input = document.getElementById("filterInput").value.toLowerCase();
        
        // Get the table rows
        var rows = document.getElementById("dataTable").getElementsByTagName("tr");
        
        // Iterate through the rows and hide those that don't match the search input
        for (var i = 0; i < rows.length; i++) {
            var row = rows[i];
            var cells = row.getElementsByTagName("td");
            var match = false;
            
            for (var j = 0; j < cells.length; j++) {
                var cell = cells[j];
                
                // Check if the cell content matches the search input
                if (cell.innerHTML.toLowerCase().indexOf(input) > -1) {
                    match = true;
                    break;
                }
            }
            
            // Show or hide the row based on the match
            if (match) {
                row.style.display = "";
            } else {
                row.style.display = "none";
            }
        }
    }