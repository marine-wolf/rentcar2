<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>
<h1>Add payment</h1>

<form method="post" action="/rentcar/add-payment.html" enctype="multipart/form-data">

  <!--  Contract ID -->

  <div class="mb-3">
  <label for="contract.contractId">Choose a contract id:</label>
     <select class="form-select" id="contract.contractId" name="contract.contractId">
       <c:forEach items="${contracts}" var="contract">
       <option value="${contract.contractId}">${contract.contractId}</option>
       </c:forEach>
     </select>
  </div>

  <!-- Payment creation date -->

  <div class="mb-3">
    <label for="createDate" class="form-label">Payment creation date</label>
    <input type="date" name="createDate" class="form-control" id="createDate" aria-describedby="nameHelp">
    <div id="nameHelp" class="form-date">Enter car payment creation date</div>
  </div>

  <!-- Number of days of rental car -->

    <!-- <div class="mb-3">
     <label for="totalPrice" class="form-label">Number of days of rental car </label>
     <input type="number"  name="totalPrice" class="form-control" id="totalPrice" aria-describedby="nameHelp">
     <div id="nameHelp" class="form-date"></div>
     </div> -->

   <!-- Payment total price -->

   <!-- <div class="mb-3">
   <label for="totalPrice" class="form-label">Payment total price </label>
   <input type="number" name="totalPrice" class="form-control" id="totalPrice" aria-describedby="nameHelp">
   <div id="nameHelp" class="form-date">Enter car payment creation date</div>
   </div> -->

   <!-- Сar contract status -->

   <label for="paymentStatus" class="form-label">Contract payment status</label>
   <select name="paymentStatus" required="required">
   <option value="">Select a value</option>
   <option type = "text" value="PERFORMED">PERFORMED</option>
   <option type = "text" value="NOT_PERFORMED">NOT_PERFORMED</option>
   </select>


  <button type="submit" class="btn btn-primary">Submit</button>
  </form>

<jsp:include page="footer.jsp"/>