<!DOCTYPE html>
<html lang="en">

<head>
    <!-- basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- mobile metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <!-- site metas -->
    <title>Quang Store</title>
    <%@ include file="layout/head.jsp" %>
</head>
<!-- body -->

<body class="main-layout">
<!-- loader  -->
<div class="loader_bg">
    <div class="loader"><img src="Home/images/loading.gif" alt="#" /></div>
</div>

<div class="wrapper">
    <!-- end loader -->
    <%@ include file="layout/sidebar.jsp"%>

    <div id="content">
        <!-- header -->
        <header>
            <!-- header inner -->
            <div class="head_top">
                <div class="header">
                    <%@ include file="layout/header.jsp"%>
                </div>>
                <!-- end header inner -->

                <!-- end header -->
                <section class="slider_section">
                    <%@ include file="layout/slideheader.jsp"%>
                </section>
            </div>
        </header>
        <!-- Categories -->
        <div class="Categories">
            <%@ include file="layout/categories.jsp"%>
        </div>
    </div>
    <!-- end news shoes -->

    <!-- end Categories -->

<%--    <section>--%>
<%--        <!--  save -->--%>
<%--        <%@ include file="layout/saleoff.jsp"%>--%>
<%--        <!-- end save -->--%>
<%--    </section>--%>

    <!-- news Sports -->
<%--    <%@ include file="layout/sports.jsp"%>--%>
    <!-- end news Sports -->

    <!-- news Kids -->
<%--    <div id="kids" class="Kids_background">--%>
<%--        <%@ include file="layout/kid.jsp"%>--%>
<%--    </div>--%>
    <!-- end news Kids -->

    <!--  footer -->
    <footer>
        <%@ include file="layout/footer.jsp"%>
    </footer>
    <!-- end footer -->

</div>

<div class="overlay"></div>

<%@ include file="scripts/scriptfiles.jsp"%>

<%@ include file="scripts/sidebar.jsp"%>

<%@ include file="scripts/map.jsp"%>


</body>

</html>