<#import "parts/common.ftlh" as c>
<#import "parts/bookform.ftlh" as b>


<@c.page>
    <#if message??>
        <div>${message}</div>
    <#else>
        Книга
        <@b.single_book book=book />
        <form action="/wishlist/add/${book.getId()}" method="post">
            <label><input type="submit" value="В избранное"></label>
        </form>
        <form action="/cart/add/${book.getId()}" method="post">
            <label><input type="submit" value="В корзину"></label>
        </form>
    </#if>
    <a href="/">На главную</a>
</@c.page>