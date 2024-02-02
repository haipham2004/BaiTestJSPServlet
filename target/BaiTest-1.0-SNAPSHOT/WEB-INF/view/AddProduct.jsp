<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2023-12-29
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddProduct</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
    <%
        String baoLoi=request.getAttribute("baoLoi")+"";
        if(baoLoi.equals("null")){
            baoLoi="";
        }
    %>
    <form action="/AddProduct" method="post">

        <label class="fw-bold" for="Input1">Name</label>
        <input type="text" class="form-control" id="Input1" name="name" required>
        <label class="fw-bold" for="Input2">Color</label>
        <input type="text" class="form-control" id="Input2" name="color" required>
        <label class="fw-bold" for="Input3">Quatily</label>
        <input type="text" class="form-control" id="Input3" name="quality" required>
        <label class="fw-bold" for="Input4">Sell price</label>
        <input type="text" class="form-control" id="Input4" name="sellPrice" required>
        <label class="fw-bold" for="Input5">Origin price</label>
        <input type="text" class="form-control" id="Input5" name="origiPrice" required>
        <lable class="fw-bold" id="subcategory">Subcategory</lable>
        <div class="d-flex text-white">
                <select class="form-select" name="subcategory">
                    <c:forEach items="${listSub}" var="subcategorsy">
                        <option value="${subcategorsy.IDSubCategory}">${subcategorsy.nameSubCate}</option>
                    </c:forEach>
                </select>
        </div>
        <lable class="fw-bold" id="status">Status</lable>
        <div class="d-flex text-white">
                <select class="form-select" name="status">
                    <c:forEach items="${listS}" var="s">
                        <option value="${s.IDStatus}">${s.nameStatus}</option>
                    </c:forEach>
                </select>
        </div>
        <p class="text-danger mt-3"><%=baoLoi%></p>
        <button class="btn btn-success mt-3" type="submit">Add</button>
        <button class="btn btn-secondary mt-3"><a href="/GetAll">Close</a></button>
    </form>
</div>
</body>
</html>
