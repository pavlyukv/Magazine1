<%--
  Created by IntelliJ IDEA.
  User: Vasyl.Pavlyuk
  Date: 20.08.2016
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/admin/editGroup?${_csrf.parameterName}=${_csrf.token}" method="post">
    <p>Edit Group:</p>
    <input type="text" name="id" value="${group.id}" hidden="true"/>
    <input type="text" name="name" value="${group.name}" placeholder="Name"/><br>
    <button type="submit">Save</button>
</form>
