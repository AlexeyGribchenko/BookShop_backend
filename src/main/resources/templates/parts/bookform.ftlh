<#macro book_list booklist>
    <#list booklist as book>
        <a href="/book/${book.getId()}">
            <@single_book book />
        </a>
        <#nested book>
    </#list>
</#macro>

<#macro single_book book>
    <div>
        <div>Название: ${book.getName()}</div>
        <div>Автор: ${book.getAuthor()}</div>
        <div>Описание: ${book.getDescription()!""}</div>
        <div>Жанры: <#list book.getGenres() as genre>${genre}<#sep>,  </#list></div>
        <div>Цена: ${book.getPrice()}</div>
    </div>
</#macro>
