<#macro login path isRegister>
    <form action="${path}" method="post">
        <div class="container justify-content-center col-sm-8">
            <#if isRegister>
                <h4>Страница регистрации</h4>
            <#else>
                <h4>Страница входа</h4>
            </#if>
            <div class="form-group col">
                <label for="inputUsername" class="col-form-label">Имя пользователя:</label>
                <div class="">
                    <input type="text" name="username" id="inputUsername" class="form-control"
                           placeholder="Имя пользователя" required>
                </div>
            </div>
            <div class="form-group col">
                <label for="inputPassword" class="col-form-label">Пароль:</label>
                <div class="">
                    <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Пароль"
                           required>
                </div>
            </div>
            <#if isRegister>
                <div class="form-group col">
                    <label for="inputFirstName" class="col-form-label">Имя:</label>
                    <div class="">
                        <input type="text" name="firstName" id="inputFirstName" class="form-control" placeholder="Имя"
                               required>
                    </div>
                </div>
                <div class="form-group col">
                    <label for="inputLastname" class="col-form-label">Фамилия:</label>
                    <div class="">
                        <input type="text" name="lastName" id="inputLastname" class="form-control" placeholder="Фамилия"
                               required>
                    </div>
                </div>
                <div class="form-group col">
                    <label for="inputBirthDate" class="col-form-label">Фамилия:</label>
                    <div class="">
                        <input type="date" name="birthDateString" id="inputBirthDate" class="form-control" required>
                    </div>
                </div>
                <div class="form-group col">
                    <div class="mt-3">
                        <button type="submit" class="btn btn-primary">Регистрация</button>
                    </div>
                </div>
            <#else>
                <div class="form-group col mt-3">
                    <button type="submit" class="btn btn-primary">Вход</button>
                </div>
                <div class="form-group col mt-3">
                    <a href="/registration">Зарегистрироваться</a>
                </div>
            </#if>
        </div>
    </form>
</#macro>
