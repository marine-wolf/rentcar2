<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Web shop demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body>

<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/rentcar/index.html">Home</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Select action with cars
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/rentcar/car-list.html">List all cars</a></li>
            <li><a class="dropdown-item" href="/rentcar/add-car.html">Add car</a></li>
            <li><a class="dropdown-item" href="/rentcar/delete-car.html">Delete car</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Select action with contracts
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/rentcar/add-contract.html">Add contract</a></li>
            <li><a class="dropdown-item" href="/rentcar/add-payment.html">Add payment</a></li>
            <li><a class="dropdown-item" href="/rentcar/contract-list.html">List all contracts</a></li>
            <li><a class="dropdown-item" href="/rentcar/payment-list.html">List all payments</a></li>
          </ul>
        </li>
     </ul>
      <form class="d-flex" role="search" action="/rentcar/search.do" method="post">
        <input class="form-control me-2" type="search" name="pname" placeholder="Search by producer" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Registration</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Select action with users
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="/rentcar/user-list.html">List all users</a></li>
              <li><a class="dropdown-item" href="/rentcar/add-user.html">Add user</a></li>
              <li><a class="dropdown-item" href="/rentcar/delete-user.html">Delete user</a></li>
            </ul>
          </li>
<%--        </ul>--%>
<%--    </div>--%>
<%--    <div>--%>

      <li class="nav-item">
        <security:authorize access="isAuthenticated()">
          <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
        </security:authorize>
        <security:authorize access="!isAuthenticated()">
          <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
        </security:authorize>
      </li>
      </ul>
      <security:authorize access="isAuthenticated()">
        <a class="nav-link disabled">Welcome&nbsp;<security:authentication property="name"/>&nbsp;</a>
      </security:authorize>
      <security:authorize access="!isAuthenticated()">
        <a class="nav-link disabled">Welcome&nbsp;anonymous</a>
      </security:authorize>


        <!--<li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Select action with contracts
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/rentcar/add-contract.html">Add contract</a></li>
            <li><a class="dropdown-item" href="/rentcar/add-payment.html">Add payment</a></li>
            <li><a class="dropdown-item" href="/rentcar/contract-list.html">List all contracts</a></li>
            <li><a class="dropdown-item" href="/rentcar/payment-list.html">List all payments</a></li>
          </ul>
        </li> -->


<%--      <form class="d-flex" role="search" action="/rentcar/search.do" method="post">--%>
<%--        <input class="form-control me-2" type="search" name="pname" placeholder="Search by producer" aria-label="Search">--%>
<%--        <button class="btn btn-outline-success" type="submit">Search</button>--%>
<%--      </form>--%>

  </div>
  </div>
</nav>