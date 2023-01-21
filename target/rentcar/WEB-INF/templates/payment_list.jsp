<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>
<h1 align="center">List all payments</h1>

<table style="width:100%" class="table">
  <tr align="center">
    <th>Payment Id</th>
    <th>Contract Id</th>
    <th>Payment creation date</th>
    <th>Payment status</th>
  </tr>
  <c:forEach items="${payments}" var="payment">
  <tr>
    <td align="center"><c:out value="${payment.paymentId}"/></td>
    <td align="center"><c:out value="${payment.contract.contractId}"/></td>
    <td align="center"><c:out value="${payment.createDate}"/></td>
    <td align="center"><c:out value="${payment.paymentStatus}"/></td>
  </tr>
  </c:forEach>

</table>

<jsp:include page="footer.jsp"/>