<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Hệ thống quản lý nhân viên khách sạn</title>
</head>
<body>
<center>
    <h1>Hệ thống quản lý nhân viên khách sạn</h1>
    <h2>
        <a href="employees?action=employees">Danh sách nhân viên</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Thêm mới nhân viên</h2>
            </caption>
            <tr>
                <th>Nhóm nhân viên:</th>
                <td>
<%--                    <select name="staffgroup">--%>
<%--                        <option value="Quản lý hệ thống">Quản lý hệ thống</option>--%>
<%--                        <option value="Quản lý nhân sự">Quản lý nhân sự</option>--%>
<%--                        <option value="Quản lý phòng">Quản lý phòng</option>--%>
<%--                        <option value="Quản lý dịch vụ">Quản lý dịch vụ</option>--%>
<%--                        <option value="Lễ tân">Lễ tân</option>--%>
<%--                        <option value="Nhân viên lao công">Nhân viên lao công</option>--%>
<%--                    </select>--%>
                    <input type="text" name="staffgroup" id="staffgroup" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Họ tên:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Ngày Sinh:</th>
                <td>
                    <input type="text" name="dob" id="dob" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Giới tính</th>:</th>
                <td>
<%--                    <select name="gender">--%>
<%--                        <option value="Nam">Nam</option>--%>
<%--                        <option value="Nữ">Nữ</option>--%>
<%--                    </select>--%>
                    <input type="text" name="gender" id="gender" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Số điện thoại:</th>
                <td>
                    <input type="text" name="phone" id="phone" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Số CMND:</th>
                <td>
                    <input type="text" name="identity" id="identity" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="email" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Địa chỉ:</th>
                <td>
                    <input type="text" name="address" id="address" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Thêm"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>