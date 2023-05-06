<#import "parts/common.ftlh" as c>
<#import "parts/loginform.ftlh" as l>

<@c.page>
    Страница регистрации
    <@l.login "/registration" "Зарегистрироваться">
        <div><label>Имя: <input type="text" name="firstName"></label></div>
        <div><label>Фамилия: <input type="text" name="lastName"></label></div>
    </@l.login>
</@c.page>