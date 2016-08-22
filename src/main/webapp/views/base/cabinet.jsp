<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Vasyl.Pavlyuk
  Date: 16.08.2016
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Personal information</h2>
<p>Name: ${user.name}</p>
<p>Secondname: ${user.secondname}</p>
<p>E-mail: ${user.email}</p>
<p>Phone: ${user.phone}</p>
<p>Registration date: ${user.registrationDate.toString()}</p>

<%--TODO button "Edit"--%>

<form:form method="get" action="/cabinet/basket">
    <button type="submit">Basket</button>
</form:form>
<form:form method="get" action="/cabinet/orders">
    <button type="submit">All orders</button>
</form:form>
