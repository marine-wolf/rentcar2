<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>
<h1 align="center">Car info</h1>

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

  <tr>
    <td align="center"><c:out value="${car.carId}"/></td>
    <td align="center"><c:out value="${car.producer}"/></td>
    <td align="center"><c:out value="${car.model}"/></td>
    <td align="center"><c:out value="${car.color}"/></td>
    <td align="center"><c:out value="${car.vmotor}"/></td>
    <td align="center"><c:out value="${car.pricePerDay}"/></td>
   <td align="center"><img src="/rentcar/image/${cars.carId}/photo.jpg" class="img-thumbnail"></td>
  </tr>

</table>
<jsp:include page="footer.jsp"/>