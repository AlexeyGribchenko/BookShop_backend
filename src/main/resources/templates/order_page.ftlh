<#import "parts/common.ftlh" as c>
<#import "parts/bookform.ftlh" as b>

<@c.page>
    <div>
        <div class="row mt-3 align-items-center justify-content-between">
            <div class="col-3 align-content-center" style="height: min-content">
                <h4>Заказ <span class="text-primary">№${order.getId()}</span></h4>
            </div>
            <div class="col-3">
                <div style="text-align: end"><span class="text-secondary">Дата заказа: </span>${order.getOrderDate()}
                </div>
                <div class="mt-2" style="text-align: end"><span
                            class="text-secondary">Общая стоимость: </span>${order.getTotalPrice()} ₽
                </div>
            </div>
        </div>
        <@b.book_row_list order.getBookList() />
    </div>
</@c.page>