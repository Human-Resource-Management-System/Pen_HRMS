<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="models.input.output.EmployeePayRollOutputModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Payslip</title>
	 <link rel="stylesheet" type="text/css" href="./css/paySlip.css">
    
</head>
<body>
    <h1>Employee Payslip</h1>
    <% EmployeePayRollOutputModel pay = (EmployeePayRollOutputModel) request.getAttribute("output"); %>
    <div class="container">
        <div class="container1">
            <div class="sub-container">
                <h2>Details</h2>
                <p class="details"><strong>Employee ID:</strong> <%= pay.getId() %></p>
                <p class="details"><strong>Employee Name:</strong> <%= pay.getFirstName() + " " + pay.getLastName() %></p>
                <p class="details"><strong>Designation:</strong> <%= pay.getDesignation() %></p>
                <p class="details"><strong>Month:</strong> <%= pay.getMonthYear() %></p>
                <p class="details"><strong>Basic Pay:</strong> <%= pay.getBasicPay() %></p>
                <p class="details"><strong>HRA:</strong> <%= pay.getHra() %></p>
                <p class="details"><strong>TA:</strong> <%= pay.getTa() %></p>
                <p class="details"><strong>DA:</strong> <%= pay.getDa() %></p>
            </div>
            <div class="sub-container">
                <h2>Deductions</h2>
                <p class="deductions"><strong>Gratuity:</strong> <%= pay.getGratuity() %></p>
                <p class="deductions"><strong>ESI:</strong> <%= pay.getEsi() %></p>
                <p class="deductions"><strong>PF:</strong> <%= pay.getPf() %></p>
                <p class="deductions"><strong>PTax:</strong> 200</p>
                <p class="deductions"><strong>TDS:</strong> <%= pay.getTds() %></p>
            </div>
        </div>
        <div class="container2">
            <h2>Pay</h2>
            <p class="pay"><strong>Additions:</strong> <%= pay.getAdditions() %></p>
            <p class="pay"><strong>Total Deductions:</strong> <%= pay.getDeduction() %></p>
            <hr>
            <p class="total"><strong>Total:</strong> <%= pay.getTotal() %></p>
            <p class="netpay"><strong>Net Pay:</strong> <%= pay.getNetpay() %></p>
        </div>
    </div>
    <div class="center-align">
        <button class="button">Print</button>
    </div>
</body>
</html>

