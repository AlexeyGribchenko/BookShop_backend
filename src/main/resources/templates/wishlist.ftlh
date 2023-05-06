<#import "parts/common.ftlh" as c>
<#import "parts/bookform.ftlh" as b>


<@c.page>
    Избранное
    <@b.book_list wishlist; book>
        <form action="/wishlist/remove/${book.getId()}" method="post">
            <input type="submit" value="Удалить из избранного">
        </form>
    </@b.book_list>
    <a href="/profile">назад</a>
</@c.page>