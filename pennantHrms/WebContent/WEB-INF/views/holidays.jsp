<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@page import="models.Holiday" %>
<%@ page import="java.util.List" %>

<html>
<head>
     <link rel="stylesheet" type="text/css" href="./css/holidays_style.css">
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script src="./js/holidays_javascript.js"></script>

</head>
<body>
<h2>List of Holidays</h2>
<div class="container">
    
    <div class="search-box">
       <input type="text" id="filterInput" placeholder="Search..." onkeyup="filterTable()">

    </div>
    <div class="table-container">
        <table id="dataTable">
            <thead>
                <tr>
                    <th>Year</th>
                    <th>Holiday Date</th>
                    <th>Holiday Title</th>
                    <th>Holiday Type</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<Holiday> holidays = (List<Holiday>) request.getAttribute("holidays");
                if (holidays != null) {
                    for (Holiday holiday : holidays) { %>
                        <tr>
                            <td align="center"><%= holiday.getYear() %></td>
                            <td align="center"><%= holiday.gethday_date() %></td>
                            <td align="center"><%= holiday.gethday_title() %></td>
                            <td align="center"><%= holiday.gethday_type() %></td>
                        </tr>
                    <% }
                } %>
            </tbody>
        </table>
    </div>
</div>


</body>
</html>
