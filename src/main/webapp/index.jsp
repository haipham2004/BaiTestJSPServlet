<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>
<body>
<a href="/SAddProduct">Add</a>
<a href="/GetAll" class="btn bg-success">Load</a>
<div class="container mt-3">
    <h2 class="bg-secondary">Product</h2>
    <div class="card">
        <div class="row">
            <div class="col-3">
                <lable id="name">Name</lable>
                <input type="text" id="name" name="name" value="${prd.IDProduct}">
            </div>
            <div class="col-3">
                <lable id="price">Price</lable>
                <input type="text" id="price" name="price" value="${prd.originPrice}">
            </div>
            <div class="col-3">
                <lable id="subcategory">Subcategory</lable>
                <select name="subcategory">
                    <c:forEach items="${listP}" var ="p">
                        <option value="p.IDProduct">${p.nameProduct}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-3">
                <lable id="status">Status</lable>
                <select name="status">
                    <c:forEach items="${listS}" var ="s">
                        <option value="s.IDStatus">${s.nameStatus}</option>
                    </c:forEach>
                </select>
                <i class="bi bi-search"></i>
            </div>

        </div>

        <div style="margin-top: 20px" >
            <button type="button" class="btn btn-success">
                <a class="text-black" href="/SAddProduct">AddProduct</a>
            </button>
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>No</th>
                <th>Product</th>
                <th>Subcategory</th>
                <th>Price</th>
                <th>Status</th>
                <th>Function</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listP}" var ="p" varStatus="loopStatus">
                <tr>
                    <td>${loopStatus.count}</td>
                    <td>${p.nameProduct}</td>
                    <td>${p.subcategory.nameSubCate}</td>
                    <td>${p.originPrice-p.sellPrice}</td>
                    <td>${p.statusa.nameStatus}</td>
                    <td>
                        <a href="/DetailProduct?IDDetail=${p.IDProduct}"><i class="bi bi-emoji-laughing bi-lg"></i></a>
<%--                        <a href="/DetailProduct?IDDetail=${p.IDProduct}"><i class="bi bi-pencil-square bi-lg"></i></a>--%>
                        <a href="/DeleteProduct?IDDelete=${p.IDProduct}"><i class="bi bi-trash"></i></a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>
</body>
</html>