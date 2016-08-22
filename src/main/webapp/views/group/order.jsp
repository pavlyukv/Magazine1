<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vasyl.Pavlyuk
  Date: 22.08.2016
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Products in your order:</h2>
<c:forEach items="${products}" var="p">
    <div onclick="window.location.href='/product/${p.id}'" style="height: 130px; width: 170px; text-align: center; background-color: orangered; float: left; margin: 10px; border: 1px double black; border-radius: 10px;">
        <p><b><c:out value="${p.name}"/></b></p>
        <p><b>Price: <c:out value="${p.price} UAH"/></b></p>
    </div>
</c:forEach>

<div style="clear: both"></div>
<p><b>Total: <c:out value="${sum} UAH"/></b></p>
