function acceptPermission(empId, index) {
    console.log("Accept permission for empId: " + empId);

    // Fetch the index for the given empId
    // Make the accept permission request
    $.ajax({
        url: "acceptpermissions",
        type: "POST",
        data: { id: empId, eprq_status: 'accept', index: index },
        success: function(response) {
            console.log("Accept permission successful");
            alert("Permission Accepted.");
            location.reload();
            // TODO: Handle the success response if needed
        },
        error: function(xhr, status, error) {
            console.log("Accept permission failed");
            // TODO: Handle the error response if needed
        }
    });

}

function rejectPermission(empId, index) {
    console.log("Reject permission for empId: " + empId);

    // Fetch the index for the given empId
    // Make the reject permission request
    $.ajax({
        url: "rejectpermissions",
        type: "POST",
        data: { id: empId, status: 'reject', index: index },
        success: function(response) {
            alert("Permission Rejected.");
            console.log("Reject permission successful");
            // TODO: Handle the success response if needed
            location.reload();
        },
        error: function(xhr, status, error) {
            console.log("Reject permission failed");
            // TODO: Handle the error response if needed
        }
    });
}/**
 * 
 */