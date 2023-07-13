 // Function to open the modal popup for employee details
        function openModal(employeeId) 
        {
           
        	var modal = document.getElementById("myModal");
            modal.style.display = "block";          
            var url = "get-employee-details?id=" + employeeId;            
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    var employeeDetails = this.responseText;
                    document.getElementById("modalContent").innerHTML = employeeDetails;
                }
            };
            xhttp.open("GET", url, true);
            xhttp.send();
        }
        
     // Function to open the modal popup for inserting a new employee
        function openAddEmployeePopup() 
        {
            var modal = document.getElementById("myModal");
            modal.style.display = "block";          
            var url = "addempl";           
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    var addEmployeeForm = this.responseText;
                    document.getElementById("modalContent").innerHTML = addEmployeeForm;
                }
            };
            xhttp.open("GET", url, true);
            xhttp.send();
                    
        }
        
     // Function to open the modal popup for deleting an employee
        function openDeleteEmployeePopup() {
    var modal = document.getElementById("myModal");
    modal.style.display = "block";

    var url = "delempl";
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var deleteEmployeePage = this.responseText;
            document.getElementById("modalContent").innerHTML = deleteEmployeePage;

            // Prevent closing the popup when clicking the delete button
            var deleteButton = document.getElementById("deleteButton");
            deleteButton.addEventListener("click", function(event) {
                event.stopPropagation();
            });
        }
    };
    xhttp.open("GET", url, true);
    xhttp.send();

    // Prevent closing the popup when clicking inside the modal content
    var modalContent = document.getElementById("modalContent");
    modalContent.addEventListener("click", function(event) {
        event.stopPropagation();
    });
}




        
        // Function to close the modal popup
        function closeModal() {
            var modal = document.getElementById("myModal");
            modal.style.display = "none";
        }/**
 * 
 */