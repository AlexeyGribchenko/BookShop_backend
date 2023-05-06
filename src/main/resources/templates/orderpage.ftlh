<#import "parts/common.ftlh" as c>
<#import "parts/order.ftlh" as o>


<@c.page>
    Книги
    <@o.single_order order=order />
</@c.page>