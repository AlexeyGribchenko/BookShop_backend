<#import "parts/common.ftlh"as c>
<#include "parts/security.ftlh">

<@c.page>
    <div class="row col-4 mt-5 justify-content-center">
        <h3 style="text-align: center">Профиль</h3>
    </div>
    <div class="row">
        <div class="col col-4">
            <form class="row justify-content-center"
                  action="/user/update_profile_picture/${user.getId()}"
                  method="post"
                  enctype="multipart/form-data"
                  title="Нажмите на фото профиля, чтобы его обновить">
                <label style="width: 80%;
                        aspect-ratio: 1/1;
                        background-image: url('/img/profile_pictures/${user.getProfilePictureName()!"default_profile_image.png"}');
                        background-size: cover;
                        background-position: center ;
                        border-radius: 50%"
                       for="profileImage">
                </label>
                <input hidden id="profileImage" type="file" name="profilePicture">
                <button hidden class="upload-profile-image-btn btn btn-success col-7 mt-3" type="submit">
                    Обновить фото
                </button>
            </form>
        </div>
        <div class="row col-4 align-content-between">
            <div>Имя: ${user.getFirstName()}</div>
            <div>Фамилия: ${user.getLastName()}</div>
            <div>
                Дата рожления: <#if user.getBirthDate()??>${user.getBirthDate()?date}<#else>Не указана</#if>
            </div>
            <form action="/profile/delete">
                <button class="btn btn-danger col-7" type="submit">Удалить профиль</button>
            </form>
        </div>
        <div class="row col-4 align-content-between justify-content-center">
            <div class="col-7">
                <a class="btn btn-outline-success w-100" type="submit" href="/profile/wishlist">Избранное</a>
            </div>
            <div class="col-7">
                <a class="btn btn-outline-success w-100" type="submit" href="/profile/cart">Корзина</a>
            </div>
            <div class="col-7">
                <a class="btn btn-outline-success w-100" type="submit" href="/profile/orders">Заказы</a>
            </div>
            <div class="col-7">
                <a class="btn btn-primary w-100" type="submit" href="/profile/logout">Выйти</a>
            </div>
        </div>
    </div>
</@c.page>