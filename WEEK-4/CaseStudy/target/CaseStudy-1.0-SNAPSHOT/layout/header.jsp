<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-light fixed-top bg-light">
    <div class="container-fluid">
        <a href="index.jsp"><img class="logo-img" src="Home/images/logostorequang.png" alt="#"></a>
        <form class="d-flex">
            <div>
                <c:if test="${sessionScope.acc.isAdmin == 1}">
                    <span class="menu_iconb">
                        <a href="account">Manager Account</a>
                    </span>
                </c:if>
                <c:if test="${sessionScope.acc.isSell == 1}">
                    <span class="menu_iconb">
                        <a href="home">Manager Product</a>
                    </span>
                </c:if>
                <c:if test="${sessionScope.acc == null}">
                    <span class="menu_iconb">
                        <a href="login.jsp">Log in</a>
                    </span>
                    <span class="menu_iconb">
                        <a href="signup.jsp">Sign up</a>
                    </span>
                </c:if>
                <c:if test="${sessionScope.acc != null}">
                    <span class="menu_iconb">
                        Hello <c:out value="${sessionScope.acc.username}"></c:out>
                    </span>
                    <span class="menu_iconb">
                        <a href="logout">Log out</a>
                    </span>
                </c:if>
                <span class="tytyu">
                    <a href="cart.jsp"><i class="fas fa-cart-arrow-down"></i></a>
                </span>
                <span class="menu_iconb">
                    <a href="#"></a>
                </span>

                <span>
                    <button type="button" id="sidebarCollapse">
                        <i class="fas fa-align-justify"></i>
                    </button>
                </span>
            </div>

<%--            <ul>--%>
<%--                <c:if test="${sessionScope.acc.isAdmin == 1}">--%>
<%--                    <li class="menu_iconb">--%>
<%--                        <a href="account">Manager Account</a>--%>
<%--                    </li>--%>
<%--                </c:if>--%>
<%--                <c:if test="${sessionScope.acc.isSell == 1}">&ndash;%&gt;--%>
<%--                    <li class="menu_iconb">--%>
<%--                        <a href="home">Manager Product</a>--%>
<%--                    </li>--%>
<%--                </c:if>--%>
<%--                <c:if test="${sessionScope.acc == null}">--%>
<%--                    <li class="menu_iconb">--%>
<%--                        <a href="login.jsp">Log in</a>--%>
<%--                    </li>--%>
<%--                    <li class="menu_iconb">--%>
<%--                        <a href="signup.jsp">Sign up</a>--%>
<%--                    </li>--%>
<%--                </c:if>--%>
<%--                <c:if test="${sessionScope.acc != null}">--%>
<%--                    <li>--%>
<%--                        Hello <c:out value="${sessionScope.acc.username}"></c:out>--%>
<%--                    </li>--%>
<%--                    <li class="menu_iconb">--%>
<%--                        <a href="logout">Log out</a>--%>
<%--                    </li>--%>
<%--                </c:if>--%>
<%--                <li class="tytyu">--%>
<%--                    <a href="cart.jsp"></a>--%>
<%--                </li>--%>
<%--                <li class="menu_iconb">--%>
<%--                    <a href="#"></a>--%>
<%--                </li>--%>

<%--                <li>--%>
<%--                    <button type="button" id="sidebarCollapse">--%>
<%--                        <i class="fas fa-align-justify"></i>--%>
<%--                    </button>--%>
<%--                </li>--%>
<%--            </ul>--%>
        </form>
    </div>
</nav>