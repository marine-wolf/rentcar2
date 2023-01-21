%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<h1 align="center">Contract search results:</h1>
<table style="width:100%">
  <tr>
    <th>ID</th>
    <th>Received date</th>
    <th>Return date</th>
    <th>Contract status</th>
  </tr>
  <c:forEach items="${contractSearchResult}" var="contract">
  <tr align="center">
    <!-- <td><c:out value="${contract.id}"/></td> -->
    <td><c:out value="${contract.receivedDate}"/></td>
    <td><c:out value="${contract.returnDate}"/></td>
    <td><c:out value="${contract.contractStatus}"/></td>
  </tr>
  </c:forEach>
</table>
<h1 align="center">
<a href="/rentcar/contract-list.html" button type="button" class="btn btn-link" >Return to all contracts</button>
</h1>
</html>