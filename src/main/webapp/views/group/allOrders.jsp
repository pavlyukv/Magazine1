<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vasyl.Pavlyuk
  Date: 22.08.2016
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>All orders:</h2>
<c:forEach items="${orders}" var="o">
    <c:if test="${o.ordered}">
        <p><b><a href="/admin/buy/<c:out value="${o.id}"/>">[ <c:out value="${o.id}"/> ]</a> ordered <c:out value="${o.registrationDate}"/> by <c:out value="${o.user}"/></b></p>
    </c:if>
</c:forEach>
