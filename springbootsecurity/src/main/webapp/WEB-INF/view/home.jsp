<%--
  Created by IntelliJ IDEA.
  User: mart
  Date: 16/03/2022
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Martin Securities</title>
</head>
<body>
<h2>Martin Securities Home Page</h2>
<hr>

<p>Welcome to the Securities Company Home Page</p>

<hr>
<!-- Displaying username and role -->
<p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Role(s): <security:authentication property="principal.authorities"/>
</p>

<security:authorize access="hasRole('MANAGER')">

    <!-- Add link to points to /leaders...this is for managers-->
    <p>
        <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
        (Only for Managers)
    </p>

</security:authorize>

<!-- Add a link to points to /systems...this is for admins-->

<security:authorize access="hasRole('ADMIN')">
    <p>
        <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
        (Only for Admin)
    </p>

</security:authorize>


<hr>


<!-- Add logout button -->
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout"/>

</form:form>

</body>
</html>
