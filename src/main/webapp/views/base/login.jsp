<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Vasyl.Pavlyuk
  Date: 10.08.2016
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form action="/loginprocessing" method="post">
    <p>Login with your e-mail or phone</p>

    <input name="username" type="text" placeholder="Login"><br>

    <input name="password" type="password" placeholder="Password"><br>

    <input type="submit" value="Login">
</form:form>
