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

	<title>Dati in tempo reale</title>
</head>

<body>

	<div data-role="page" id="livedatapage">

		<div data-role="header" data-theme="b">
			<h1>Dati in tempo reale</h1>
		</div>
		
		<div data-role="main" class="ui-content ui-body-b" id="dinamicdiv">
			<style>
      			.auto-text-area{
        			min-height: 20px; /* for default height */
        			overflow: hidden;
        			resize: none;
        			padding: 4px;
        			font-size: 22px;
        			border: 1px solid #000;
      				}
 	   		</style>
 	   		
			<div data-role="fieldcontain">
				<label for="textarea-a">Data di acquisizione </label>
				<textarea class="auto-text-area" name="textarea" id="textarea-a">
				</textarea>
			</div>
			
			<div data-role="fieldcontain">
				<label for="textarea-b">Consumo istantaneo W </label>
				<textarea class="auto-text-area" name="textarea" id="textarea-b">
				</textarea>
			</div>
		
			<div data-role="fieldcontain">
				<label for="textarea-c">Temperatura istantanea �C </label>
				<textarea class="auto-text-area" name="textarea" id="textarea-c">
				</textarea>
			</div>
		</div>
		
		<script>
		// Funzione chiamata ogni x secondi che chiama sul server tramite una post una funziona java che effettua il calcolo
		// degli ultimi parametri letti sul database powertemp.rrd e li ritorna allo script stesso
		//
			$(document).on("pageshow", "#livedatapage", function() {
				
				myInterval = setInterval(function() {
					$.post("${pageContext.request.contextPath}/Livedata",{azione:"calc"}, function (retval) {
						var fields = retval.toString().split(",");
						if(fields[2]) {
							$(".ui-header .ui-title").text("Dati in tempo reale (" + fields[2] + ")");
						}
						else {
							var elems = fields[1].split("-");
							$("#textarea-a").text(elems[0]);	// Data di acquisizione
							$("#textarea-b").text(elems[1]);	// Consumo istantaneo
							$("#textarea-c").text(elems[2]);	// Temperatura istantanea
							$(".ui-header .ui-title").text("Dati in tempo reale (Age: " + elems[3] + "s)");
						}
					})
				}, 5000);  //Aggiorna ogni 5 secondi i parametri live								
			});

			$(document).on("pagehide", "#livedatapage", function() {
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