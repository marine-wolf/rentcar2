<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>
<h1 align="center">List all contracts</h1>

<table style="width:100%" class="table">
  <tr align="center">
    <th>Contract Id</th>
    <th>Car Id</th>
    <th>Car received date</th>
    <th>Car return date</th>
    <th>Contract status</th>
  </tr>
  <c:forEach items="${contracts}" var="contract">
  <tr>
    <td align="center"><c:out value="${contract.contractId}"/></td>
    <td align="center"><c:out value="${contract.car.carId}"/></td>
    <td align="center"><c:out value="${contract.receivedDate}"/></td>
    <td align="center"><c:out value="${contract.returnDate}"/></td>
    <td align="center"><c:out value="${contract.contractStatus}"/></td>
  </tr>
  </c:forEach>

</table>

<jsp:include page="footer.jsp"/>