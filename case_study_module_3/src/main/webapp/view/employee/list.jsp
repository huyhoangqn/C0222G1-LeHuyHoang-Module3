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
    <h1 class="text-center">NHÂN VIÊN</h1>
    <div class="row">
        <div class="col-lg-12">
            <table id="tableCustomer" class="table table-striped table-bordered" style="width:100%">
                <div class="col-12">
                    <form action="/employee" , method="post">
                        <input type="hidden" name="action" value="search">
                        <div class="row">
                            <div class="col-3 form-group">
                                <label>Tên nhân viên </label>
                                <input type="text" name="name">
                            </div>
                            <div class="form-group col-3">
                                <label>Vị trí </label>
                                <select name="idPosition">
                                    <c:forEach var="type" items="${positions}">
                                        <option value="${type.id}">${type.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-3">
                                <label>Trình độ </label>
                                <select name="idEducation">
                                    <c:forEach var="type" items="${educationDegrees}">
                                        <option value="${type.id}">${type.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-3">
                                <input type="submit" value="Search">
                            </div>
                        </div>
                    </form>
                </div>
                <thead>
                <tr>
                    <th>Mã Nhân Viên</th>
                    <th>Tên Nhân Viên</th>
                    <th>Ngày sinh</th>
                    <th>Số CMND</th>
                    <th>Lương</th>
                    <th>Số Điện Thoại</th>
                    <th>Email</th>
                    <th>Địa chỉ</th>
                    <th>Vị trí</th>
                    <th>Trình Độ</th>
                    <th>Bộ Phận</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="employeeList" items="${employeeList}">
                    <tr>
                        <td>${employeeList.id}</td>
                        <td>${employeeList.name}</td>
                        <td>${employeeList.birthday}</td>
                        <td>${employeeList.idCard}</td>
                        <td>${employeeList.salary}</td>
                        <td>${employeeList.phone}</td>
                        <td>${employeeList.email}</td>
                        <td>${employeeList.address}</td>
                        <td>${employeeList.position.name}</td>
                        <td>${employeeList.educationDegree.name}</td>
                        <td>${employeeList.division.name}</td>

                        <td><a href="employee?action=edit&id=${employeeList.id}">Edit</a></td>
                        <td>
                            <button style="background: white; color: red; border: solid 1px red" type="button"
                                    class="btn btn-primary" data-toggle="modal"
                                    data-target="#q${employeeList.id}">
                                delete
                            </button>
                            <div class="modal fade" id="q${employeeList.id}" tabindex="-1" role="dialog"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Delele Employee</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <span>Do you want delete to this employee?</span>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close
                                            </button>
                                            <a href="employee?action=delete&id=${employeeList.id}">
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
            <a href="/view/employee/create.jsp.jsp">Thêm nhân viên mới</a>
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
