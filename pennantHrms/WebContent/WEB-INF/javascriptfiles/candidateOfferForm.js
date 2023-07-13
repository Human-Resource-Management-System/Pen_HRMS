 let componentCount = 0;

    function addComponent() {
      const componentsContainer = document.getElementById('components-container');
      componentCount++;

      const component = document.createElement('div');
      component.className = 'component';
      component.innerHTML = `
        <label for="component-input-${componentCount}"></label>
        <label for="documents">Document:</label>
        <select id="documents" name="documents">
            <c:forEach var="document" items="${listOfDocuments}">
                <c:if test="${document != 'offer letter'}">
                    <option value="${document}">${document}</option>
                </c:if>
            </c:forEach>
        </select>
      `;
      componentsContainer.appendChild(component);
    }
