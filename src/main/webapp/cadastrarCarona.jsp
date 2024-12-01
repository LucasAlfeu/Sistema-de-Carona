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
                <li><a href="paginaPrincipal.html">Início</a></li>
                <li><a href="perfil.html">Perfil</a></li>
                <li><a href="index.html">Sair</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <h1>Cadastrar Carona</h1>
        <form>
            <label class="label-form" for="saida">Saída:</label>
            <input type="text" id="saida" name="saida" required>

            <label class="label-form" for="chegada">Chegada:</label>
            <input type="text" id="chegada" name="chegada" required>

            <label class="label-form" for="horario">Horário:</label>
            <input type="time" id="horario" name="horario" required>

            <label class="label-form" for="valor">Valor:</label>
            <input type="number" id="valor" name="valor" required>

            <label class="label-form" for="vagas">Vagas:</label>
            <input type="number" id="vagas" name="vagas" required>
            
            <label  class="label-form">Selecionar Veículo:</label>
            <div class="box">
                <div class="box1">
                    <input type="radio" id="veiculo1" name="veiculo" value="veiculo1" checked>
                    <label for="veiculo1">Veículo 1</label>
                </div>
                <div class="box1">
                    <input type="radio" id="veiculo2" name="veiculo" value="veiculo2">
                    <label for="veiculo1">Veículo 2</label>
                </div>
                <div class="box1">
                    <input type="radio" id="veiculo3" name="veiculo" value="veiculo3">
                    <label for="veiculo1">Veículo 3</label>
                </div>

            </div>
            <div class="box2">
                <button type="submit">Cadastrar</button>
                <a href="paginaPrincipal.html">Cancelar</a>
            </div>
        </form>
    </main>
</body>
</html>