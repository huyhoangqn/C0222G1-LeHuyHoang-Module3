<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="/studentServlet" method="post">
    <input type="hidden" name="action" value="update"/>   <%--name= "action" để thông báo cho server biết yêu cầu update--%>
    <input type="hidden" name="id" value="${student.id}"/> <%--thông báo cho server biết id này đã tồn tại trong danh sách--%>
    <label>Name: </label>
    <input type="text" name="name" value="${student.name}"><br>
    <label>Date of birth: </label>
    <input type="text" name="dateofBirth" value="${student.dateOfBirth}" /><br>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
