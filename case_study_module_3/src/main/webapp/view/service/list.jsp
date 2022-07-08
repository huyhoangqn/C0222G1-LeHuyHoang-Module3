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
    <h1 class="text-center">DỊCH VỤ </h1>
    <div class="row">
        <div class="col-lg-12">
            <table id="tableCustomer" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>Id Service</th>
                    <th>Name Service</th>
                    <th>Area Service</th>
                    <th>Cost Service</th>
                    <th>Max People Service</th>
                    <th>Type Rent</th>
                    <th>Type Service</th>
                    <th>Standard Room</th>
                    <th>Other Convenient</th>
                    <th>pool Area</th>
                    <th>Floor Number</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="service" items="${serviceList}">
                    <tr>
                        <td>${service.maDichVu}</td>
                        <td>${service.tenDichVu}</td>
                        <td>${service.dienTich}m2</td>
                        <td>${service.chiPhiThue} vnd</td>
                        <td>${service.soNguoiToiDa}</td>
                        <td>${service.maKieuThue.tenKieuThue}</td>
                        <td>${service.maLoaiDichVu.tenLoaiDichVu}</td>
                        <td>${service.tieuChuanPhong}</td>
                        <td>${service.tienNghiKhac}</td>
                        <td>
                            <c:if test="${service.dienTichHoBoi!=null}">${service.dienTichHoBoi} m2</c:if>
                            <c:if test="${service.dienTichHoBoi=null}">Không có thông tin</c:if>
                        </td>
                        <td>
                            <c:if test="${service.soTang!=null}">${service.soTang}</c:if>
                            <c:if test="${service.soTang=null}">Không có thông tin</c:if>
                        </td>
                        <td><a href="customer?action=edit&id=${service.maDichVu}">Edit</a></td>
                        <td>
                            <button style="background: white; color: red; border: solid 1px red" type="button"
                                    class="btn btn-primary" data-toggle="modal"
                                    data-target="#q${service.maDichVu}">
                                delete
                            </button>
                            <div class="modal fade" id="q${service.maDichVu}" tabindex="-1" role="dialog"
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
                                            <a href="customer?action=delete&maKhachHang=${service.maDichVu}">
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
            <a href="/view/customer/addCustomer.jsp">Thêm dịch vụ mới</a>
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