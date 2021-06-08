<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Hệ thống quản lý nhân viên khách sạn</title>
</head>
<body>
<center>
    <h1>Hệ thống quản lý nhân viên khách sạn</h1>
    <h2>
        <a href="/employees?action=create">Thêm mới nhân viên</a>
    </h2>

    <form method="get">
        <input type="hidden" name="action" value="search">
        <input type="text" name="search" value="${key}" placeholder="Nhập nội dung tìm kiếm" style="width: 300px ;height: 30px">
        <input type="submit" value="Tìm kiếm" style="background-color: darkorange ; height: 30px ">
    </form>
    <form method="get">
        <input type="hidden" name="action" value="reset">
        <button class="btn btn-secondary bt" type="submit">Quay lại</button>
    </form>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Danh sách nhân viên</h2></caption>
        <tr>
            <th>Mã nhân viên</th>
            <th>Nhóm nhân viên</th>
            <th>Họ tên</th>
            <th>Giới tính</th>
            <th>Số điện thoại</th>
            <th>Chức năng</th>
        </tr>
        <c:forEach var="employee" items="${listEmployee}">
            <tr>
                <td><c:out value="${employee.id}"/></td>
                <td><c:out value="${employee.staffgroup}"/></td>
                <td><c:out value="${employee.name}"/></td>
                <td><c:out value="${employee.gender}"/></td>
                <td><c:out value="${employee.phone}"/></td>
                <td>
                    <a href="/employees?action=edit&id=${employee.id}">Sửa</a>
                    <a href="/employees?action=delete&id=${employee.id}">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>