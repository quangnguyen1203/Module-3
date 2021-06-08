<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-3 logo_section">
            <div class="full">
                <div class="center-desk">
                    <div class="logo">
                        <a href="index.jsp"><img src="Home/images/logostorequang.png" alt="#"></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-9">
            <div class="right_header_info">
                <ul>
                    <c:if test="${sessionScope.acc.isAdmin == 1}">
                        <li class="menu_iconb">
                            <a href="account">Manager Account</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.acc.isSell == 1}">
                        <li class="menu_iconb">
                            <a href="home">Manager Product</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.acc == null}">
                        <li class="menu_iconb">
                            <a href="login.jsp">Log in <img style="margin-right: 15px;" src="Home/icon/5.png" alt="#" /> </a>
                        </li>
                        <li class="menu_iconb">
                            <a href="signup.jsp">Sign up<img style="margin-left: 15px;" src="Home/icon/6.png" alt="#" /></a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.acc != null}">
                        <li>
                            Hello <c:out value="${sessionScope.acc.username}"></c:out>
                        </li>
                        <li class="menu_iconb">
                            <a href="logout">Log out<img style="margin-right: 15px;" src="Home/icon/5.png" alt="#" /> </a>
                        </li>
                    </c:if>
                    <li class="tytyu">
                        <a href="#"> <img style="margin-right: 15px;" src="Home/icon/2.png" alt="#" /></a>

                    </li>
                    <li class="menu_iconb">
                        <a href="#"><img style="margin-right: 15px;" src="Home/icon/3.png" alt="#" /></a>
                    </li>

                    <li>
                        <button type="button" id="sidebarCollapse">
                            <img src="Home/images/menu_icon.png" alt="#" />
                        </button>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
