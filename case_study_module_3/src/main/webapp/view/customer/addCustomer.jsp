<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/bootstrap/dist/css/bootstrap.min.css">
    <style>
        #backgr {
            background-image: url('/img/backgr.jpg');
            width: 100%;
            height: auto;
        }
    </style>
</head>
<body>
<section id="backgr" class="h-auto h-custom">
    <h1 class="px-5 py-5"><a style="color: black;text-decoration: none" href="/index.jsp">HOME</a></h1>
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-8 col-xl-6">
                <div class="card rounded-3">
                    <img src="/img/FURAMA.jpg"
                         class="w-100" style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
                         alt="Sample photo">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Đăng ký thông tin khách hàng</h3>
                        <c:forEach items="${errors}" var="error">
                            <h5 style="color: red">${error}</h5>
                        </c:forEach>
                        <form class="px-md-2" action="/customer" method="post">
                            <input type="hidden" name="action" value="add">
                            <div class="form-outline mb-4">
                                <input type="text" id="form3Example1q" name="tenKhachHang" class="form-control"/>
                                <label class="form-label" for="form3Example1q">Tên Khách Hàng</label>
                            </div>
                            <div class="row">
                                <div class="col-md-4 mb-4">
                                    <select class="select" name="maLoaiKhach">
                                        <option value="1">Diamond</option>
                                        <option value="2">Vip</option>
                                        <option value="3">Normal</option>
                                        <option value="4">Gold</option>
                                        <option value="4">Silver</option>
                                    </select>
                                    <div class="pt-1">Loại Khách</div>
                                </div>
                                <div class="col-md-4">

                                </div>
                                <div class="col-md-4 mb-4 pl-5">
                                    <select class="select" name="gioiTinh">
                                        <option value="1">Nam</option>
                                        <option value="0">Nữ</option>
                                        <option value="3">Khác</option>
                                    </select>
                                    <div class="pt-1">Ngày sinh</div>
                                </div>
                            </div>
                            <div class="mb-4">
                                <input type="date" id="namSinh" name="ngaySinh" class="form-control"/>
                                <label class="form-label" for="namSinh">Ngày sinh</label>
                            </div>
                            <div class="mb-4">
                                <input type="text" id="soCMND" name="soCMND" class="form-control"/>
                                <label class="form-label" for="soCMND">Số chứng minh nhân dân </label>
                            </div>

                            <div class="mb-4">
                                <input type="text" id="soDT" name="soDT" class="form-control"/>
                                <label class="form-label" for="soDT">Số điện thoại </label>
                            </div>
                            <div class="mb-4">
                                <input type="email" id="email" name="email" class="form-control"/>
                                <label class="form-label" for="email">Email </label>
                            </div>
                            <div class="mb-4">
                                <input type="text" id="diaChi" name="diaChi" class="form-control"/>
                                <label class="form-label" for="diaChi">Địa chỉ</label>
                            </div>
                            <button type="submit" class="btn btn-success btn-lg mb-1">Đăng ký</button>
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
