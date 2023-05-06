<#import "parts/common.ftlh"as c>

<@c.page>
    <!-- тут должно быть фото профиля наверно, мб нахуй надо -->
    <#if isLogined>
        <h3>Имя</h3>
        <div>${user.getFirstName()}</div>
        <div>${user.getLastName()}</div>
        <div><a href="/profile/wishlist">Избранное</a></div>
        <div><a href="/profile/orders">Заказы</a></div>
        <div><a href="/profile/cart">Корзина</a></div>
        <form action="/profile/delete">
            <b style="font-size: 92px"><input type="submit" value=""></b>
        </form>
    <#else>
        <div>Вы не авторизованы!</div>
        <div><a href="/login">Войти</a></div>
        <div><a href="/registration">Зарегистрироваться</a></div>
    </#if>
</@c.page>