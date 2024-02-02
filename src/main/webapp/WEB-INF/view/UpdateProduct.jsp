<%@ page import="entity.SubCategory" %>
<%@ page import="entity.Statusa" %><%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-01-06
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h1>Edit</h1>
<%
//    Integer subcategoryId = (Integer) request.getAttribute("subcategory");
//    Integer statusId = Integer.parseInt(request.getParameter("status"));
//    System.out.println("Mtam2"+statusId);
%>
<div class="container mt-3">
    <form action="/UpdateProduct?IDEdit=${prd.IDProduct}" method="post">
        <label class="fw-bold" for="Input1">Name</label>
        <input type="text" class="form-control" id="Input1" name="name" value="${prd.nameProduct}">
        <label class="fw-bold" for="Input2">Color</label>
        <input type="text" class="form-control" id="Input2" name="color" value="${prd.color}">
        <label class="fw-bold" for="Input3">Quatily</label>
        <input type="text" class="form-control" id="Input3" name="quality" value="${prd.quality}">
        <label class="fw-bold" for="Input4">Sell price</label>
        <input type="text" class="form-control" id="Input4" name="sellPrice" value="${prd.sellPrice}">
        <label class="fw-bold" for="Input5">Origin price</label>
        <input type="text" class="form-control" id="Input5" name="origiPrice" value="${prd.originPrice}">
        <lable class="fw-bold" id="subcategory">Subcategory</lable>
        <div class="d-flex text-white">
            <select class="form-select" name="subcategory">
<%--                <option value="{prd.subcategory.IDSubCategory}" >${prd.subcategory.nameSubCate}</option>--%>
                <c:forEach items="${listSub}" var="subcategorsy">
                    <option ${prd.subcategory.IDSubCategory} value="${subcategorsy.IDSubCategory}">${subcategorsy.nameSubCate}</option>
                </c:forEach>

            </select>
        </div>
        <lable class="fw-bold" id="status">Status</lable>
        <div class="d-flex text-white">
            <select class="form-select" name="status">
<%--                <option value="{prd.statusa.IDStatus}" >${prd.statusa.nameStatus}</option>--%>
                <c:forEach items="${listS}" var="s">
                    <option value="${s.IDStatus}">${s.nameStatus}</option>
<%--                    <option value="${s.IDStatus}" <%=(statusId.equals("${s.IDStatus}"))?"selected='selected'":"" %> >${s.nameStatus}</option>--%>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-success mt-3">UpdateProduct</button>
        <button class="btn btn-secondary mt-3"><a href="/GetAll">Close</a></button>


    </form>
</div>
</body>
</html>
