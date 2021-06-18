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
            <div class="container">
                <div class="card">
                    <div class="row">
                        <aside class="col-sm-5 border-right" style="padding-right: 0px">
                            <article class="gallery-wrap">
                                <div class="img-big-wrap">
                                    <div> <a href="#"><img src="${detail.image}"></a></div>
                                </div> <!-- slider-product.// -->
                                <div class="img-small-wrap">
                                </div> <!-- slider-nav.// -->
                            </article> <!-- gallery-wrap .end// -->
                        </aside>
                        <aside class="col-sm-7">
                            <article class="card-body p-5">
                                <h3 class="title mb-3">${detail.name}</h3>

                                <p class="price-detail-wrap">
                                            <span class="price h3 text-warning">
                                                <span class="currency">US $</span><span class="num">${detail.price}</span>
                                            </span>
                                </p> <!-- price-detail-wrap .// -->
                                <dl class="item-property">
                                    <dt>Description</dt>
                                    <dd><p>
                                        ${detail.description}
                                    </p></dd>
                                </dl>

                                <hr>
                                <div class="row">
                                    <div class="col-sm-5">
                                        <dl class="param param-inline">
                                            <dt>Quantity: </dt>
                                            <dd>
                                                <select class="form-control form-control-sm" style="width:70px;">
                                                    <option> 1 </option>
                                                    <option> 2 </option>
                                                    <option> 3 </option>
                                                </select>
                                            </dd>
                                        </dl>  <!-- item-property .// -->
                                    </div> <!-- col.// -->

                                </div> <!-- row.// -->
                                <hr>
                                <a href="#" class="btn btn-lg btn-primary text-uppercase"> Buy now </a>
                                <a href="#" class="btn btn-lg btn-outline-primary text-uppercase"> <i class="fas fa-shopping-cart"></i> Add to cart </a>
                            </article> <!-- card-body.// -->
                        </aside> <!-- col.// -->
                    </div> <!-- row.// -->
                </div> <!-- card.// -->


            </div>
        </div>

    </div>
</div>