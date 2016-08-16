<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Vasyl.Pavlyuk
  Date: 10.08.2016
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form action="/registration" method="post" modelAttribute="user">
    <p>Please register</p>

    <form:input path="name" placeholder="Name"/>
    <span>*</span><form:errors path="name"/><br>

    <form:input path="secondname" placeholder="Secondname"/><br>

    <form:input path="email" placeholder="E-mail"/>
    <span>*</span><form:errors path="email"/><br>

    <form:input path="phone" placeholder="Phone"/>
    <span>*</span><form:errors path="phone"/><br>

    <form:password path="password" placeholder="Password"/>
    <span>*</span><form:errors path="password"/><br>

    <form:password path="passwordConfirm" placeholder="Confirm Password"/>
    <span>*</span><br>

    <form:button>Register</form:button>
</form:form>
