<%@ page import="br.ufrrj.si.model.*" %>
<%@ page import="br.ufrrj.si.DAO.*" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil</title>
    <link rel="stylesheet" href="styles/perfil.css">
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
    
    	<%Usuario usuario = (Usuario) session.getAttribute("user");%>    	
    	<%CaronaDAO caronaDAO = new CaronaDAO(); %>
    	<%CaronaSolicitacaoDAO caronaSDAO = new CaronaSolicitacaoDAO(); %>
    	
        <h1>Perfil</h1>
        <div class="box">
            <p><%= usuario.getNome() %></p>
            <a href="cadastrarCarro.jsp">Cadastrar Carro</a>
        </div>
        <h2>Caronas Oferecidas</h2>
        <table>
            <thead>
                <tr>
                    <th>Origem</th>
                    <th>Destino</th>
                    <th>Data</th>
                    <th>Detalhes</th>
                </tr>
            </thead>
            <tbody>
            <%
                // Recuperar a lista da sessão
                List<Carona> minhaLista = caronaDAO.buscarCaronaPorIdUsuario(usuario.getIdUsuario());
                if (minhaLista != null) {
                    for (Carona item : minhaLista) {
                    	String dataFormatada = item.formatarData(item.getDataCarona());
            %>
                <tr>
                    <td><%= item.getSaida() %></td>
                    <td><%= item.getChegada() %></td>
                    <td><%= dataFormatada %></td>
                    <td><a href="BuscaDetalhesCaronaPerfil?id=<%= item.getIdCarona() %>">Saiba mais</a></td>
                </tr>
            <%
             		}
             	} else {
            %>
                    <td> - </td>
                    <td> - </td>
                    <td> - </td>
                    <td><a href="#">Saiba mais</a></td>
            <%
                }
            %>
                </tbody>
        </table>
        </br>
        </br>
        </br>
        
        <h2>Pedidos de Carona</h2>
        <table>
            <thead>
                <tr>
                    <th>Embarque</th>
                    <th>Desembarque</th>
                    <th>Data</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
            <%
                List<SolicitacaoCarona> listaSolicitacoes = caronaSDAO.buscarSolicitacoesPorIdIsiario(usuario.getIdUsuario());
                if (listaSolicitacoes != null) {
                    for (SolicitacaoCarona s : listaSolicitacoes) {
                    	String dataFormatada = s.formatarData(s.getData());
            %>
                <tr>
                    <td><%= s.getEmbarque() %></td>
                    <td><%= s.getDesembarque() %></td>
                    <td><%= dataFormatada %></td>
                    <td><%= s.getConfirmado() %></td>
                </tr>
                            <%
             		}
             	} else {
            %>
                    <td> - </td>
                    <td> - </td>
                    <td> - </td>
            <%
                }
            %>
                </tbody>
        </table>
    </main>
</body>
</html>