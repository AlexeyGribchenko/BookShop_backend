<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <title>BookShop</title>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <link rel="icon" type="image/ico" href="/img/icons/favicon.ico"/>
        <link rel="stylesheet" href="/css/style.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
              crossorigin="anonymous"/>
    </head>
    <body>
    <#include "navbar.ftlh">
    <div class="container mt-3" style="min-height: 75vh">
        <#nested>
    </div>
    <#include "footer.ftlh">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
    <script src="/js/script.js"></script>
    </body>
    </html>
</#macro>