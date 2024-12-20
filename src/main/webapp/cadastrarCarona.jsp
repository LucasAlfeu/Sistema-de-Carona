<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Carona</title>
    <link rel="stylesheet" href="styles/cadastroCarona.css">
</head>
<body>
    <header>
        <nav>
            <ul>
                <li><a href="paginaPrincipal.jsp">In�cio</a></li>
                <li><a href="perfil.jsp">Perfil</a></li>
                <li><a href="index.jsp">Sair</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <h1>Cadastrar Carona</h1>
        <form action="cadastrarCarona.do" method="POST">
            <label class="label-form" for="saida">Sa�da:</label>
            <input type="text" id="saida" name="saida" required>

            <label class="label-form" for="chegada">Chegada:</label>
            <input type="text" id="chegada" name="chegada" required>
            
		    <label for="data">Data:</label>
		    <input type="date" id="data" name="data" required>

            <label class="label-form" for="horario">Hor�rio:</label>
            <input type="time" id="horario" name="horario" required>

            <label class="label-form" for="valor">Valor:</label>
            <input type="number" id="valor" name="valor" required>

            <label class="label-form" for="vagas">Vagas:</label>
            <input type="number" id="vagas" name="vagas" required>
            
            <label  class="label-form">Selecionar Ve�culo:</label>
            <div class="box">
                <div class="box1">
                    <input type="radio" id="veiculo1" name="veiculo" value="veiculo1" checked>
                    <label for="veiculo1">Ve�culo 1</label>
                </div>
                <div class="box1">
                    <input type="radio" id="veiculo2" name="veiculo" value="veiculo2">
                    <label for="veiculo1">Ve�culo 2</label>
                </div>
                <div class="box1">
                    <input type="radio" id="veiculo3" name="veiculo" value="veiculo3">
                    <label for="veiculo1">Ve�culo 3</label>
                </div>

            </div>
            <div class="box2">
                <button type="submit">Cadastrar</button>
                <a href="paginaPrincipal.jsp">Cancelar</a>
            </div>
        </form>
    </main>
</body>
</html>