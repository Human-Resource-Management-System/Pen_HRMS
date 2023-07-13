<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload Employee Attendance</title>
<!-- CSS styles -->
	 <link rel="stylesheet" type="text/css" href="./css/attendanceform.css">
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script src="./js/attendanceform.js"></script>
</head>
<body>
    <div class="attendancecontainer">
        <h2>Upload Employee Attendance</h2>
        <form id="uploadForm" enctype="multipart/form-data">
            <div>
                <label for="fileInput" class="form-label">Choose Excel File</label>
                <label for="fileInput" class="file-input-label">Select File</label>
                <input type="file" class="form-control file-input" id="fileInput" accept=".xlsx, .xls">
            </div>
            <button type="submit" id="upload"  class="btn btn-primary download-button">Upload</button>
        </form>
        <div id="uploadStatus"></div>
    </div>

    <div class="download-section attendancecontainer">
        <h2>Need More Info About Excel File? Download The Excel Template File</h2>
        <button id="downloadButton" class="download-button">Download Excel Template</button>
        <div id="info" class="info-message"></div>
    </div>

    <!-- Library to create the excel files  -->
    <script src="https://unpkg.com/xlsx/dist/xlsx.full.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</body>
</html>
