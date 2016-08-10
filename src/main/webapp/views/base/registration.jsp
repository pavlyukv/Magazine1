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
    <form:errors path="name"/>
    <form:input path="name" placeholder="Name"/>
    <form:input path="secondname" placeholder="Secondname"/>
    <form:errors path="email"/>
    <form:input path="email" placeholder="E-mail"/>
    <form:input path="phone" placeholder="Phone"/>
    <form:errors path="password"/>
    <form:password path="password" placeholder="Password"/>
    <form:password path="passwordConfirm" placeholder="Confirm Password"/>
    <form:button>Register</form:button>
</form:form>
