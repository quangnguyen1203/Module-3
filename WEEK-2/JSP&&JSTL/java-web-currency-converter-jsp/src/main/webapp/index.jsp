<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Currency Converter</title>
    <style>
        body{
            width: 250px;
            height: 170px;
            margin: 10px 30px;
            padding: 10px;
            border: 2px solid;
        }
        #submit{
            margin-top: 10px;
            border-radius: 5px;
            background-color: bisque;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Currency Converter</h2>
<form method="post" action="converter.jsp" class="css" >
    <label>Rate: </label><br/>
    <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="USD" value="0"/><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
</form>
</body>
</html>