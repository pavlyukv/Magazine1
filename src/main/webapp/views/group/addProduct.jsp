<%--
  Created by IntelliJ IDEA.
  User: Vasyl.Pavlyuk
  Date: 21.08.2016
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/admin/addProduct?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
    <p>Add Product:</p>
    <input type="text" name="name" placeholder="Name"/><br>
    <input type="text" name="description" placeholder="Description"/><br>
    <input type="number" name="quantity" placeholder="Quantity"/><br>
    <input type="text" name="price" placeholder="Price"/><br>
    <input type="file" name="image">(*.JPG)<br>
    <input type="text" name="id" value="${id}" hidden="true"/>
    <button type="submit">Add</button>
</form>
