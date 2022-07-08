<%--
  Created by IntelliJ IDEA.
  User: hnt16
  Date: 31/05/2021
  Time: 9:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <style>
        .container-fluid {
            width: 700px;
            margin-top: 30px;
        }

        p {
            height: 40px;
            font-size: 25px;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <form method="post" action="/employee?action=edit">
        <div class="row">
            <div class="col-md-12">
                <p class="bg-success text-center">EDIT EMPLOYEE</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <input type="number" class="form-control" id="exampleInputEmail"
                           aria-describedby="emailHelp" name="id" value="${employee.id}" hidden>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword2">Name</label>
                    <input type="text" class="form-control" id="exampleInputPassword" name="name"
                           value="${employee.name}">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail">Position</label>
                    <select name="idPosition">
                        <c:forEach var="type" items="${positions}">
                            <option value="${type.id}" ${type.id==employee.position.id?"selected":""}>${type.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail">Education Degree</label>
                    <select name="idEducation">
                        <c:forEach var="type" items="${educationDegrees}">
                            <option value="${type.id}" ${type.id==employee.educationDegree.id?"selected":""}>${type.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail">Division</label>
                    <select name="idDivision">
                        <c:forEach var="type" items="${divisions}">
                            <option value="${type.id}" ${type.id==employee.division.id?"selected":""}>${type.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword2">Birthday</label>
                    <input type="date" class="form-control" id="exampleInputPassword2" name="birthday"
                           value="${employee.birthday}">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword4">Id Card</label>
                    <input type="text" class="form-control" id="exampleInputPassword4" name="idCard"
                           value="${employee.idCard}">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword5">Salary</label>
                    <input type="number" class="form-control" id="exampleInputPassword5" name="salary"
                           value="${employee.salary}">
                </div>
                <div class=" form-group">
                    <label for="exampleInputPassword6">Phone</label>
                    <input type="text" class="form-control" id="exampleInputPassword6" name="phone"
                           value="${employee.phone}">
                </div>
                <div class=" form-group">
                    <label for="exampleInputPassword7">Email</label>
                    <input type="text" class="form-control" id="exampleInputPassword7" name="email"
                           value="${employee.email}">
                </div>
                <div class=" form-group">

                    <label for="exampleInputPassword8">Address</label>
                    <input type="text" class="form-control" id="exampleInputPassword8" name="address"
                           value="${employee.address}">
                </div>
                <div class=" form-group">
                    <label for="exampleInputPassword8">User Name</label>
                    <input type="text" class="form-control" id="exampleInputPassword9" name="userName"
                           value="${employee.user.name}"
                           required readonly>
                </div>
            </div>
            <div class=" col-md-12">
                <div class="row">
                    <div class="col-md-6 ">
                        <a href="/employee" class="btn btn-primary">Back to menu</a>
                    </div>
                    <div class="col-md-6 d-flex justify-content-end">
                        <button type="submit" class="btn btn-primary">Add Employee</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
        integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
        crossorigin="anonymous"></script>
</body>
</html>
