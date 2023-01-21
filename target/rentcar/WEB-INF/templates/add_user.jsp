<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>
<h1>Registration</h1>

<form method="post" action="/rentcar/add-user.html" enctype="multipart/form-data">
  <!-- user name -->
  <div class="mb-3">
    <label for="username" class="form-label">User name</label>
    <input type="text" name="username" class="form-control" id="username" aria-describedby="nameHelp">
    <div id="nameHelp" class="form-text">Enter you user name</div>
  </div>
  <!-- password -->
  <div class="mb-3">
      <label for="password" class="form-label">Password</label>
      <input type="text" name="password" class="form-control" id="password" aria-describedby="nameHelp">
      <div id="nameHelp" class="form-text">Enter car model</div>
  </div>
    <!-- role -->
  <label for="role" class="form-label">Role of user</label>
  <select name="role" required="required">
    <option value="">Select a value</option>
    <option type = "text" value="USER">USER</option>
  </select>



  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="footer.jsp"/>