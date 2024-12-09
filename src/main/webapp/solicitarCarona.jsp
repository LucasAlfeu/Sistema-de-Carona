<%@ page import="br.ufrrj.si.model.*" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Solicitar Carona</title>
    <link rel="stylesheet" href="styles/solicitarCarona.css">
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
			Usuario usuario = (Usuario) session.getAttribute("user");
		    Carona carona = (Carona) request.getAttribute("carona");
			Usuario motorista = (Usuario) request.getAttribute("motorista");
		    if (carona != null && motorista != null) {
		    	String dataFormatada = carona.formatarData(carona.getDataCarona());
	%>
        <h1>Solicitar Carona</h1>
        <form action="SolicitarCarona" class="form-container" method="POST">
            <p><strong>Motorista:</strong> <%= motorista.getNome() %></p>
            
            
            <p><strong>Embarque:</strong> <%= carona.getSaida() %></p>
            <input type="hidden" name="embarque" value="<%= carona.getSaida() %>">
            
            <p><strong>Desembarque:</strong> <%= carona.getChegada() %></p>
            <input type="hidden" name="desembarque" value="<%= carona.getChegada() %>">
            
            <p><strong>Data da Carona:</strong> <%= dataFormatada %></p>
            <input type="hidden" name="data" value="<%= carona.getDataCarona() %>">
            
            <p><strong>Horário de Saída:</strong> <%= carona.getHorario() %></p>
            <input type="hidden" name="horario" value="<%= carona.getHorario() %>">
            
            <p><strong>Contato Motorista:</strong> <%= motorista.getTelefone() %></p>
            <input type="hidden" name="contatoMotorista" value="<%= motorista.getTelefone() %>">
            
            <p><strong>Número de Vagas:</strong><%= carona.getVagas() %></p>
            
            <p><strong>Valor:</strong> R$ <%= carona.getValor() %></p>
            <input type="hidden" name="valor" value="<%= carona.getValor() %>">
            
            <p><strong>Vagas Desejadas</strong></p>
            <input type="number" name="vagasDesejadas" placeholder="Vagas">
            
            <input type="hidden" name="idUsuario" value="<%= usuario.getIdUsuario() %>">
            <input type="hidden" name="idCarona" value="<%= carona.getIdCarona() %>">
            
            
            <button type="submit">Solicitar Carona</button>
        </form>
      <% } else { %>
	    	<p>Carona não encontrada!</p>
	  <% } %>
    </main>
</body>
</html>