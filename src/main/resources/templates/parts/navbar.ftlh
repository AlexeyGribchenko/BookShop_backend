<#include "security.ftlh">


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">BookShop</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/profile">Профиль</a>
                </li>
                <#if isAuth>
                    <li class="nav-item">
                        <a class="nav-link" href="/profile/wishlist">Избранное</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/profile/cart">Корзина</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/profile/orders">Заказы</a>
                    </li>
                </#if>
                <#if isAdmin>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/all">Пользователи</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/book/all">Книги</a>
                    </li>
                </#if>
            </ul>
            <form action="/search_books" method="get" class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Поиск" aria-label="Search" name="searchPrompt" />
                <button class="btn btn-outline-success" type="submit">Поиск</button>
            </form>
        </div>
    </div>
</nav>