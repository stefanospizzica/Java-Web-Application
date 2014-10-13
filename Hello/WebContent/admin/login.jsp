<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width/2, initial-scale=1">

	<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/jquery.mobile-1.4.4.css">
	<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/theme-classic.css" />
	<script src="${pageContext.request.contextPath}/jquery-1.11.1.js"></script>
	<script	src="${pageContext.request.contextPath}/jquery.mobile-1.4.4.js"></script>

	<title>Autenticazione</title>
</head>

<body>
	<div data-role="page" id="loginpage">

		<div data-role="header" data-theme="b" align="center">
			<b>Benvenuto in Stesim</b>
		</div>

		<div data-role="main" class="ui-content ui-body-b">
			<div align="center">
				<img align="middle" src="${pageContext.request.contextPath}/assets/img/domotica.jpg" width="300" height="180" alt="domotica" />
			</div>

			<form name="autenticazione" method="POST" action="j_security_check" id="loginform">
				Utente <br> 
				<input type="text" name="j_username" placeholder="Inserire codice utente" data-theme="b" required /><br>
				Codice di accesso <br> 
				<input type="password" name="j_password" placeholder="Inserire codice di accesso" data-theme="b" required /><br>
				
				<fieldset class="ui-grid-c">
					<div class="ui-block-a">			
						
					</div>
					<div class="ui-block-b">
						<input type="submit" value="Autenticati" data-inline=true data-icon="check" data-theme="b">
					</div>
					<div class="ui-block-c">			
						
					</div>
				</fieldset>
			
			</form>
		</div>

		<div data-role="footer" data-theme="b" align="center">
			<i>Sito Mobile http://stesim.no-ip.com</i>
		</div>

	</div>
</body>
</html>