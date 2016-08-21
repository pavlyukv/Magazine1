<%--
  Created by IntelliJ IDEA.
  User: Vasyl.Pavlyuk
  Date: 20.08.2016
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/admin/addGroup?${_csrf.parameterName}=${_csrf.token}" method="post">
    <p>Add Group:</p>
    <input type="text" name="name" placeholder="Name"/><br>
    <input type="text" name="id" value="${id}" hidden="true"/>
    <button type="submit">Add</button>
</form>
