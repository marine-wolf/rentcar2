<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>
<h1 align="center">List all cars</h1>

<table style="width:100%" class="table">
  <tr align="center">
    <th>Car Id</th>
    <th>Producer</th>
    <th>Model</th>
    <th>Color</th>
    <th>Volume motor</th>
    <th>Price per day</th>
    <th>Photo</th>
  </tr>
  <c:forEach items="${cars}" var="car">
  <tr>
    <td align="center"><a href="/rentcar/car-show/${car.carId}.html">${car.carId}</a></td>
    <td align="center"><c:out value="${car.producer}"/></td>
    <td align="center"><c:out value="${car.model}"/></td>
    <td align="center"><c:out value="${car.color}"/></td>
    <td align="center"><c:out value="${car.vmotor}"/></td>
    <td align="center"><c:out value="${car.pricePerDay}"/></td>
    <td align="center"><img src="/rentcar/image/${car.carId}/photo.jpg" class="img-thumbnail"></td>
  </tr>
  </c:forEach>

</table>

<jsp:include page="footer.jsp"/>