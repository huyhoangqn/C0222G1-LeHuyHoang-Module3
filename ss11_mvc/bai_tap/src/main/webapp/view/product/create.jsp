<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Student</title>
</head>
<body>
<%--Tạo form để đăng ký và gửi dữ liệu về server--%>
<form action="/productServlet" method="post">
    <input type="hidden" name="action"
           value="create"/> <%--name= "action" để thông báo cho server biết yêu cầu create--%>
    <label>Name: </label>
    <input type="text" name="name"><br>
    <label>Price: </label>
    <input type="text" name="price"/><br>
    <label>Description: </label>
    <input type="text" name="description"/><br>
    <label>Manufacturer: </label>
    <input type="text" name="manufacturer"/><br>

    <input type="submit" value="Create"/>
</form>
</body>
</html>
