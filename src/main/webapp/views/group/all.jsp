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
    <form:form method="get" action="/admin/addGroup/${group.id}">
        <button type="submit">Add Group</button>
    </form:form>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <form:form method="get" action="/admin/addProduct/${group.id}">
        <button type="submit">Add Product</button>
    </form:form>
</sec:authorize>

<p><b><c:out value="${group.name}"/></b></p>
<p>Choose category or product to display</p>

<c:forEach items="${groups}" var="g">
    <div onclick="window.location.href='/group/${g.id}'" style="height: 120px; width: 160px; text-align: center; background-color: gold; float: left; margin: 10px; border: 1px double black; border-radius: 10px;")>
        <p><c:out value="${g.name}"/></p>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <form:form method="get" action="/admin/editGroup/${g.id}">
                <button type="submit">Edit</button>
            </form:form>
            <form:form method="get" action="/admin/deleteGroup/${g.id}">
                <button type="submit" onclick="return confirm('Are you sure you want to delete this group?');">Delete</button>
            </form:form>
        </sec:authorize>
    </div>
</c:forEach>

<div style="clear: both"></div>

<c:forEach items="${products}" var="p">
    <div onclick="window.location.href='/product/${p.id}'" style="height: 260px; width: 340px; text-align: center; background-color: orangered; float: left; margin: 10px; border: 1px double black; border-radius: 10px; background-size: 100%; background-image: url(data:image/jpeg;base64,${p.image64});">
        <p><b><c:out value="${p.name}"/></b></p>
        <p><b>Price: <c:out value="${p.price} UAH"/></b></p>
        <p><b>Available: <c:out value="${p.quantity}"/> pcs</b></p>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <form:form method="get" action="/admin/editProduct/${p.id}">
                <button type="submit">Edit</button>
            </form:form>
            <form:form method="get" action="/admin/deleteProduct/${p.id}">
                <button type="submit" onclick="return confirm('Are you sure you want to delete this product?');">Delete</button>
            </form:form>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_USER')">
            <form:form method="get" action="/cabinet/add/${p.id}">
                <button type="submit">Add to cart</button>
            </form:form>
        </sec:authorize>
    </div>
</c:forEach>

<div style="clear: both"></div>
