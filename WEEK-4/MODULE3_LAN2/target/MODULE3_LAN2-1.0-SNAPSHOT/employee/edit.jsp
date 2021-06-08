<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Hệ thống quản lý nhân viên</title>
</head>
<body>
<center>
    <h1>Hệ thống quản lý nhân viên</h1>
    <h2>
        <a href="employees?action=employees">Danh sách nhân viên</a>
    </h2>
</center>
<div align="center">
    <form method="post" >
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Chỉnh sửa nhân viên
                </h2>
            </caption>
            <c:if test="${employee != null}">
                <input type="hidden" name="id" value="<c:out value='${employee.id}' />"/>
            </c:if>
            <tr>
                <th>Nhóm nhân viên:</th>
                <td>
                    <input type="text" name="staffgroup" size="45"
                           value="<c:out value='${employee.staffgroup}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Họ tên:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${employee.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Ngày sinh:</th>
                <td>
                    <input type="text" name="dob" size="45"
                           value="<c:out value='${employee.dob}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Giới tính:</th>
                <td>
                    <input type="text" name="gender" size="45"
                           value="<c:out value='${employee.gender}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Số điện thoại:</th>
                <td>
                    <input type="text" name="phone" size="45"
                           value="<c:out value='${employee.phone}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Số CMND:</th>
                <td>
                    <input type="text" name="identity" size="45"
                           value="<c:out value='${employee.identity}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${employee.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Địa chỉ:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${employee.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Cập nhật"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>