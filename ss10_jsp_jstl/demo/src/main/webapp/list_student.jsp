<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lehuy
  Date: 5/27/2022
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" width="500px">
    <tr>
        <th>No.</th>
        <th>Code Student</th>
        <th>Name student</th>
        <th>Point student</th>
        <th>Gender Student</th>
    </tr>
    <c:forEach items="${listStudent}" var="student" varStatus="hoang">
    <tr>
        <td>${hoang.count}</td>
        <td>${student.codeStudent}</td>
        <td>${student.nameStudent}</td>
        <td>
            <c:if test="${student.point<5}">bad</c:if>
            <c:if test="${student.point<7}">normal</c:if>
            <c:if test="${student.point<11}">good</c:if>
        </td>
        <td>
            <c:if test="${student.gender ==0}">Male</c:if>
            <c:if test="${student.gender ==1}">Female</c:if>
            <c:if test="${student.gender ==null}">Other</c:if>
        </td>
        </c:forEach>
    </tr>
</table>
</body>
</html>
