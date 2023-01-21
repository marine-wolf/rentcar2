<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>
<h1>Delete a car by Id</h1>

<form method="post" action="/rentcar/delete-car.html" enctype="multipart/form-data">
  <!-- car id -->
  <div class="mb-3">
    <label for="carId" class="form-label">Car Id</label>
    <input type="number" name="carId" class="form-control" id="carId" aria-describedby="nameHelp">
    <div id="nameHelp" class="form-text">Enter car Id</div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="footer.jsp"/>