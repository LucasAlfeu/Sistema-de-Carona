<%@ page import="br.ufrrj.si.model.*" %>
<%@ page import="br.ufrrj.si.DAO.*" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalhes da Carona</title>
    <link rel="stylesheet" href="styles/detalheCarona.css">
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
    
        <% 
        	Usuario motorista = (Usuario) request.getAttribute("motorista");
	       	Carona carona = (Carona) request.getAttribute("carona");
	       	List<SolicitacaoCarona> listaSolicitacao = (List<SolicitacaoCarona>) request.getAttribute("solicitacoes");
	       	if (carona != null) {
	       		String dataFormatada = carona.formatarData(carona.getDataCarona());
    	%>
        <h1>Detalhes</h1>
        <div class="carona-details">
            <p><strong>Motorista:</strong> <%= motorista.getNome() %></p>
            <p><strong>Embarque:</strong><%= carona.getSaida() %> </p>
            <p><strong>Desembarque:</strong> <%= carona.getChegada() %></p>
            <p><strong>Data da Carona:</strong> <%= dataFormatada %></p>
            <p><strong>Horário de Saída:</strong> <%= carona.getHorario() %></p>
            <p><strong>Contato Motorista:</strong> <%= motorista.getTelefone() %> </p>
            <p><strong>Número de Vagas:</strong> <%= carona.getVagas() %></p>
            <p><strong>Valor:</strong>R$ <%= carona.getValor() %></p>
            <h2>Solicitações</h2>
            <ul class="solicitacoes">
            <%
            	if (listaSolicitacao != null) {
                	for (SolicitacaoCarona s : listaSolicitacao) {
            %>
                <li>
                    <% 
                    	UsuarioDAO uDAO = new UsuarioDAO();
                    	Usuario u = uDAO.buscarUsuarioPorId(s.getIdUsuario());
                    %>
                    <p><%= u.getNome() %> </p></br>
                    <p><%= s.getConfirmado() %></p>
					<%
						if(s.getConfirmado().equals("Solicitada")) {
					%>
					    <form action="RecusaCarona" method="POST">
					    <input type="hidden" name="idSolicitacao" value="<%= s.getID_Pedido() %>">
					    <input type="hidden" name="idCarona" value="<%= carona.getIdCarona() %>">
					    <button type="submit">Recusar Pedido</button>
					</form>
                    <form action="ConfirmaCarona" method="POST">
					    <input type="hidden" name="idSolicitacao" value="<%= s.getID_Pedido() %>">
					    <input type="hidden" name="idCarona" value="<%= carona.getIdCarona() %>">
					    <button type="submit">Aceitar Pedido</button>
					</form>
                </li>
                	<% } %>
                	
            <%
             		}
             	} else {
            %>
	            <li>Nenhuma Solicitação</li>
            <%
                }
            %>
            </ul>
        </div>
        <% } else { %>
	    	<p>Carona não encontrada!</p>
	    <% } %>
    </main>
</body>
</html>