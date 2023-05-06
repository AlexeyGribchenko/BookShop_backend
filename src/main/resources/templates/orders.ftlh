<#import "parts/common.ftlh" as c>
<#import "parts/order.ftlh" as o>

<@c.page>
    Заказы
    <@o.order_list order_list />
    <a href="/profile">назад</a>
</@c.page>