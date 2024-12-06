<!DOCTYPE html>
<%@ page import="br.ufrrj.si.model.Usuario" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Caronas</title>
    <link rel="stylesheet" href="styles/paginaPrincipal.css">
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
    <%Usuario nome = (Usuario) session.getAttribute("user");%>

	<%if (nome == null) { %>
	
	<% response.sendRedirect("index.jsp"); %>
	<% }else { %>
	<%="Olá " + nome.getUsuario()+ " " + nome.getCpf() %>
	<% }%>
        <h1>Carona</h1>
        <div class="search-form">
            <div class="box">
                <input type="text" placeholder="Origem">
                <input type="text" placeholder="Destino">
                <input type="date" placeholder="Data">
                <input type="number" placeholder="Vagas">
            </div>
            <div class="box-button">
                <a href="cadastrarCarona.jsp">Oferecer Carona</a>
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
                <a href="detalheCarona.jsp">Saiba Mais</a>
            </div>
            <div class="carona-card">
                <h3>Carona</h3>
                <p>Saída</p>
                <p>Chegada</p>
                <p>Data</p>
                <p>Horario</p>
                <p>Vagas Disponíveis</p>
                <p>Motorista</p>
                <a href="detalheCarona.jsp">Saiba Mais</a>
            </div>
            <div class="carona-card">
                <h3>Carona</h3>
                <p>Saída</p>
                <p>Chegada</p>
                <p>Data</p>
                <p>Horario</p>
                <p>Vagas Disponíveis</p>
                <p>Motorista</p>
                <a href="detalheCarona.jsp">Saiba Mais</a>
            </div>
            <div class="carona-card">
                <h3>Carona</h3>
                <p>SaÃ­da</p>
                <p>Chegada</p>
                <p>Data</p>
                <p>Horario</p>
                <p>Vagas Disponíveis</p>
                <p>Motorista</p>
                <a href="detalheCarona.jsp">Saiba Mais</a>
            </div>
        </div>
    </main>
</body>
</html>