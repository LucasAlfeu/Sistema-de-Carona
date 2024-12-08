<%@ page import="model.Usuario" %>
<%@ page import="model.Carona" %>
<%@ page import="java.util.List" %>


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
                <li><a href="paginaPrincipal.html">Início</a></li>
                <li><a href="perfil.html">Perfil</a></li>
                <li><a href="index.html">Sair</a></li>
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
                <div class="box-button">
                    <a href="cadastrarCarona.jsp"><button>Oferecer Carona</button></a>
                    <button type="submit">Buscar</button>
                </div>
            </form>

        </div>
        <div class="carona-container">
            <%
                // Recuperar a lista da sessão
                List<Carona> minhaLista = (List<Carona>) session.getAttribute("caronas");
                if (minhaLista != null) {
                    for (Carona item : minhaLista) {
            %>
            <div class="carona-card">
                <h3>Caronas</h3>
                <p>ID: <%=item.getIdCarona()%></p>
                <p>Chegada: <%=item.getChegada()%></p>
                <p>Saída: <%=item.getSaida()%></p>
                <p>Data: <%=item.getDataCarona()%></p>
                <p>Valor: R$ <%=item.getValor()%></p>
                <p>Usuário: <%=item.getIdUsuario()%></p>
                <a href="detalheCarona.jsp">Saiba Mais</a>
            </div>
            <%
                }
            } else {
            %>
            <div class="carona-card">
                <p>Nenhum item encontrado na lista.</p>
            </div>
            <%
                }
            %>
        </div>

        </div>
    </main>
</body>
</html>