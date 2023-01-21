<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>
<h1>Add contract</h1>

<form method="post" action="/rentcar/add-contract.html" enctype="multipart/form-data">
  <!--  Car ID -->
  <div class="mb-3">
  <label for="car.carId">Choose a car id:</label>
     <select class="form-select" id="car.carId" name="car.carId">
       <c:forEach items="${cars}" var="car">
       <option value="${car.carId}">${car.carId}</option>
       </c:forEach>
     </select>
  </div>
  <!--<div class="mb-3">
      <label for="car.carId" class="form-label">Car Id</label>
      <input type="number" name="car.carId" class="form-control" id="car.carId" aria-describedby="nameHelp">
      <div id="nameHelp" class="form-date">Enter car Id</div>
    </div>-->

  <!-- Car received date -->
  <div class="mb-3">
    <label for="receivedDate" class="form-label">Car received date</label>
    <input type="date" name="receivedDate" class="form-control" id="receivedDate" aria-describedby="nameHelp">
    <div id="nameHelp" class="form-date">Enter car received date</div>
  </div>

  <!-- Car return date -->
  <div class="mb-3">
    <label for="returnDate" class="form-label">Car return date</label>
    <input type="date" name="returnDate" class="form-control" id="returnDate" aria-describedby="nameHelp">
    <div id="nameHelp" class="form-date">Enter car return date</div>
  </div>


  <!-- Number of days of rental car -->

  <!-- <div class="mb-3">
      <label for="numberOfDays" class="form-label">Number of days of rental car</label>
      <input type="number" name="numberOfDays" class="form-control" id="numberOfDays" aria-describedby="nameHelp">
      <div id="nameHelp" class="form-date">Enter number of days of rental car</div>
  </div> -->

   <!-- Сar contract status -->

   <label for="contractStatus" class="form-label">Car contract status</label>
   <select name="contractStatus" required="required">
   <option value="">Select a value</option>
   <option type = "text" value="CONFIRMED">CONFIRMED</option>
   <option type = "text" value="NOT_CONFIRMED">NOT_CONFIRMED</option>
   </select>


  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="footer.jsp"/>