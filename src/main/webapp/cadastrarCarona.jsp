<%@ page import="br.ufrrj.si.model.*" %>
<%@ page import="br.ufrrj.si.DAO.*" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Carona</title>
    <link rel="stylesheet" href="styles/cadastroCarona.css">
</head>
<body>
		<%Usuario usuario = (Usuario) session.getAttribute("user");%>
		<%AutomovelDAO autoDAO = new AutomovelDAO(); %>
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
        <h1>Cadastrar Carona</h1>
        <form action="cadastrarCarona.do" method="POST">
            <label class="label-form" for="saida">Saída:</label>
            <input type="text" id="saida" name="saida" required>

            <label class="label-form" for="chegada">Chegada:</label>
            <input type="text" id="chegada" name="chegada" required>
            
		    <label for="data">Data:</label>
		    <input type="date" id="data" name="data" required>

            <label class="label-form" for="horario">Horário:</label>
            <input type="time" id="horario" name="horario" required>

            <label class="label-form" for="valor">Valor:</label>
            <input type="number" id="valor" name="valor" required>

            <label class="label-form" for="vagas">Vagas:</label>
            <input type="number" id="vagas" name="vagas" required>
            
            <label  class="label-form">Selecionar Veículo:</label>
            <div class="box">
				<%
				    List<Automovel> minhaLista = autoDAO.buscaAutomoveisPorIdUsuario(usuario.getIdUsuario());
				    if (minhaLista != null) {
				        int contador = 1; // Contador para IDs únicos
				        for (Automovel item : minhaLista) {
				            String modelo = (item.getModelo() != null) ? item.getModelo() : "Sem Modelo";
				%>
				            <div class="box1">
				                <input type="radio" id="veiculo1" name="veiculo" value="<%= modelo %>" >
				                <label for="veiculo1"><%= modelo %></label>
				            </div>
				<%
				            contador++; // Incrementa o contador
				        }
				    } else {
				%>
				    <p>Nenhum automóvel encontrado.</p>
				<%
				    }
				%>
            </div>
            <div class="box2">
                <button type="submit">Cadastrar</button>
                <a href="paginaPrincipal.jsp">Cancelar</a>
            </div>
        </form>
    </main>
</body>
</html>