<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Vasyl.Pavlyuk
  Date: 10.08.2016
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1 style="text-align: center; color: white;">Welcome to my first web shop</h1>
<div>
    <sec:authorize access="isAnonymous()">
        <form:form method="get" action="/loginpage">
            <button type="submit">Login</button>
        </form:form>
    </sec:authorize>

    <sec:authorize access="isAnonymous()">
        <form:form method="get" action="/registration">
            <button type="submit">Register</button>
        </form:form>
    </sec:authorize>

    <sec:authorize access="hasRole('ROLE_USER')">
        Hello, <sec:authentication property="name"/>
        <form:form method="get" action="/cabinet">
            <button type="submit">Cabinet</button>
        </form:form>
    </sec:authorize>

    <sec:authorize access="hasRole('ROLE_ADMIN')">
        Hello, <sec:authentication property="name"/>
        <form:form method="get" action="/admin">
            <button type="submit">Admin</button>
        </form:form>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
    <form:form method="post" action="/logout">
        <button type="submit">Logout</button>
    </form:form>
    </sec:authorize>
</div>
