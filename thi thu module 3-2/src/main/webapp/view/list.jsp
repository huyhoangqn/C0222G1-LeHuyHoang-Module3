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
                            <a class="nav-link" href="#">Bênh án</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/benhnhan">Bệnh nhân</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
    <div class="col-12 justify-content-center">
        <div class="justify-content-center">
            <h1 >
                DANH SÁCH BỆNH ÁN
            </h1>
        </div>
    </div>
    <div class="content row">
        <div class="col-md-12">
            <table id="studentTable" class="table table-light table-striped">
                <thead>
                <tr>
                    <th scope="col">No.</th>
                    <th scope="col">Mã bệnh án</th>
                    <th scope="col">Mã bệnh nhân</th>
                    <th scope="col">Tên bệnh nhân</th>
                    <th scope="col">Ngày nhập viện</th>
                    <th scope="col">Ngày ra viện</th>
                    <th scope="col">Lý do nhập viện</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="benhnhan" items="${benhnhan}"
                           varStatus="count">
                    <tr>
                        <td>${count.count}</td>
                        <td>${benhnhan.benhAn.maBanhAn}</td>
                        <td>${benhnhan.maBenhNhan}</td>
                        <td>${benhnhan.tenBenhNham}</td>
                        <td><fmt:formatDate type="date" value="${benhnhan.ngayNhap}"/></td>
                        <td><fmt:formatDate type="date" value="${benhnhan.ngayXuat}"/></td>
                        <td>${benhnhan.benhAn.lyDoNhapVien}</td>
                        <td><a href="benhnhan?action=edit&id=${benhnhan.maBenhNhan}">Edit</a></td>
                        <td>
                            <button style="background: white; color: red; border: solid 1px red" type="button"
                                    class="btn btn-primary" data-toggle="modal"
                                    data-target="#q${benhnhan.maBenhNhan}">
                                delete
                            </button>
                            <div class="modal fade" id="q${benhnhan.maBenhNhan}" tabindex="-1" role="dialog"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Delele</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <span>Bạn có muốn xóa bệnh nhân ${benhnhan.tenBenhNham}</span>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close
                                            </button>
                                            <a href="benhnhan?action=delete&id=${benhnhan.maBenhNhan}">
                                                <button style="background: white;color: red; border: 1px solid red "
                                                        type="button" class="btn btn-primary">
                                                    Delete
                                                </button>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
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
            "pageLength": 2
        });
    });
</script>

</body>
</html>
