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
<body onload="showCreateForm('1')">
<div class="container-fluid">
    <form method="post">
        <div class="row">
            <div class="col-md-12">
                <p class="bg-success text-center">CREATE NEW SERVICE</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label>Type Service</label>
                    <select name="idTypeService" onchange="showCreateForm(event.target.value)">
                        <c:forEach var="type" items="${typeServices}">
                            <option value="${type.id}">${type.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">

                    <input type="number" class="form-control" id="exampleInputEmail"
                           aria-describedby="emailHelp" name="idService" hidden>

                </div>
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" class="form-control" id="nameService" name="nameService">
                </div>
                <div class="form-group">
                    <label>Area Service</label>
                    <input type="number" class="form-control" id="area" name="areaService">
                </div>
                <div class="form-group">
                    <label>Cost</label>
                    <input type="number" class="form-control" id="cost" name="costService">
                </div>
                <div class="form-group">
                    <label>Max People</label>
                    <input type="number" class="form-control" id="maxPeople" name="maxPeopleService">
                </div>
                <div class="form-group">
                    <label>Type Rent</label>
                    <select name="idTypeRent" id="nameRent">
                        <c:forEach var="type" items="${typeRents}">
                            <option value="${type.id}">${type.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label id="standardRoomL">Standard Room</label>
                    <input type="text" class="form-control" id="standardRoom" name="standardRoom">
                </div>
                <div class="form-group">
                    <label id="descriptionL">Description Other Convenience</label>
                    <input type="text" class="form-control" id="description" name="descriptionOtherConvenience">
                </div>
                <div class="form-group">
                    <label id="poolL">Area Pool</label>
                    <input type="text" class="form-control" id="pool" name="areaPool">
                </div>
                <div class="form-group">
                    <label id="floorL">Number Of Floors</label>
                    <input type="text" class="form-control" id="floor" name="numberOfFloors">
                </div>
            </div>
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-6 ">
                        <a href="/service" class="btn btn-primary">Back to menu</a>
                    </div>
                    <div class="col-md-6 d-flex justify-content-end">
                        <button type="submit" class="btn btn-primary">Add Service</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>

<script>

    function showCreateForm(typeCreate) {
        switch (Number.parseInt(typeCreate)) {
            case 1: {
                ['standardRoom', 'description', 'pool', 'floor'].forEach(id => {
                    document.getElementById(id).style.display = 'block';
                    document.getElementById(id + 'L').style.display = 'block';
                });
                break;
            }
            case 3: {
                ['standardRoom', 'description', 'floor'].forEach(id => {
                    document.getElementById(id).style.display = 'block';
                    document.getElementById(id + 'L').style.display = 'block';
                });
                ['pool'].forEach(id => {
                    document.getElementById(id).style.display = 'none';
                    document.getElementById(id + 'L').style.display = 'none';
                    document.getElementById(id).value = null;
                })
                break;
            }
            case 2: {
                ['standardRoom', 'description', 'pool', 'floor'].forEach(id => {
                    document.getElementById(id).style.display = 'none';
                    document.getElementById(id + 'L').style.display = 'none';
                    document.getElementById(id).value = null;
                });
                break;
            }
            default:
                break;
        }
    }
</script>
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
