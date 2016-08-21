<%--
  Created by IntelliJ IDEA.
  User: Vasyl.Pavlyuk
  Date: 21.08.2016
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/admin/editProduct?${_csrf.parameterName}=${_csrf.token}" method="post">
    <p>Edit Product:</p>
    <input type="text" name="id" value="${product.id}" hidden="true"/>
    <input type="text" name="name" value="${product.name}" placeholder="Name"/><br>
    <input type="text" name="description" value="${product.description}" placeholder="Description"/><br>
    <input type="number" name="quantity" value="${product.quantity}" placeholder="Quantity"/><br>
    <input type="text" name="price" value="${product.price}" placeholder="Price"/><br>
    <button type="submit">Save</button>
</form>
