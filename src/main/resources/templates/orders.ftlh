<#import "parts/common.ftlh" as c>

<@c.page>
    <h4>Заказы</h4>
    <#list order_list as order>
        <a class="text-decoration-none" href="/order/${order.getId()}">
            <div class="card mb-3">
                <div class="card-body">
                    <div class="card-title row justify-content-between">
                        <div class="col col-5">
                            Заказ от: <span class="text-primary">${order.getOrderDate()?date}</span>
                        </div>
                        <div class="col col-7">
                            Номер заказа: <span class="text-danger">${order.getId()}</span>
                        </div>
                    </div>
                    <div class="card-text row">
                        <div class="col col-5">
                            Сумма заказа: <span class="text-primary">${order.getTotalPrice()} ₽</span>
                        </div>
                        <div class="col col-7 text-truncate">
                            В заказе: <#list order.getBookList() as book> <span class="text-success">${book.getName()}</span><#sep>, </#list>
                        </div>
                    </div>
                </div>
            </div>
        </a>
    </#list>
</@c.page>