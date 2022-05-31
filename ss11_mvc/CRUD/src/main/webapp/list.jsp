<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
<a href="/studentServlet?action=create" style="justify-content: center">Create Student</a> <%--gửi yêu cầu create sang server--%>
<h3 style="justify-content: center">List Student</h3>
<p style="color: green">${message}</p>
<table align="center" border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Date of birth</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach var="student" items="${studentList}">
<%--        "student" là từng phần tử trong studentList--%>
        <tr>
            <td>${student.id}</td>
<%--            Gắn link vào tên học viên khi nhấn vào sẽ qua trang khác để hiển thị--%>
            <td><a href="/studentServlet?action=detail&id=${student.id}">${student.name}</a></td>
            <td>${student.dateOfBirth}</td>
            <td><a href="/studentServlet?action=update&id=${student.id}">Update</a></td>
            <td><a href="/studentServlet?action=delete&id=${student.id}">Delete</a></td>
        </tr>
    </c:forEach>>
</table>
</body>
</html>
