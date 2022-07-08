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
    <form method="post" action="/product?action=create">
        <div class="row">
            <div class="col-md-12">
                <p class="bg-success text-center">CREATE PRODUCT</p>
            </div>
        </div>
        <c:forEach items="${result}" var="ob">
            <h5 style="${ob.contains("fail")?"color:red":"color:green"}">${ob}</h5>
        </c:forEach>

        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <input type="number" class="form-control" id="exampleInputEmail"
                           aria-describedby="emailHelp" name="id" hidden>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword2">Name</label>
                    <input type="text" class="form-control" id="exampleInputPassword" name="name"
                           value="${product.name}">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword2">Price</label>
                    <input type="number" class="form-control" id="exampleInputPassword2" name="price"
                           value="${product.price}">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword2">Quantity</label>
                    <input type="number" class="form-control" id="exampleInputPassword3" name="quantity"
                           value="${product.quantity}">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword2">Color</label>
                    <input type="text" class="form-control" id="exampleInputPassword5" name="color"
                           value="${product.color}">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword4">Description</label>
                    <textarea rows="10" type="text" class="form-control" id="exampleInputPassword4" name="description"
                              value="${product.description}"></textarea>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail">Category</label>
                    <select name="categoryId" class="form-control">
                        <c:forEach var="category" items="${categories}">
                            <option value="${category.id}" ${category.id==categoryId?"selected":""}>${category.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class=" col-md-12">
                <div class="row">
                    <div class="col-md-6 ">
                        <a href="/product" class="btn btn-primary">Back to menu</a>
                    </div>
                    <div class="col-md-6 d-flex justify-content-end">
                        <button type="submit" class="btn btn-primary">Add Product</button>
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
