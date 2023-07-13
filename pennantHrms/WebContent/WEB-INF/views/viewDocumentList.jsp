<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
    }

    h1 {
      font-size: 24px;
      margin-bottom: 10px;
    }

    .category {
      margin-bottom: 20px;
    }

    .category-title {
      font-weight: bold;
      font-size: 20px;
      margin-bottom: 10px;
    }

    .document {
      display: flex;
      align-items: center;
      margin-bottom: 10px;
    }

    .document-name {
      margin-right: 10px;
    }

    .document-link {
      color: blue;
      text-decoration: underline;
      cursor: pointer;
    }

    .add-button {
      margin-top: 20px;
    }
  </style>
</head>
<body>
  <h1>Reference Documents</h1>

  <div class="category-select">
    <label for="category">Select Category:</label>
    <select id="category" name="category" onchange="filterDocumentsByCategory()">
      <option value="all">All Categories</option>
      <option value="employee-handbook">Employee Handbook</option>
      <option value="code-of-conduct">Code of Conduct</option>
      <!-- Add more category options here -->
    </select>
  </div>

  <!-- Iterate over the list of documents -->
  <c:forEach items="${documents}" var="document">
    <div class="category">
      <div class="category-title">${document.getCategory()}</div>
      <div class="document" id="${document.getId()}">
        <div class="document-name">${document.getDocName()}</div><br>
        <div class="document-link" onclick="openDocument('${document.getPath()}')">View</div>&nbsp;&nbsp;
		<div class="document-link" onclick="deleteDocument('${document.getId()}')">Delete</div>
      </div>
    </div>
  </c:forEach>

  <div class="add-button">
    <a href="/UploadReferenceDocument">Add Document</a>
  </div>

  <script>
    function filterDocumentsByCategory() {
      const categorySelect = document.getElementById('category');
      const selectedCategory = categorySelect.value;
      // Hide all categories
      const categories = document.getElementsByClassName('category');
      for (let i = 0; i < categories.length; i++) {
        categories[i].style.display = 'none';
      }
      // Show the selected category or all categories if "All Categories" is selected
      if (selectedCategory === 'all') {
        for (let i = 0; i < categories.length; i++) {
          categories[i].style.display = 'block';
        }
      } else {
        const selectedCategoryElement = document.getElementById(selectedCategory);
        if (selectedCategoryElement) {
          selectedCategoryElement.style.display = 'block';
        }
      }
    }

    function openDocument(documentPath) {
      // Replace with your logic to open the document
      console.log('Opening document:', documentPath);
      window.location.href = "/viewDocument?path=" + encodeURIComponent(documentPath);
    }

    function deleteDocument(documentId) {
        const documentElement = document.getElementById(documentId);// Find the document element to be removed
        if (documentElement) {
          documentElement.remove();    // Remove the document element from the DOM
          refreshPage();
        }
    }
    
    function refreshPage() {	
    	  location.reload();  // Reload the current page
    	}
  </script>
</body>
</html>
