<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>
<h1>Delete a car by Id</h1>

<form method="post" action="/rentcar/delete-car.html" enctype="multipart/form-data">

  <div class="mb-3">
    <label for="carId">Choose a car id:</label>
    <select class="form-select" id="carId" name="carId">
      <c:forEach items="${cars}" var="car">
        <option value="${car.carId}">${car.carId}</option>
      </c:forEach>
    </select>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="footer.jsp"/>