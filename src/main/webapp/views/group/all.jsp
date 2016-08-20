<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Vasyl.Pavlyuk
  Date: 20.08.2016
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <form:form method="get" action="/admin/addGroup">
        <button type="submit">Add Group</button>
    </form:form>
</sec:authorize>

<p>Category: <c:out value="${group.name}"/></p>
<p>Choose category or product to display</p>

<c:forEach items="${groups}" var="g">
    <div onclick="window.location.href='/group/${g.id}'" style="height: 120px; width: 160px; text-align: center; background-color: gold; float: left; margin: 10px; border: 1px double black; border-radius: 10px;")>
        <p>${g.name}</p>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <form:form method="get" action="/admin/editGroup/${g.id}">
                <button type="submit">Edit</button>
            </form:form>
            <form:form method="get" action="/admin/deleteGroup/${g.id}">
                <button type="submit">Delete</button>
            </form:form>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_USER')">
            <form:form method="get" action="/group/${g.id}">
                <button type="submit">View</button>
            </form:form>
        </sec:authorize>
    </div>
</c:forEach>

<div style="clear: both"></div>
