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
			
		    Carona carona = (Carona) request.getAttribute("carona");
			Usuario motorista = (Usuario) request.getAttribute("motorista");
		    if (carona != null && motorista != null) {
		    	String dataFormatada = carona.formatarData(carona.getDataCarona());
	%>
        <h1>Solicitar Carona</h1>
        <form action="" class="form-container" method="POST">
            <p><strong>Motorista:</strong> <%= motorista.getNome() %></p>
            <p><strong>Embarque:</strong> <%= carona.getSaida() %></p>
            <p><strong>Desembarque:</strong> <%= carona.getChegada() %></p>
            <p><strong>Data da Carona:</strong> <%= dataFormatada %></p>
            <p><strong>Horário de Saída:</strong> <%= carona.getHorario() %></p>
            <p><strong>Contato Motorista:</strong> <%= motorista.getTelefone() %></p>
            <p><strong>Número de Vagas:</strong><%= carona.getVagas() %></p>
            <p><strong>Valor:</strong> R$ <%= carona.getValor() %></p>
            <button type="submit">Solicitar Carona</button>
        </form>
      <% } else { %>
	    	<p>Carona não encontrada!</p>
	  <% } %>
    </main>
</body>
</html>