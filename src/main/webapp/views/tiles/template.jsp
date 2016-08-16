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
        <style>
            span
            {
                color: red;
            }
        </style>
    </head>
    <body style="background-color: lightgray;">
        <div style="background-color: cadetblue;"><tiles:insertAttribute name="header"/></div>
        <div style="background-color: darkkhaki;"><tiles:insertAttribute name="menu"/> </div>
        <div style="background-color: darkseagreen;"><tiles:insertAttribute name="body"/> </div>
        <div style="background-color: dimgray;"><tiles:insertAttribute name="footer"/> </div>
    </body>
</html>
