<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width/2, initial-scale=1">

	<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/jquery.mobile-1.4.4.css">
	<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/theme-classic.css" />
	<script src="${pageContext.request.contextPath}/jquery-1.11.1.js"></script>
	<script	src="${pageContext.request.contextPath}/jquery.mobile-1.4.4.js"></script>

	<title>Pagina principale</title>
</head>

<body>
	<div data-role="page" id="Mainpage">

		<div data-role="header" data-theme="b">
			<h1>Menu principale</h1>
		</div>
		
		<div data-role="main" class="ui-content ui-body-b">

			<ul data-role="listview" data-inset="true">
				<li><a href="${pageContext.request.contextPath}/Riscaldamento"> <img src="${pageContext.request.contextPath}/assets/img/calorifero.jpg" width="80" height="80">
					<h2>Climatizzazione</h2>
					<p>	Gestione caloriferi e caldaia</p></a>
				</li>
						
				<li><a href="${pageContext.request.contextPath}/admin/cc128.jsp"> <img src="${pageContext.request.contextPath}/assets/img/contatore.jpg" width="80" height="80">
					<h2>Energia</h2>
					<p>Grafico consumi di corrente</p></a>
				</li>
						
				<li><a href=""> <img src="${pageContext.request.contextPath}/assets/img/sicurezza.jpg"	width="80" height="80">
					<h2>Sicurezza</h2>
					<p>Visualizzazione telecamera</p></a>
				</li>
						
				<li><a href="${pageContext.request.contextPath}/admin/livedata.jsp"><img src="${pageContext.request.contextPath}/assets/img/gauge.png"	width="80" height="80">
					<h2>Live</h2>
					<p>Dati in tempo reale</p></a>
				</li>
			</ul>
		</div>
		
		<div data-role="footer" data-theme="b" class="ui-grid-a">
			<div class="ui-block-a">
				<h4>
					User: <%=request.getUserPrincipal().getName()%>
				</h4>
			</div>
			<div class="ui-block-b" align="right">
				<a href="${pageContext.request.contextPath}/LogoutServlet" data-role="button" data-icon="delete">Termina</a>
			</div>
		</div>

	</div>
</body>
</html>