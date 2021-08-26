<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/11/2021
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
    <style>
        .table td, .table th {
            vertical-align: middle !important;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
            <!-- Shopping cart table -->
            <div class="table-responsive">
                <table class="table">
                    <thead class="text-center">
                    <tr>
                        <th scope="col" class="border-0 bg-light">
                            <div class="p-2 px-3 text-uppercase text-left">Product</div>
                        </th>
                        <th scope="col" class="border-0 bg-light">
                            <div class="py-2 text-uppercase">Price</div>
                        </th>
                        <th scope="col" class="border-0 bg-light">
                            <div class="py-2 text-uppercase">Quantity</div>
                        </th>
                        <th scope="col" class="border-0 bg-light">
                            <div class="py-2 text-uppercase">Action</div>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${order.items}" var="item">
                            <tr>
                                <td scope="row" class="border-0">
                                    <div>
                                        <img src="${item.product.image}" alt="" width="70" class="img-fluid rounded shadow-sm">
                                        <div class="ml-3 d-inline-block align-middle">
                                            <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block align-middle">${item.product.name}</a></h5>
                                        </div>
                                    </div>
                                </td>
                                <td class="border-0 text-right"><strong>$ ${item.product.price}</strong></td>
                                <td class="border-0 text-right"><strong>${item.quantity}</strong></td>
                                <td class="border-0 text-center"><a href="#" class="btn btn-outline-danger"><i class="fa fa-trash"></i>Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <!-- End -->
        </div>
    </div>


    <div class="row py-5 p-4 bg-white rounded shadow-sm">
        <div class="col-lg-12">
            <form action="addToCart" method="get">
                <c:if test="${sessionScope.order == null}">
                    <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Order summary </div>
                    <div class="p-4">
                        <ul class="list-unstyled mb-4">
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Order Subtotal </strong><strong>0</strong></li>
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tax</strong><strong>0</strong></li>
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Total</strong>
                                <h5 class="font-weight-bold">0</h5>
                            </li>
                        </ul>
                    </div>
                    <div class="row">
                        <div class="col-lg-3"></div>
                        <div class="col-lg-6">
                            <a href="listOrder" class="btn btn-dark rounded-pill py-2 btn-block">Payment</a>
                        </div>
                        <div class="col-lg-3"></div>
                    </div>


                </c:if>
                <c:if test="${sessionScope.order != null}">
                    <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Order summary
                    </div>
                    <div class="p-4">
                        <ul class="list-unstyled mb-4">
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Order Subtotal </strong><strong>${(sub_total)}</strong></li>
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tax</strong><strong>${tax}</strong></li>
                            <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Total</strong>
                                <h5 class="font-weight-bold">$ ${total}</h5>
                            </li>
                        </ul>
                    </div>
                    <div class="row">
                        <div class="col-lg-3"></div>
                        <div class="col-lg-6">
                            <a href="listOrder" class="btn btn-dark rounded-pill py-2 btn-block">Payment</a>
                        </div>
                        <div class="col-lg-3"></div>
                    </div>
                </c:if>

            </form>
        </div>
    </div>


</div>
</body>
</html>
