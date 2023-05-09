<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Имя пользователя</th>
            <th scope="col">Роль</th>
        </tr>
        </thead>
        <tbody>
        <#list userList as user>
            <tr>
                <td>${user.getUsername()}</td>
                <td>
                    <#if user.getRoles()?seq_contains("ROLE_SUPER_ADMIN")>
                        Главный администратор
                    <#elseif user.getRoles()?seq_contains("ROLE_ADMIN")>
                        Администратор
                    <#else>
                        Пользователь
                    </#if>
                </td>
                <#if isAdmin && !user.getRoles()?seq_contains("ROLE_SUPER_ADMIN")>
                    <td class="col-sm-2">
                        <form action="/user/change_activity/${user.getId()}" method="post">
                            <#if user.getRoles()?seq_contains("ROLE_ADMIN") && !isSuperAdmin>
                                <#if user.isEnabled()>
                                    <button class="btn btn-danger col-sm-12 disabled" type="submit">Заблокировать</button>
                                <#else>
                                    <button class="btn btn-success col-sm-12 disabled" type="submit">Разблокировать</button>
                                </#if>
                            <#else>
                                <#if user.isEnabled()>
                                    <button class="btn btn-outline-danger col-sm-12" type="submit">Заблокировать</button>
                                <#else>
                                    <button class="btn btn-outline-success col-sm-12" type="submit">Разблокировать</button>
                                </#if>
                            </#if>
                        </form>
                    </td>
                    <#if isSuperAdmin && !user.getRoles()?seq_contains("ROLE_SUPER_ADMIN")>
                        <#if user.getRoles()?seq_contains("ROLE_ADMIN")>
                            <#assign btnPermissionChangeName = "Понизить" btnType = "btn-outline-danger">
                        <#else>
                            <#assign btnPermissionChangeName = "Повысить" btnType = "btn-outline-success">
                        </#if>
                        <td class="col-sm-2">
                            <form action="/user/change_permissions/${user.getId()}" method="post">
                                <button class="btn col-sm-12 ${btnType}" type="submit">${btnPermissionChangeName}</button>
                            </form>
                        </td>
                    </#if>
                    <td class="col-sm-2">
                        <form action="/user/delete/${user.getId()}" method="post">
                            <button class="btn btn-danger col-sm-12" type="submit">Удалить</button>
                        </form>
                    </td>
                </#if>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>