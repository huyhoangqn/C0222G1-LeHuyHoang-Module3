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
    <form method="post" action="/detail?action=create">
        <div class="row">
            <div class="col-md-12">
                <p class="bg-success text-center">CONTRACT DETAIL</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label for="exampleInputEmail">Id Contract</label>
                    <input type="number" class="form-control" id="exampleInputEmail"
                           aria-describedby="emailHelp" name="idContract" value="${idContract}" required readonly>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail">Attach</label>
                    <select name="idAttach">
                        <c:forEach var="type" items="${attachServices}">
                            <option value="${type.idAttach}">${type.nameAttach}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail">Quantity</label>
                    <input type="number" class="form-control" id="exampleInputEmail1"
                           aria-describedby="emailHelp" name="quantity">
                </div>
            </div>
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-6 ">
                        <a href="/detail?action=list&idContract=${idContract}" class="btn btn-primary">Back to menu</a>
                    </div>
                    <div class="col-md-6 d-flex justify-content-end">
                        <button type="submit" class="btn btn-primary">Add Contract Detail</button>
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
