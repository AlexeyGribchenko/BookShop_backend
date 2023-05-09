<#import "parts/common.ftlh" as c>
<#import "parts/bookform.ftlh" as b>


<@c.page>
    <h4>Избранное</h4>
    <@b.book_row_list wishlist; book>
        <div class="row">
            <form class="col-6" action="/wishlist/move_to_cart/${book.getId()}" method="post">
                <button class="btn btn-outline-success" type="submit">Переместить в корзину</button>
            </form>
            <form class="col-6" action="/wishlist/remove/${book.getId()}" method="post">
                <button class="btn btn-outline-danger" type="submit">Удалить из избранного</button>
            </form>
        </div>
    </@b.book_row_list>
</@c.page>