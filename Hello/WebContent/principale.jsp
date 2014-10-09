<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width/2, initial-scale=1">
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.4/jquery.mobile-1.4.4.min.css">
<link rel="stylesheet"
	href="http://demos.jquerymobile.com/1.4.4/theme-classic/theme-classic.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.4/jquery.mobile-1.4.4.min.js"></script>

<title>Pagina principale</title>
</head>

<%
	String nome = (String) session.getAttribute("CURRENT_LOGGED_USER");
	if (nome == null) {
		response.sendRedirect("loginjquery.jsp");
	}
%>

<body>
	<div data-role="page" id="Mainpage">

		<div data-role="header" data-theme="b">
			<h1>Menu principale</h1>
		</div>
		
		<div data-role="main" class="ui-content ui-body-b">

			<ul data-role="listview" data-inset="true">
				<li><a href="Riscaldamento"> <img
						src="assets/img/calorifero.jpg" width="80" height="80">
						<h2>Climatizzazione</h2>
						<p>Gestione caloriferi e caldaia</p></a></li>
				<li><a href=""> <img src="assets/img/contatore.jpg"
						width="80" height="80">
						<h2>Energia</h2>
						<p>Verifica consumi di corrente</p></a></li>
				<li><a href=""> <img src="assets/img/sicurezza.jpg"
						width="80" height="80">
						<h2>Sicurezza</h2>
						<p>Visualizzazione telecamera</p></a></li>
			</ul>
		</div>
		
		<div data-role="footer" data-theme="b" class="ui-grid-a">
			<div class="ui-block-a">
				<h4>
					Utente collegato:
					<%=nome%>
				</h4>
			</div>
			<div class="ui-block-b" align="right">
				<a href="LogoutServlet" data-role="button" data-icon="delete">Termina</a>
			</div>
		</div>

	</div>
</body>
</html>



























