<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/25/2021
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Converter</title>
</head>
<body>
    <%
        float rate = Float.parseFloat(request.getParameter("rate"));
        float usd = Float.parseFloat(request.getParameter("usd"));

        float vnd = rate*usd;
    %>
    <h1>Rate: <%=rate%></h1>
    <h1>Usd: <%=usd%></h1>
    <h1>VND: <%=vnd%></h1>

</body>
</html>
