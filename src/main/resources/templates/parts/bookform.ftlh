<#macro book_list booklist>
    <#list booklist as book>
        <div class="col">
            <a class="text-decoration-none" href="/book_page/${book.getId()}">
                <@single_book book />
            </a>
            <#nested book>
        </div>
    </#list>
</#macro>

<#macro single_book book>
    <div>
        <div class="card h-100" style="height: auto">
            <div class="d-flex" style="overflow: hidden">
                <img class="card-img-top"
                     style="width: 100%; height: 15vw; object-fit: contain"
                     src="/img/${book.getImgName()}" alt="no fucking way">
            </div>
            <div class="card-body">
                <div class="card-title text-truncate">
                    ${book.getName()}
                </div>
                <div class="card-subtitle">${book.getPrice()} ₽</div>
            </div>
        </div>
    </div>
</#macro>

<#macro book_row_list bookList>
    <#list bookList as book>
        <hr>
        <div class="row mt-4">
            <a class="col col-3 text-decoration-none"
                href="/book_page/${book.getId()}">
                <img class="w-100" src="/img/${book.getImgName()}" alt="no fucking way">
            </a>

            <div class="row col-8 align-content-between">
                <div class="row">
                    <div class="col col-3">
                        <p class="text-secondary">Название: </p>
                    </div>
                    <div class="col col-9">
                        ${book.getName()}
                    </div>
                </div>
                <div class="row">
                    <div class="col col-3">
                        <p class="text-secondary">Цена: </p>
                    </div>
                    <div class="col col-9">
                        ${book.getPrice()} ₽
                    </div>
                </div>
                <#nested book>
            </div>
        </div>
    </#list>
</#macro>
