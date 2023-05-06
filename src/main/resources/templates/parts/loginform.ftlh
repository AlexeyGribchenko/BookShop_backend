<#macro login path submit_value>
    <form action="${path}" method="post">
        <div><label>Имя пользователя: <input type="text" name="username"></label></div>
        <div><label>Пароль: <input type="password" name="password"></label></div>
        <#nested>
        <div><input type="submit" value="${submit_value}"></div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <div><input type="submit" value="Выход"></div>
    </form>
</#macro>