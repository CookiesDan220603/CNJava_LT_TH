<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Danh sách sản phẩm</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #f8f8f8">
<div class="container-fluid p-5">
    <div class="row mb-5">
        <div class="col-md-6">
            <h3>Product Management</h3>
        </div>
        <div class="col-md-6 text-right">
            Xin chào <span class="text-danger">${cookie['username'].value}</span> | <a href="login" id="logout">Logout</a>
        </div>
    </div>
    <div class="row rounded border p-3">
        <div class="col-md-4">
            <h4 class="text-success">Thêm sản phẩm mới</h4>
            <form class="mt-3" method="post" action="product/insert">
                <div class="form-group">
                    <label for="product-name">Tên sản phẩm</label>
                    <input class="form-control" type="text" placeholder="Nhập tên sản phẩm" id="product-name" name="name">
                </div>
                <div class="form-group" >
                    <label for="price">Giá sản phẩm</label>
                    <input class="form-control" type="number" placeholder="Nhập giá bán" id="price" name="numPrice">
                </div>
                <div class="form-group">
                    <button class="btn btn-success mr-2" type="submit">Thêm sản phẩm</button>
                </div>
                <jsp:useBean id="message" scope="request" type="java.lang.String"/>
                <c:if test="${not empty message}">
                    <div class="alert alert-danger">
                            ${message}
                    </div>
                </c:if>
            </form>
        </div>
        <div class="col-md-8">
            <h4 class="text-success">Danh sách sản phẩm</h4>
            <p>Chọn một sản phẩm cụ thể để xem chi tiết</p>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Tên sản phẩm</th>
                    <th>Giá</th>
                    <th>Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <jsp:useBean id="listProducts" scope="request" type="java.util.List"/>
                <c:forEach items="${listProducts}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td><a href="#">${item.name}</a></td>
                    <td>${item.prices} đ</td>
                    <td>
                        <a href="#">Chỉnh sửa</a> |
                        <a href="#" class="delete" id="${item.id}">Xóa</a>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="modal" id="myModal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Xóa sản phẩm</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Bạn có chắc xóa sản phẩm này?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                <button type="button" id="confirmDel" class="btn btn-primary" data-dismiss="modal">Xác nhận</button>
            </div>
        </div>
    </div>
</div>
<script>
    let prodID;
    $(".delete").click(function (){
        prodID = $(this).attr("id");
        $('#myModal').modal({
            backdrop: 'static',
            keyboard: false
        });
    })
    $("#confirmDel").click(function (){
        $.ajax({
            url : 'product',
            method: "get",
            data : {
                prodDelID : prodID
            },
            success : function() {
                location.reload();
            }
        });
    })
</script>
</body>
</html>
