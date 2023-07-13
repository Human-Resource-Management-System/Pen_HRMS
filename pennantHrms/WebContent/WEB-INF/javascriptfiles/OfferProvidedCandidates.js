 function viewCandidate(candidateId) {
            $.ajax({
                url: 'viewCandidate.jsp', // Replace with the actual URL of your JSP page
                type: 'GET',
                data: { candidateId: candidateId },
                success: function (data) {
                    // Display the response in a modal or a specific section of the page
                    // Example: $('#modal').html(data);
                    // Example: $('#content').html(data);
                    console.log('Candidate data:', data);
                },
                error: function (xhr, status, error) {
                    console.log('Error:', error);
                }
            });
        }

        $(document).ready(function () {
            $("#filterInput").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#dataTable tbody tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
                });
            });
        });