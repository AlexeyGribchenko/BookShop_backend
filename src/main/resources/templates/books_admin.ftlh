<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="row justify-content-center">
        <div class="col col-sm-7 align-items-center">
            <button class="btn btn-primary col-sm-12" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                Добавить книгу
            </button>
            <div class="collapse" id="collapseExample">
                <div class="card card-body mt-2">
                    <form  action="/book/add" method="post" enctype="multipart/form-data">
                        <div class="col">
                            <div class="form-group col">
                                <label class="col-sm-3" for="bookName">Изображение:</label>
                                <input class="form-control" id="bookName" type="file" name="file">
                            </div>
                            <div class="form-group col">
                                <label class="col-sm-2" for="bookName">Название:</label>
                                <input class="form-control" id="bookName" type="text" name="name">
                            </div>
                            <div class="form-group col">
                                <label class="col-sm-2 mt-3" for="bookAuthor">Автор:</label>
                                <input class="form-control" id="bookAuthor" type="text" name="author">
                            </div>
                            <div class="form-group col">
                                <label class="col-sm-2 mt-3" for="bookDescription">Описание:</label>
                                <textarea class="form-control" id="bookDescription" type="text" name="description" rows="3"></textarea>
                            </div>
                            <div class="form-group col">
                                <label class="col-sm-2 mt-3" for="bookPrice">Цена:</label>
                                <input class="form-control" id="bookPrice" type="text" name="price">
                            </div>
                            <button class="btn btn-primary mt-3" type="submit">Добавить</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID Книги</th>
            <th scope="col">Название</th>
            <th scope="col">Цена</th>
        </tr>
        </thead>
        <tbody>
        <#list bookList as book>
            <tr>
                <th scope="row">${book.getId()}</th>
                <td>${book.getName()}</td>
                <td>${book.getPrice()}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>