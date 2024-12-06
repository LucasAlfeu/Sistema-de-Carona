<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulário de Login</title>
    <link rel="stylesheet" href="./styles/entrar.css">
</head>
<body>
    <div class="container">
        <h1>Entrar</h1>
        <form action="Logar" method="POST">
            <label for="username">Usuário:</label>
            <input type="text" id="username" name="username" required>
            <label for="password">Senha:</label>
            <input type="password" id="password" name="password" required>
            <div class="box">
                <a href="cadastroUsuario.jsp">Cadastrar</a>
                <button type="submit">Entrar</button>
            </div>
        </form>
    </div>
</body>
</html>