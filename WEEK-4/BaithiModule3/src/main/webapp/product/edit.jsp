<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Management Application</title>
</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="products?action=products">List All Products</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Product
                </h2>
            </caption>
            <c:if test="${product != null}">
                <input type="hidden" name="id" value="<c:out value='${product.id}' />"/>
            </c:if>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${product.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="price" size="45"
                           value="<c:out value='${product.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td>
                    <input type="text" name="quantity" size="15"
                           value="<c:out value='${product.quantity}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Color:</th>
                <td>
                    <input type="text" name="color" size="15"
                           value="<c:out value='${product.color}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Describe:</th>
                <td>
                    <input type="text" name="describe" size="15"
                           value="<c:out value='${product.describe}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
<%--                    <input type="text" name="name_category" size="15"--%>
<%--                           value="<c:out value='${product.name_category}' />"--%>
<%--                    />--%>
<%--                    <select id="id_category" name="id_category" class="form-control">--%>
<%--                        <c:forEach items="${category}" var="cat" >--%>
<%--                            <option value=${cat.id_category}>${cat.name_category}</option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>
                    <select name="id_category">
                        <c:forEach var="cat" items="${category}">
                            <c:choose>
                                <c:when test="${product.id_category == cat.id_category}">
                                    <option value="${cat.id_category}" selected>${cat.name_category}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${cat.id_category}">${cat.name_category}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>