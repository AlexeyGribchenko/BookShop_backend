<#import "parts/common.ftlh" as c>

<@c.page>
    <form action="/book/add" method="post">
        <label>Название: <input type="text" name="name"></label>
        <label>Автор: <input type="text" name="author"></label>
        <label>Цена: <input type="text" name="price"></label>
        <input type="submit" value="Добавить">
    </form>
</@c.page>