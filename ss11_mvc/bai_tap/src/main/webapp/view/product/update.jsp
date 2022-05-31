<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="/productServlet" method="post">
    <input type="hidden" name="action" value="update"/>   <%--name= "action" để thông báo cho server biết yêu cầu update--%>
    <input type="hidden" name="id" value="${product.id}"/> <%--thông báo cho server biết id này đã tồn tại trong danh sách--%>
    <label>Name: </label>
    <input type="text" name="name" value="${product.name}"><br>
    <label>price: </label>
    <input type="text" name="price" value="${product.price}" /><br>
    <label>price: </label>
    <input type="text" name="description" value="${product.description}" /><br>
    <label>price: </label>
    <input type="text" name="manufacturer" value="${product.manufacturer}" /><br>

    <input type="submit" value="Update"/>
</form>
</body>
</html>
