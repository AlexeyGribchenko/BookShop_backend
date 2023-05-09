<#import "parts/common.ftlh" as c>
<#import "parts/bookform.ftlh" as b>

<@c.page>
    <h4>Корзина</h4>
    <@b.book_row_list cart_list; book>
        <form action="/cart/remove/${book.getId()}" method="post">
            <button class="btn btn-outline-danger" type="submit">Удалить из корзины</button>
        </form>
    </@b.book_row_list>
    <#if cart_list?has_content>
        <hr>
        <div class="row justify-content-center">
            <form style="width: min-content" action="/order/create_order" method="post">
                <button class="btn btn-success" type="submit">Купить</button>
            </form>
        </div>
    </#if>
</@c.page>
