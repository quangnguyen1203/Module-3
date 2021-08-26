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
                            <img class="card-img-top" src="${o.image}" alt="Card image cap">
                            <div class="card-body">
                                <h4 class="card-title show_txt" style="width: 200px; white-space: nowrap;  overflow: hidden; text-overflow: ellipsis"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4>
                                <p class="card-text show_txt" style="width: 200px; white-space: nowrap;  overflow: hidden; text-overflow: ellipsis">${o.title}</p>
                                <div class="row">
                                    <div class="col">
                                        <p class="btn btn-danger btn-block">$ ${o.price}</p>
                                    </div>
                                    <div class="col">
<%--                                        <c:url value="/addtoCart?productId=${o.id}" var="addtoCart"/>--%>
                                        <a href="addToCart?productId=${o.id}" class="btn btn-success btn-block">Add to cart</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="clearfix">
                <ul class="pagination" >
                    <c:forEach begin="1" end="${endPage}" var="i">
                        <li class="page-item"><a href="index?index=${i}" class="page-link">${i}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>

    </div>
</div>