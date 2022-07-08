<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <style>
        .container-fluid {
            width: 700px;
            margin-top: 5px;

        }

        p {
            height: 40px;
            font-size: 25px;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <form method="post" action="/customer?action=create">
        <div class="row">
            <div class="col-md-12">
                <p class="bg-success text-center">CREATE NEW CUSTOMER</p>
            </div>
        </div>
        <c:forEach items="${errors}" var="error">
            <h5 style="color: red">${error}</h5>
        </c:forEach>
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">

                    <input type="number" class="form-control" id="exampleInputEmail"
                           aria-describedby="emailHelp" name="idCustomer" hidden>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail">Type Customer</label>
                    <select name="typeCustomer">
                        <c:forEach var="type" items="${typeCustomers}">
                            <option value="${type.id}" ${type.id==idTypeCustomer?"selected":""}>${type.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="exampleInputPassword2">Customer Name</label>
                    <input type="text" class="form-control" id="exampleInputPassword2" name="nameCustomer"
                           value="${customer.nameCustomer!=null?customer.nameCustomer:""}">
                </div>

                <div class=" form-group">
                    <label for="exampleInputPassword8">Customer Birthday</label>
                    <input type="date" class="form-control" id="exampleInputPassword8" name="birthdayCustomer"
                           value="${customer.birthdayCustomer!=null?customer.birthdayCustomer:""}">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword4">Customer Id Card</label>
                    <input type="text" class="form-control" id="exampleInputPassword4" name="idCardCustomer"
                           value="${customer.idCardCustomer!=null?customer.idCardCustomer:""}">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword6">Gender</label>
                    <select name="genderCustomer" class="form-control">
                        <option value="0" ${customer.genderCustomer==0?"selected":""}>Nam</option>
                        <option value="1" ${customer.genderCustomer==1?"selected":""}>Nữ</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword5">Customer Phone</label>
                    <input type="text" class="form-control" id="exampleInputPassword5" name="phoneCustomer"
                           value="${customer.phoneCustomer!=null?customer.phoneCustomer:""}">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword6">Customer Email</label>
                    <input type="text" class="form-control" id="exampleInputPassword6" name="emailCustomer"
                           value="${customer.emailCustomer!=null?customer.emailCustomer:""}">
                </div>
                <div class="form-group">

                    <label for="exampleInputPassword7">Customer Address</label>
                    <input type="text" class="form-control" id="exampleInputPassword7" name="addressCustomer"
                           value="${customer.addressCustomer!=null?customer.addressCustomer:""}">
                </div>
            </div>
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-6 ">
                        <a href="/customer" class="btn btn-primary">Back to menu</a>
                    </div>
                    <div class="col-md-6 d-flex justify-content-end">
                        <button type="submit" class="btn btn-primary">Add Customer</button>
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
