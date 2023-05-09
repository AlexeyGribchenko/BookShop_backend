<#import "parts/common.ftlh" as c>
<#import "parts/bookform.ftlh" as b>


<@c.page>

    <div class="row mt-5">
        <div class="col col-6">
            <div class="row h-100 align-items-center">
                <img class="w-100" src="/img/${book.getImgName()}" alt="no fucking way">
            </div>
        </div>
        <div class="row col-6 align-content-between">
            <div class="row">
                <h5>Название</h5>
                <div>${book.getName()}</div>
            </div>
            <div class="row">
                <h5>Автор</h5>
                <div>${book.getAuthor()}</div>
            </div>
            <div class="row">
                <h5>Описание</h5>
                <div style="text-align: justify">${book.getDescription()}</div>
            </div>
            <div class="row">
                <h5>Цена <span class="text-primary">${book.getPrice()} ₽</span></h5>
            </div>
            <div class="row justify-content-between">
                <form style="width: fit-content" action="/wishlist/add/${book.getId()}" method="post">
                    <label><button class="btn btn-outline-success" type="submit">В избранное</button></label>
                </form>
                <form style="width: fit-content" action="/cart/add/${book.getId()}" method="post">
                    <label><button class="btn btn-outline-success" type="submit">В корзину</button></label>
                </form>
            </div>
        </div>
    </div>
</@c.page>