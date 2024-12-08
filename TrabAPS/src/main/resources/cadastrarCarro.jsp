<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Carro</title>
    <link rel="stylesheet" href="../../../../Trab/Sistema-de-Carona-main/src/main/webapp/styles/cadastrarCarro.css">
</head>
<body>
    <header>
        <nav>
            <ul>
                <li><a href="paginaPrincipal.jsp">Início</a></li>
                <li><a href="perfil.jsp">Perfil</a></li>
                <li><a href="index.jsp">Sair</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <h1>Cadastrar Carro</h1>
        <form action ="CadastrarAutomovel.do" method="POST">
            <label for="placa">Placa:</label>
            <input type="text" id="placa" name="placa" required>
            <label for="modelo">Modelo:</label>
            <input type="text" id="modelo" name="modelo" required>
            <label for="cor">Cor:</label>
            <input type="text" id="cor" name="cor" required>
            <label for="tipo">Tipo:</label>
            <input type="text" id="tipo" name="tipo" required>
            <div class="box">
                <button type="submit">Cadastrar</button>
                <a href="">Cancelar</a>
            </div>
        </form>
    </main>
</body>
</html>