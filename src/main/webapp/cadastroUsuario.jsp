<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulário de Cadastro</title>
    <link rel="stylesheet" href="styles/cadastroUsuario.css">
</head>
<body>
    <div class="container">
        <h1>Cadastrar</h1>
        <form action="cadastrarUsuario.do" method="POST">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" required>
            <label for="usuario">Usuário:</label>
            <input type="text" id="usuario" name="usuario" required>
            <label for="senha">Senha:</label>
            <input type="password" id="senha" name="senha" required>
            <label for="cpf">CPF:</label>
            <input type="text" id="cpf" name="cpf" required>
            <label for="telefone">Telefone:</label>
            <input type="tel" id="telefone" name="telefone" required>
            <div class="box">
                <button type="submit">Cadastrar</button>
                <a href="index.jsp">Cancelar</a>
            </div>
        </form>
    </div>
</body>
</html>