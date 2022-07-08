<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <style>
        .myheader {
            height: 10vh !important;
        }

        .content {
            height: 80vh !important;
            margin-top: 14px !important;
        }

        .footer {
            height: 6vh !important;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="myheader row" style="padding-bottom: 0px!important;">
        <div class="col-md-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <img src="https://phuongviethcm.com/wp-content/uploads/2019/07/FURAMA.png"
                     class="circular rounded mx-auto d-block" alt="..." style="width: 40px">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="/home">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/product">Product</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/category">Category</a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0" method="get">
                        <label>Vị trí </label>
                        <select name="idCategory">
                            <option value="">Choose</option>
                            <c:forEach var="item" items="${category}">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                        <input class="form-control mr-sm-2" type="text" placeholder="Name" aria-label="Search"
                               name="name">
                        <input type="text" name="action" value="search" hidden>
                        <input class="form-control mr-sm-2" type="text" placeholder="Color" aria-label="Search"
                               name="color">
                        <input type="text" name="action" value="search" hidden>
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>
    </div>
    <div>
        <div class="col-md-2">
            <div class="list-group ">
                <a href="/product?action=create"
                   class="list-group-item list-group-item-action d-flex justify-content-center">
                    Create new Product
                </a>
            </div>
        </div>
    </div>
    <div class="content row">
        <div class="col-md-12">
            <table id="studentTable" class="table table-light table-striped">
                <thead>
                <tr>
                    <th scope="col">No.</th>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Color</th>
                    <th scope="col">Description</th>
                    <th scope="col">Category</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${products}"
                           varStatus="count"> <%--products: danh sách nhận từ server, product: đại điện cho từng đối tượng--%>
                    <tr>
                        <td>${count.count}</td>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td><fmt:formatNumber type="number" value="${product.price}"/></td>
                        <td>${product.quantity}</td>
                        <td>${product.color}</td>
                        <td>${product.description}</td>
                        <td>${product.category.name}</td>
                        <td><a href="product?action=edit&id=${product.id}">Edit</a></td>
                        <td>
                            <button onclick="showModal(${product.id},'${product.name}')">
                                Delete
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="footer row  align-items-center bg-success mt-2">
    <div class="col-md-12 d-flex justify-content-center">
        Copy right huyhoangCo
    </div>
</div>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Confirm</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" id="contentModal">
            </div>
            <div class="modal-footer">
                <a id="hrefDelete" type="button" class="btn btn-primary">OK</a>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
            </div>
        </div>
    </div>
</div>
<script>
    function showModal(id, name) {
        document.getElementById("hrefDelete").href = "?action=delete&id=" + id;
        document.getElementById("contentModal").innerText = "Are you sure to delete : " + name + " ?";
        var myModal = new bootstrap.Modal(document.getElementById('exampleModal'), null)
        myModal.show();
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
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#studentTable').dataTable({
            "dom": "lrtip",
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>

</body>
</html>
