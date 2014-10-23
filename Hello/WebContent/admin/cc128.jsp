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

	<title>Grafici Consumi</title>
</head>

<body>
	<div data-role="page" id="Maincc128page">

		<div data-role="header" data-theme="b">
			<h1>Grafici dei consumi</h1>
		</div>
		
		<div data-role="main" class="ui-content ui-body-b" id="graphlist">
			<img src="${pageContext.request.contextPath}/assets/img/power-10min-l.png" alt="001"/>
			<img src="${pageContext.request.contextPath}/assets/img/power-60min-l.png" alt="001"/>
			<img src="${pageContext.request.contextPath}/assets/img/power-6h-l.png" alt="001"/>
			<img src="${pageContext.request.contextPath}/assets/img/power-1day-l.png" alt="001"/>
			<img src="${pageContext.request.contextPath}/assets/img/power-7day-l.png" alt="001"/>
			<img src="${pageContext.request.contextPath}/assets/img/power-30day-l.png" alt="001"/>
			<img src="${pageContext.request.contextPath}/assets/img/power-365day-l.png" alt="001"/>
		</div>
		
		<script>
		$(document).on("pagecreate", "#Maincc128page", function() {
			setInterval(function() {
				location.reload();
			}, 30000);  //Aggiorna ogni  30 secondi la pagina 
		});
		</script>
		
		<div data-role="footer" data-theme="b" class="ui-grid-a">
			<div class="ui-block-a" align="left">
				<a href="${pageContext.request.contextPath}/admin/principale.jsp" data-role="button" data-icon="home">Home</a>
			</div>
			<div class="ui-block-b" align="right">
				<a href="${pageContext.request.contextPath}/LogoutServlet" data-role="button" data-icon="delete">Termina</a>
			</div>
		</div>

	</div>
</body>
</html>