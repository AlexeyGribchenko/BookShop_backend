<#import "parts/common.ftlh" as c>
<#import "parts/bookform.ftlh" as b>

<@c.page>
    Книги
    <@b.book_list cart_list; book>
        <form action="/cart/remove/${book.getId()}" method="post">
            <input type="submit" value="Удалить из корзины">
        </form>
    </@b.book_list>
    <#if cart_list?has_content>
        <form action="/order/create_order" method="post">
            <input type="submit" value="Купить">
        </form>
    </#if>

    <a href="/profile">назад</a>
</@c.page>
