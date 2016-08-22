<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vasyl.Pavlyuk
  Date: 22.08.2016
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Order [ ${id} ] by ${user}</h2>
<p>id ; name ; price</p>
<c:forEach items="${products}" var="p">
    <p>${p.id} ; ${p.name} ; ${p.price}</p>
</c:forEach>
<h2>Total: ${sum}</h2>
