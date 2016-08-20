<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Vasyl.Pavlyuk
  Date: 20.08.2016
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form action="/admin/editGroup" method="post" modelAttribute="group">
    <form:hidden path="id"/>
    <form:input path="name"/>
    <form:button>Save</form:button>
</form:form>
