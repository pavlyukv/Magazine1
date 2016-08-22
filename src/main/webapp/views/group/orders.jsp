<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vasyl.Pavlyuk
  Date: 22.08.2016
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>All your orders:</h2>
<c:forEach items="${orders}" var="o">
        <p><b><a href="/cabinet/order/<c:out value="${o.id}"/>">[ <c:out value="${o.id}"/> ]</a> ordered <c:out value="${o.registrationDate}"/></b></p>
</c:forEach>
