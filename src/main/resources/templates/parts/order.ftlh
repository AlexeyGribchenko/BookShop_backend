<#import "bookform.ftlh" as b>

<#macro order_list orderlist>
    <#list orderlist as order>
        <a href="/order/${order.getId()}">
            <div>
                <div>Заказ №${order.getId()}</div>
                <div>Дата заказа: ${order.getOrderDate()?date}</div>
                <div>Общая стоимость: ${order.getTotalPrice()}</div>
            </div>
        </a>
    </#list>
</#macro>

<#macro single_order order>
    <div>
        <div>Заказ №${order.getId()}</div>
        <div>Дата заказа: ${order.getOrderDate()}</div>
        <div>Общая стоимость: ${order.getTotalPrice()}</div>
        <@b.book_list order.getBookList()/>
    </div>

</#macro>