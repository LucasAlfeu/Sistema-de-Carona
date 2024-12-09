<%@ page import="br.ufrrj.si.model.Usuario" %>
<%@ page import="br.ufrrj.si.model.Carona" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
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
            <form action="BuscarCarona" method="POST" class="box">
                <input type="text" name="origem" placeholder="Origem">
                <input type="text" name="destino"placeholder="Destino">
                <input type="date" name="data" placeholder="Data">
                <input type="number" name="vagas" placeholder="Vagas">
                <div class="box-button">
                    <a href="cadastrarCarona.jsp">Oferecer Carona</a>
                    <button type="submit">Buscar</button>
                </div>
            </form>
        </div>
        <div class="caronas">
         <%
                // Recuperar a lista da sessão
                List<Carona> minhaLista = (List<Carona>) request.getAttribute("caronas");
                if (minhaLista != null) {
                    for (Carona item : minhaLista) {
                    	String dataFormatada = item.formatarData(item.getDataCarona());
            %>
            <div class="carona-card">
                <h3 class="card-tite"><strong>Carona</strong></h3>
                <p class="card-p"><strong class="card-strong">Embarque: </strong> <%=item.getSaida()%></p>
                <p class="card-p"><strong class="card-strong">Desembarque: </strong> <%=item.getChegada()%></p>
                <p class="card-p"><strong class="card-strong">Data: </strong> <%= dataFormatada %></p>
                <p class="card-p"><strong class="card-strong">Valor: </strong> R$ <%=item.getValor()%></p>
                <a href="BuscaDetalhes?id=<%= item.getIdCarona() %>" class="card-link">Saiba Mais</a>
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
    </main>
</body>
</html>