<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<h1 align="center">Search results:</h1>
<table style="width:100%">
  <tr>
    <!-- <th>Car ID</th> -->
    <th>Producer</th>
    <th>Model</th>
    <th>Color</th>
    <th>Volume Motor</th>
    <th>Photo</th>
  </tr>
  <c:forEach items="${searchResult}" var="car">
  <tr align="center">
    <!-- <td><c:out value="${car.carId}"/></td> -->
    <td><c:out value="${car.producer}"/></td>
    <td><c:out value="${car.model}"/></td>
    <td><c:out value="${car.color}"/></td>
    <td><c:out value="${car.vmotor}"/></td>
    <td><img src="/rentcar/image/${car.carId}/photo.jpg" class="img-thumbnail"></td>
  </tr>
  </c:forEach>
</table>
<h1 align="center">
<a href="/rentcar/car-list.html" button type="button" class="btn btn-link" >Return to all cars</button>
</h1>
</html>