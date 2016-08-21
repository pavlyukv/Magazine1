<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Vasyl.Pavlyuk
  Date: 21.08.2016
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="height: 480px; width: 640px; float: right; background-size: 100%; background-image: url(data:image/jpeg;base64,${product.image64});"></div>
<h2>Product information</h2>
<p>Name: ${product.name}</p>
<p>Price: ${product.price} UAH</p>
<p>Available: ${product.quantity} pcs</p>
<p>Available since: ${product.registrationDate.toString()}</p>
<p>Detailed description: ${product.description}</p>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <form:form method="get" action="/admin/editProduct/${p.id}">
        <button type="submit">Edit</button>
    </form:form>
    <form:form method="get" action="/admin/deleteProduct/${p.id}">
        <button type="submit" onclick="return confirm('Are you sure you want to delete this product?');">Delete</button>
    </form:form>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
    <form:form method="get" action="/cabinet/add/${product.id}">
        <button type="submit">Add to cart</button>
    </form:form>
</sec:authorize>

<div style="clear: both"></div>
