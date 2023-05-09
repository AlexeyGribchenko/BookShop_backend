<#assign
    userRoles = userAuth.getAuthorities()
    isAuth = userRoles?seq_contains("ROLE_USER")
    isAdmin = userRoles?seq_contains("ROLE_ADMIN")
    isSuperAdmin = userRoles?seq_contains("ROLE_SUPER_ADMIN")
>

<#if isAuth>
    <#assign
        userName = userAuth.getName()
    >
<#else>
    <#assign
        userName = "unknown"
    >
</#if>
