<%--
  Created by IntelliJ IDEA.
  User: lehuy
  Date: 5/30/2022
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Student</title>
</head>
<body>
<%--Tạo form để đăng ký và gửi dữ liệu về server--%>
<form action="/studentServlet" method="post">
    <input type="hidden" name="action" value="create"/>   name= "action" để thông báo cho server biết yêu cầu create
    <label>Name: </label>
    <input type="text" name="name"><br>
    <label>Date of birth: </label>
    <input type="text" name="dateofBirth"/><br>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
