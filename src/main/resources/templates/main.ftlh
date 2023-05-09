<#import "parts/common.ftlh" as c>
<#import "parts/bookform.ftlh" as b>


<@c.page>
    <div id="carouselExampleIndicators" class="carousel slide mb-3" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner" style="border-radius: 15px">
            <div class="carousel-item active" data-mdb-interval="4000">
                <img src="/img/sliders/slide1.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item" data-mdb-interval="4000">
                <img src="/img/sliders/slide2.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item" data-mdb-interval="4000">
                <img src="/img/sliders/slide3.jpg" class="d-block w-100" alt="...">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
    <div class="row row-cols-2 row-cols-sm-3 row-cols-md-4 gy-4">
        <@b.book_list bookList />
    </div>
</@c.page>