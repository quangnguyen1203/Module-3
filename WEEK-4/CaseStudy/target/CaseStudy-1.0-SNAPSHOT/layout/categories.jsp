<%--<div class="container">--%>
<%--    <div class="row">--%>
<%--        <div class="col-md-12">--%>
<%--            <div class="title">--%>
<%--                <h2> Categories</h2>--%>
<%--                <c:forEach items="${categoryList}" var="category">--%>
<%--                    <ul class="categori">--%>
<%--                        <li><a href="category?cid=${category.cid}">${category.cname}</a></li>--%>
<%--                    </ul>--%>
<%--                </c:forEach>--%>
<%--                <ul class="categiri">--%>
<%--                    <li class="active"><a href="#">Clothing</a></li>--%>
<%--                    <li><a href="#shoes">Shoes</a></li>--%>
<%--                    <li><a href="#sports">Sports</a></li>--%>
<%--                    <li><a href="#kids">Kids and Babies</a></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--    <!-- news brand -->--%>
<%--    <div id="brand"  class="brand-bg">--%>
<%--        <h3>New Clothing</h3>--%>
<%--        <div class="row">--%>
<%--            <c:forEach items="${productList}" var="product">--%>
<%--                    <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 margintop">--%>
<%--                        <div class="brand-box">--%>
<%--                            <p><img src="${product.image}"></p>--%>
<%--                            <h4>Price $<span class="nolmal">${product.price}</span></h4>--%>
<%--                        </div>--%>
<%--                        <a class="buynow" href="#">Buy now</a>--%>
<%--                    </div>--%>
<%--            </c:forEach>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <a class="seemore" href="#">See more</a>--%>
<%--</div>--%>
<div class="container">
    <div class="row">
        <div class="col-sm-3">
            <div class="card bg-light mb-3">
                <div class="card-header bg-danger text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                <ul class="list-group category_block">
                    <c:forEach items="${categoryList}" var="o">
                        <li class="list-group-item text-white ${tag == o.cid ? "active":""}"><a href="category?cid=${o.cid}">${o.cname}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div class="col-sm-9">
            <div id="content" class="row">
                <c:forEach items="${productList}" var="o">
                    <div class="product col-12 col-md-6 col-lg-4">
                        <div class="card">
                            <img class="card-img-top" src="${o.image}" alt="Card image cap" style="width: 400px;height: 300px">
                            <div class="card-body">
                                <h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4>
                                <p class="card-text show_txt">${o.title}</p>
                                <div class="row">
                                    <div class="col">
                                        <p class="btn btn-danger btn-block">${o.price} $</p>
                                    </div>
                                    <div class="col">
                                        <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <button onclick="loadMore()" class="btn btn-primary">Load more</button>
        </div>

    </div>
</div>