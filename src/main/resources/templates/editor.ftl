<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>
        <h1>Nivel Fuego Rojo</h1>
        <div id  ="contenedor">
            <div id="tablero">
                <#list 0..39 as i>
                    <#list 0..29 as j>
                        <div class="celda" data-fila="${i}" data-columna="${j}"></div>
                    </#list>
                </#list>
            </div>

            <div id="escenario">
                <h2>Escenario</h2>
                <div class="horizontal">
                    <div id="inicio" class="celda pintura selected"></div><h3>Inicio</h3>
                </div>

                <div class="horizontal">
                    <div id="meta" class="celda pintura"></div><h3>Meta</h3>
                </div>
                <div class="horizontal">
                    <div id="tierra" class="celda pintura"></div><h3>Tierra</h3>
                </div>
                <div class="horizontal">
                    <div id="agua" class="celda pintura"></div><h3>Agua</h3>
                </div>
                <div class="horizontal">
                    <div id="pared" class="celda pintura"></div><h3>Pared</h3>
                </div>
            </div>

                <div id="elementos">
                    <h2>Elementos</h2>
                </div>

                <div id="acciones">
                    <h2>Acciones</h2>
                </div>

        </div>

</body>
</html>