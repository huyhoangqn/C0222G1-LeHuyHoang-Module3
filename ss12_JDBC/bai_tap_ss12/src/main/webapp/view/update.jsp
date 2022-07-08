<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user" method="post">
    <input type="hidden" name="action" value="edit">
    <label>Id</label>
    <input type="text" name="id" value="${update.id}" readonly><br>
    <label>Name</label>
    <input type="text" name="name" value="${update.name}"><br>
    <label>Email</label>
    <input type="text" name="email" value="${update.email}" ><br>
    <label>Country</label>
    <input type="text" name="country" value="${update.country}"><br>
    <input type="submit" value="Update">
</form>
</body>
</html>
