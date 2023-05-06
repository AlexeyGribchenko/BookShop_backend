<#import "parts/common.ftlh" as c>
<#import "parts/loginform.ftlh" as l>

<@c.page>
    <#if message??>
        <p>
            ${message}
        </p>
    </#if>
    Страница входа
    <@l.login "/login" "Вход" />
    <div><a href="/registration">Зарегистрироваться</a></div>
</@c.page>