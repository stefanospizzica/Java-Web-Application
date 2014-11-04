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
	<%@ page import="java.io.*" %>
	<%
		try {
			String s = null;
			Runtime r =Runtime.getRuntime();
			String cmd = "sudo /home/pi/create-graph-param.sh 800 600";
			Process p = r.exec(cmd);
			p.waitFor();
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			while ((s = stdError.readLine()) != null) {
                log(s);
            }
			p.destroy();
		} catch(Exception e) {
			log(e.toString());
		}
	%>

	<div data-role="page" id="Maincc128page">

		<div data-role="header" data-theme="b">
			<h1>Grafici dei consumi</h1>
		</div>
		
		<div data-role="popup" id="calcpopup">
			<p>Elaborazione grafici in corso</p>
		</div>
		
		<div data-role="main" class="ui-content ui-body-b" id="graphlist">
			
			<img src="${pageContext.request.contextPath}/assets/img/power-10min-l.png" style="width: 90%;" alt="001"/>
			<img src="${pageContext.request.contextPath}/assets/img/power-60min-l.png" style="width: 90%;" alt="001"/>
			<img src="${pageContext.request.contextPath}/assets/img/power-6h-l.png" style="width: 90%;" alt="001"/>
			<img src="${pageContext.request.contextPath}/assets/img/power-1day-l.png" style="width: 90%;"alt="001"/>
			<img src="${pageContext.request.contextPath}/assets/img/power-7day-l.png" style="width: 90%;" alt="001"/>
			<img src="${pageContext.request.contextPath}/assets/img/power-30day-l.png" style="width: 90%;" alt="001"/>
			<img src="${pageContext.request.contextPath}/assets/img/power-365day-l.png" style="width: 90%;" alt="001"/>
			
		</div>
		
		<script>
			$(document).on("pageshow", "#Maincc128page", function() {
					myInterval = setInterval(function() {
					location.reload();
					$("#calcpopup" ).popup( "open" );
				}, 120000);  //Aggiorna ogni  120 secondi la pagina 		
			});

			$(document).on("pagehide", "#Maincc128page", function() {
				clearInterval(myInterval); 		
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