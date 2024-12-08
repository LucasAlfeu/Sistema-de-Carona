<%@ page import="model.Usuario" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Caronas</title>
    <link rel="stylesheet" href="./styles/paginaPrincipal.css">
</head>
<body>

<%Usuario nome = (Usuario) session.getAttribute("user");%>

<%if (nome == null) { %>

<% response.sendRedirect("index.jsp"); %>
<% }else { %>
<%="Olá " + nome.getUsuario()+ " " + nome.getCpf() %>
<% }%>


    

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
        <h1>Carona</h1>
        <div class="search-form">
            <form action="BuscarCarona" method="POST" class="box">
                <input type="text" name="origem" placeholder="Origem">
                <input type="text" name="destino"placeholder="Destino">
                <input type="text" name="data" placeholder="Data">
                <input type="number" name="vagas" placeholder="Vagas">
            </form>
            <div class="box-button">
                <button>Oferecer Carona</button>
                <button>Buscar</button>
            </div>
        </div>
        <div class="caronas">
            <div class="carona-card">
                <h3>Carona</h3>
                <p>Saída</p>
                <p>Chegada</p>
                <p>Data</p>
                <p>Horario</p>
                <p>Vagas Disponíveis</p>
                <p>Motorista</p>
                <a href="detalheCarona.html">Saiba Mais</a>
            </div>
            <div class="carona-card">
                <h3>Carona</h3>
                <p>Saída</p>
                <p>Chegada</p>
                <p>Data</p>
                <p>Horario</p>
                <p>Vagas Disponíveis</p>
                <p>Motorista</p>
                <a href="detalheCarona.html">Saiba Mais</a>
            </div>
            <div class="carona-card">
                <h3>Carona</h3>
                <p>Saída</p>
                <p>Chegada</p>
                <p>Data</p>
                <p>Horario</p>
                <p>Vagas Disponíveis</p>
                <p>Motorista</p>
                <a href="detalheCarona.html">Saiba Mais</a>
            </div>
            <div class="carona-card">
                <h3>Carona</h3>
                <p>Saída</p>
                <p>Chegada</p>
                <p>Data</p>
                <p>Horario</p>
                <p>Vagas Disponíveis</p>
                <p>Motorista</p>
                <a href="detalheCarona.html">Saiba Mais</a>
            </div>
        </div>
    </main>
</body>
</html>