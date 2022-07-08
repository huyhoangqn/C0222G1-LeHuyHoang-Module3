<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <link rel="stylesheet" href="/bootstrap/dist/css/bootstrap.min.css">
</head>
<body>
<section id="backgr" class="h-auto h-custom">
    <h1 class="px-5 py-5"><a style="color: black;text-decoration: none" href="/index.jsp">HOME</a></h1>
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-8 col-xl-6">
                <div class="card rounded-3">
                    <img src="${pageContext.request.contextPath}/img/FURAMA.jpg"
                         class="w-100" style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
                         alt="Sample photo">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Đăng ký thông tin khách hàng</h3>
                        <form class="px-md-2" action="/customer" method="post">
                            <input type="hidden" name="action" value="update">
                            <div class="form-outline mb-4">
                                <input type="hidden" id="form3Example1qph" name="maKhachHang"
                                       value="${customer.maKhachHang}" class="form-control"/>
                                <label class="form-label" for="form3Example1q">Mã Khách Hàng</label>
                            </div>
                            <div class="form-outline mb-4">
                                <input type="text" id="form3Example1q" name="tenKhachHang" value="${customer.hoTen}"
                                       class="form-control"/>
                                <label class="form-label" for="form3Example1q">Tên Khách Hàng</label>
                            </div>
                            <div class="row">
                                <div class="col-md-4 mb-4">
                                    <select class="select" name="maLoaiKhach" value="${customer.maLoaiKhach}">
                                        <option value="1" ${customer.maLoaiKhach==1?"selected":""}>Diamond</option>
                                        <option value="2" ${customer.maLoaiKhach==2?"selected":""}>Vip</option>
                                        <option value="3" ${customer.maLoaiKhach==3?"selected":""}>Normal</option>
                                        <option value="4" ${customer.maLoaiKhach==4?"selected":""}>Gold</option>
                                        <option value="5" ${customer.maLoaiKhach==5?"selected":""}>Silver</option>
                                    </select>
                                    <div class="pt-1">Loại Khách</div>
                                </div>
                                <div class="col-md-4">
                                </div>
                                <div class="col-md-4 mb-4 pl-5">
                                    <select class="select" name="gioiTinh" value="${customer.gioiTinh} ">
                                        <option value="1" ${customer.gioiTinh==1?"selected":""} >Nam</option>
                                        <option value="0" ${customer.gioiTinh==0?"selected":""} >Nữ</option>
                                        <option value="3" ${customer.gioiTinh==3?"selected":""} >Khác</option>
                                    </select>
                                    <div class="pt-1">Ngày sinh</div>
                                </div>
                            </div>
                            <div class="mb-4">
                                <input type="date" id="namSinh" name="ngaySinh" value="${customer.ngaySinh}"
                                       class="form-control"/>
                                <label class="form-label" for="namSinh">Ngày sinh</label>
                            </div>
                            <div class="mb-4">
                                <input type="text" id="soCMND" name="soCMND" value="${customer.soCMND}"
                                       class="form-control"/>
                                <label class="form-label" for="soCMND">Số chứng minh nhân dân </label>
                            </div>

                            <div class="mb-4">
                                <input type="text" id="soDT" name="soDT" value="${customer.soDienThoai}"
                                       class="form-control"/>
                                <label class="form-label" for="soDT">Số điện thoại </label>
                            </div>
                            <div class="mb-4">
                                <input type="email" id="email" name="email" value="${customer.email}"
                                       class="form-control"/>
                                <label class="form-label" for="email">Email </label>
                            </div>
                            <div class="mb-4">
                                <input type="text" id="diaChi" name="diaChi" value="${customer.diaChi}"
                                       class="form-control"/>
                                <label class="form-label" for="diaChi">Địa chỉ</label>
                            </div>
                            <button type="submit" class="btn btn-success btn-lg mb-1">Gửi</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
<script src="/js/jquery.slim.min.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/bootstrap/dist/js/bootstrap.min.js"></script>
</html>
