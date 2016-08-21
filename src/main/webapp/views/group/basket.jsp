<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Vasyl.Pavlyuk
  Date: 21.08.2016
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Products in your basket:</h2>
<c:forEach items="${products}" var="p">
    <div onclick="window.location.href='/product/${p.id}'" style="height: 130px; width: 170px; text-align: center; background-color: orangered; float: left; margin: 10px; border: 1px double black; border-radius: 10px;">
        <p><b><c:out value="${p.name}"/></b></p>
        <p><b>Price: <c:out value="${p.price} UAH"/></b></p>
        <form:form method="get" action="/cabinet/remove/${p.id}">
            <button type="submit">Remove</button>
        </form:form>
    </div>
</c:forEach>

<div style="clear: both"></div>
<p><b>Total: <c:out value="${sum} UAH"/></b></p>
<form:form method="get" action="/cabinet/clear">
    <button type="submit">Clear all</button>
</form:form>
<form:form method="get" action="/cabinet/buy">
    <button type="submit">Order\Buy</button>
</form:form>
