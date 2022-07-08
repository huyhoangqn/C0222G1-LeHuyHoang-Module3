<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user" method="post">
    <input type="hidden" name="action" value="add">
    <label>Name</label>
    <input type="text" name="name"><br>
    <label>Email</label>
    <input type="text" name="email"><br>
    <label>Country</label>
    <input type="text" name="country"><br>
    <input type="submit" add user>
</form>
</body>
</html>
