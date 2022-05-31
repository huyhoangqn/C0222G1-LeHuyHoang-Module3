<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail student</title>
</head>
<body>
<label>Id: </label>
<c:out value="${student.id}"></c:out><br>
<label>Name: </label>
<c:out value="${student.name}"></c:out><br>
<label>Date of birth: </label>
<c:out value="${student.dateOfBirth}"></c:out><br>
</body>
</html>
