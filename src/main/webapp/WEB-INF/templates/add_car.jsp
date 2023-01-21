<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>
<h1>Add a car</h1>

<form method="post" action="/rentcar/add-car.html" enctype="multipart/form-data">
  <!-- car producer -->
  <div class="mb-3">
    <label for="producer" class="form-label">Producer</label>
    <input type="text" name="producer" class="form-control" id="producer" aria-describedby="nameHelp">
    <div id="nameHelp" class="form-text">Enter car producer</div>
  </div>
  <!-- car model -->
  <div class="mb-3">
      <label for="model" class="form-label">Model</label>
      <input type="text" name="model" class="form-control" id="model" aria-describedby="nameHelp">
      <div id="nameHelp" class="form-text">Enter car model</div>
    </div>
    <!-- color car -->
  <div class="mb-3">
    <label for="color" class="form-label">Color</label>
    <input type="text" name="color" class="form-control" id="color">
    <div id="nameHelp" class="form-text">Enter car color</div>
  </div>
  <!-- volume motor -->
  <div class="mb-3">
      <label for="vmotor" class="form-label">Volume motor</label>
      <input type="text" name="vmotor" class="form-control" id="vmotor">
      <div id="nameHelp" class="form-text">Enter car volume motor</div>
  </div>

<!-- price per day -->
  <div class="mb-3">
      <label for="pricePerDay" class="form-label">Price Per Day</label>
      <input type="number" step="0.1" value="0" name="pricePerDay" class="form-control" id="pricePerDay">
      <div id="nameHelp" class="form-text">Enter price per day</div>
  </div>

  <!-- photo -->
  <div class="mb-3">
      <label for="photo" class="form-label">Car photo</label>
      <input type="file" name="photo" class="form-control" id="photo">
  </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="footer.jsp"/>