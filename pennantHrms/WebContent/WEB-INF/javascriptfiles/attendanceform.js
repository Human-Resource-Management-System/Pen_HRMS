 $(document).ready(function() {
        $('#uploadForm').submit(function(e) {
            e.preventDefault();

            if (fileInput.files.length === 0) {
                // No file selected, display an error message or perform appropriate action
                $("#uploadStatus").addClass('attend-error-msg').text('Please select a file.');
                return;
            }

            // Show loading indicator
            $('#upload').html('Uploading...');

            var formData = new FormData();
            formData.append('file', $('#fileInput')[0].files[0]);
            $.ajax({
                url: "uploadAttendance",
                type: 'POST',
                data: formData,
                processData: false,
                contentType: false,
                success: function(response) {
                    // Handle success response
                    console.log(response);
                    $('#uploadStatus').removeClass().addClass('attend-success-msg').text('File uploaded successfully.');
                    // Hide loading indicator
                    $('#upload').html('Upload');
                },
                error: function(xhr, status, error) {
                    // Handle error
                    console.log(error);
                    $('#uploadStatus').removeClass().addClass('attend-error-msg').text('Error uploading file.');
                    // Hide loading indicator
                    $('#upload').html('Upload');
                }
            });
        });

        $('#fileInput').on('change', function() {
            var fileName = $(this).val().split('\\').pop();
            $('.file-input-label').text(fileName);
        });

        $('#downloadButton').click(function() {
            // Create a new workbook
            var workbook = XLSX.utils.book_new();

            // Define column names
            var columnNames = ["empl_id", "punchin (DateTime)", "punchout (DateTime)", "punchsystem"];

            // Create a new worksheet
            var worksheet = XLSX.utils.aoa_to_sheet([columnNames]);

            // Add the worksheet to the workbook
            XLSX.utils.book_append_sheet(workbook, worksheet, "EmployeeAttendance");

            // Convert the workbook to a binary Excel file
            var excelData = XLSX.write(workbook, { bookType: 'xlsx', type: 'array' });

            // Create a Blob from the Excel data
            var blob = new Blob([excelData], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });

            // Create a download link
            var downloadLink = document.createElement('a');
            downloadLink.href = URL.createObjectURL(blob);
            downloadLink.download = 'employee_attendance.xlsx';

            // Simulate a click on the download link
            downloadLink.click();

            // Display additional information
            var infoElement = $('#info');
            infoElement.text('The Excel Template file has been generated and is ready for download. Please note that the "punchin" and "punchout" columns represent DateTime values.');
        });
    });
