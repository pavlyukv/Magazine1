<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: Vasyl.Pavlyuk
  Date: 10.08.2016
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>My First Web Shop</title>
    </head>
    <body>
        <div><tiles:insertAttribute name="header"/></div>
        <div><tiles:insertAttribute name="menu"/> </div>
        <div><tiles:insertAttribute name="body"/> </div>
        <div><tiles:insertAttribute name="footer"/> </div>
    </body>
</html>
