<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">

</head>
<body>
<div class="container-fluid">
    <h1 class="text-center">KHÁCH HÀNG</h1>
    <div class="row">
        <div class="col-lg-12">
            <table id="tableCustomer" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>Mã Khách Hàng</th>
                    <th>Loại Khách Hàng</th>
                    <th>Họ Tên</th>
                    <th>Ngày Sinh</th>
                    <th>Giới Tính</th>
                    <th>Số CMND</th>
                    <th>Số Điện Thoại</th>
                    <th>Email</th>
                    <th>Địa Chỉ</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${customerList}">
                    <tr>
                        <td>${customer.maKhachHang}</td>
                        <td>
                            <c:if test="${customer.maLoaiKhach==1}">Diamond</c:if>
                            <c:if test="${customer.maLoaiKhach==2}">VIP</c:if>
                            <c:if test="${customer.maLoaiKhach==3}">Normal</c:if>
                            <c:if test="${customer.maLoaiKhach==4}">Gold</c:if>
                            <c:if test="${customer.maLoaiKhach==5}">Silver</c:if>
                        </td>
                        <td>${customer.hoTen}</td>
                        <td>${customer.ngaySinh}</td>
                        <td>
                            <c:if test="${customer.gioiTinh==1}">Nam</c:if>
                            <c:if test="${customer.gioiTinh==0}">Nữ</c:if>
                            <c:if test="${customer.gioiTinh==3}">Khác</c:if>
                        </td>
                        <td>${customer.soCMND}</td>
                        <td>${customer.soDienThoai}</td>
                        <td>${customer.email}</td>
                        <td>${customer.diaChi}</td>
                        <td><a href="customer?action=edit&id=${customer.maKhachHang}">Edit</a></td>
                        <td>
                            <button style="background: white; color: red; border: solid 1px red" type="button"
                                    class="btn btn-primary" data-toggle="modal"
                                    data-target="#q${customer.maKhachHang}">
                                delete
                            </button>
                            <div class="modal fade" id="q${customer.maKhachHang}" tabindex="-1" role="dialog"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Delele User</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <span>Do you want delete to this user?</span>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close
                                            </button>
                                            <a href="customer?action=delete&maKhachHang=${customer.maKhachHang}">
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
            <a href="/view/customer/addCustomer.jsp">Thêm mới khách hàng</a>
            <p>${message}</p>
        </div>
    </div>
</div>

<script src="/js/jquery.slim.min.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/bootstrap/dist/js/bootstrap.min.js"></script>

<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').DataTable();
    });
</script>
</body>
</html>