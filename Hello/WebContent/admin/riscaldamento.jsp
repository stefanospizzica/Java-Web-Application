<%@ page import="it.stefano.sw.Temporizzazione"%>
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

	<title>Gestione riscaldamento</title>
</head>

<body>
	<div data-role="page" id="riscaldamentopage" data-cache="false">

		<div data-role="header" data-theme="b">
			<h1>Cronotermostato</h1>
		</div>
		
		<div data-role="popup" id="refreshpopup">
			<p>Aggiornamento database in corso</p>
		</div>

		<div data-role="main" class="ui-body ui-body-b">

			<div data-role="fieldcontain">
				<fieldset class="ui-grid-b">
		
					<div class="ui-block-a" align="left">
						<div class="ui-field-contain" style="font-size:25px" data-name="tempdiv">
							dummy
						</div>				
					</div>
					
					<div class="ui-block-c" align="center">
						<label for="flip-crono">Stato</label>
						<select	name="flip-crono" id="flip-crono" data-role="flipswitch" data-mini="true">
							<option value="off">Off</option>
							<option value="on">On</option>
						</select>
					</div>
					
					<div class="ui-block-c" align="right">				
						<div class="ui-field-contain" style="font-size:25px" data-name="umiddiv">
							dummy 
						</div>
					</div>
				</fieldset>
			</div>
				
			<div data-role="fieldcontain" data-name="ultimodiv" style="font-size:15px" align="center">	
				dummy
			</div>
							
			<div data-role="fieldcontain" id="temperaturearea">
				<fieldset class="ui-grid-a">
					<div class="ui-block-a">
						<div data-role="fieldcontain">
							<label for="low-temp">�C Spento</label>
							<input type="range"	name="low-temp" id="low-temp" value="15" min="15" max="25" step="0.2" />
						</div>
					</div>				

					<div class="ui-block-b">
						<div data-role="fieldcontain">
							<label for="hi-temp">�C Acceso</label>
							<input type="range"	name="hi-temp" id="hi-temp" value="15" min="15" max="25" step="0.2" />
						</div>
					</div>				
				</fieldset>
			
				<fieldset class="ui-grid-a">
					<div class="ui-block-a">
						<div data-role="fieldcontain">
							<label for="safe-temp">�C safe</label>
							<input type="range" name="safe-temp" id="safe-temp" value="15" min="15"	max="20" step="0.5" />
						</div>
					</div>
					<div class="ui-block-b">	
						<div data-role="fieldcontain">
							<label for="hyst-temp">Isteresi</label>
							<input type="range" name="hyst-temp" id="hyst-temp" value="0.5" min="0"	max="1" step="0.1" />
						</div>
					</div>
				</fieldset>
			</div>
			
			<div data-role="fieldcontain">
				<form id="dayweek">
					<fieldset data-role="controlgroup" data-type="horizontal" data-mini="true">
						<legend>
							<i>Programmazione Settimanale</i>
						</legend>
						<input type="radio" name="radio-lu" id="radio-lu" value="LU" />
						<label for="radio-lu">Lu</label>
						<input type="radio" name="radio-ma" id="radio-ma" value="MA" />
						<label for="radio-ma">Ma</label>
						<input type="radio" name="radio-me" id="radio-me" value="ME" />
						<label for="radio-me">Me</label>
						<input type="radio" name="radio-gi" id="radio-gi" value="GI" />
						<label for="radio-gi">Gi</label>
						<input type="radio" name="radio-ve" id="radio-ve" value="VE" />
						<label for="radio-ve">Ve</label>
						<input type="radio" name="radio-sa" id="radio-sa" value="SA" />
						<label for="radio-sa">Sa</label>
						<input type="radio" name="radio-do" id="radio-do" value="DO" />
						<label for="radio-do">Do</label>
					</fieldset>
				</form>
		
				<style type="text/css"> .ui-input-text { width: 50%;}</style>
				
				<div data-role="fieldcontain" id="programmazione">
					<fieldset class="ui-grid-a">
						<div class="ui-block-a">
							<label for="time-on1">Accensione</label> <input type="time"	name="time-on1" id="time-on1" value=""	class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset">
						</div>
						<div class="ui-block-b">
							<label for="time-off1">Spegnimento</label> <input type="time" name="time-off1" id="time-off1" value="" class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset">
						</div>
					</fieldset>

					<fieldset class="ui-grid-a">
						<div class="ui-block-a">
							<input type="time"	name="time-on2" id="time-on2" value=""	class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset">
						</div>
						<div class="ui-block-b">
							<input type="time" name="time-off2" id="time-off2" value="" class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset">
						</div>
					</fieldset>

					<fieldset class="ui-grid-a">
						<div class="ui-block-a">
							<input type="time"	name="time-on3" id="time-on3" value=""	class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset">
						</div>
						<div class="ui-block-b">
							<input type="time" name="time-off3" id="time-off3" value=""	class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset">
						</div>
					</fieldset>

					<fieldset class="ui-grid-a">
						<div class="ui-block-a">
							<input type="time"	name="time-on4" id="time-on4" value=""	class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset">
						</div>
						<div class="ui-block-b">
							<input type="time" name="time-off4" id="time-off4" value=""	class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset">
						</div>
					</fieldset>
				</div>
			
			</div>

			<fieldset class="ui-grid-a">
				<div class="ui-block-a" align="center">
					<input type="button" data-icon="check" id="invio" value="Conferma" name="invio" />
				</div>
				<div class="ui-block-b" align="center">
					<input type="button" data-icon="refresh" id="rfrsh" value="Aggiorna" name="rfrsh" />
				</div>				
			</fieldset>
			
			<script>
				$(document).on('pagecreate', '#riscaldamentopage', function() {  
						<%
						Temporizzazione t=(Temporizzazione) session.getAttribute("ORARI");
						if(session.getAttribute("GIORNO") == "LU"){	%>$('#radio-lu').prop("checked",true).checkboxradio("refresh");<% }
						if(session.getAttribute("GIORNO") == "MA"){ %>$('#radio-ma').prop("checked",true).checkboxradio("refresh");<% }
						if(session.getAttribute("GIORNO") == "ME"){	%>$('#radio-me').prop("checked",true).checkboxradio("refresh");<% }
						if(session.getAttribute("GIORNO") == "GI"){	%>$('#radio-gi').prop("checked",true).checkboxradio("refresh");<% }
						if(session.getAttribute("GIORNO") == "VE"){	%>$('#radio-ve').prop("checked",true).checkboxradio("refresh");<% }
						if(session.getAttribute("GIORNO") == "SA"){	%>$('#radio-sa').prop("checked",true).checkboxradio("refresh");<% }
						if(session.getAttribute("GIORNO") == "DO"){	%>$('#radio-do').prop("checked",true).checkboxradio("refresh");<% }
						%>
						
						$('#flip-crono').val("<%=session.getAttribute("STATOCRONOTERMOSTATO")%>").flipswitch("refresh");
						$('#low-temp').val("<%=session.getAttribute("TEMPERATURA_MINIMA")%>").slider("refresh");
						$('#hi-temp').val("<%=session.getAttribute("TEMPERATURA_MASSIMA")%>").slider("refresh");
						$('#safe-temp').val("<%=session.getAttribute("TEMPERATURA_SICUREZZA")%>").slider("refresh");
						$('#hyst-temp').val("<%=session.getAttribute("ISTERESI")%>").slider("refresh");
						
						$('input[id=time-on1]').val("<%=t.GetStart1().toString()%>");
						$('input[id=time-off1]').val("<%=t.GetEnd1().toString()%>");

						$('input[id=time-on2]').val("<%=t.GetStart2().toString()%>");
						$('input[id=time-off2]').val("<%=t.GetEnd2().toString()%>");

						$('input[id=time-on3]').val("<%=t.GetStart3().toString()%>");
						$('input[id=time-off3]').val("<%=t.GetEnd3().toString()%>");

						$('input[id=time-on4]').val("<%=t.GetStart4().toString()%>");
						$('input[id=time-off4]').val("<%=t.GetEnd4().toString()%>");
						
						if ($("#flip-crono").val() === "off") {
							$('#programmazione').addClass("ui-disabled");
							$('#programmazione').prop("disabled", true);
							$('#temperaturearea').addClass("ui-disabled");
							$('#temperaturearea').prop("disabled", true);
						} else {
							$('#programmazione').removeClass("ui-disabled");
							$('#temperaturearea').removeClass("ui-disabled");
						}
							
						
						$('[data-name="tempdiv"]').text("<%=session.getAttribute("TEMPERATURA_ULTIMA")%>�C");
						$('[data-name="umiddiv"]').text("<%=session.getAttribute("UMIDITA_ULTIMA")%>%");
						$('[data-name="ultimodiv"]').text("Aggiornato al <%=session.getAttribute("LETTURA_ULTIMA")%>");
						
						$(document).on('change', '[type="radio"]', function(){
							day=$(this).val();
							$.post("${pageContext.request.contextPath}/Riscaldamento",{azione:"cambiogiorno",dayselected:day}, function (retval){
								location.reload();
							});
						}); 
						
						$(document).on('change', '#flip-crono', function(){
							st=$(this).val();
							if (st === "off") {
								$('#programmazione').addClass("ui-disabled");
								$('#programmazione').prop("disabled", true);
								$('#temperaturearea').addClass("ui-disabled");
								$('#temperaturearea').prop("disabled", true);
							} else {
								$('#programmazione').removeClass("ui-disabled");
								$('#temperaturearea').removeClass("ui-disabled");
							}
						}); 
						
						$(document).on('click', '#invio', function(){
							vcronotermostato = 	$('#flip-crono').val();
							vlowtemp =         	$('#low-temp').val();
							vhitemp =          	$('#hi-temp').val();
							vsafetemp =        	$('#safe-temp').val();
							vhysttemp =        	$('#hyst-temp').val();
							giorno_ = 		   	"<%=session.getAttribute("GIORNO")%>";
							t1on_ = 			$('input[id=time-on1]').val(),
							t1off_ = 			$('input[id=time-off1]').val(),
							t2on_ = 			$('input[id=time-on2]').val(),
							t2off_ = 			$('input[id=time-off2]').val(),
							t3on_ = 			$('input[id=time-on3]').val(),
							t3off_ = 			$('input[id=time-off3]').val(),
							t4on_ = 			$('input[id=time-on4]').val(),
							t4off_ = 			$('input[id=time-off4]').val()
							
							if(t1off_ < t1on_){
								alert("Errore nel range di orario 1");
								return;
							}
							if(t2off_ < t2on_){
								alert("Errore nel range di orario 2");
								return;
							}
							if(t3off_ < t3on_){
								alert("Errore nel range di orario 3");
								return;
							}
							if(t4off_ < t4on_){
								alert("Errore nel range di orario 4");
								return;
							}
							
							$.post("${pageContext.request.contextPath}/Riscaldamento",{azione:"conferma",
													ct:vcronotermostato,
													lt:vlowtemp,
													ht:vhitemp,
													st:vsafetemp,
													hyt:vhysttemp,
													g:giorno_,
													t1on: t1on_,
													t1off:t1off_,
													t2on: t2on_,
													t2off:t2off_,
													t3on: t3on_,
													t3off:t3off_,
													t4on: t4on_,
													t4off:t4off_,
													}, function (retval) {
														$("#refreshpopup" ).popup( "open" );
														location.reload();
													});
						}); 

						$(document).on('click', '#rfrsh', function(){
							location.reload();
						}); 
				});
			</script>
		</div>

		<div data-role="footer" data-theme="b" class="ui-grid-a">
			<fieldset class="ui-grid-a">
				<div class="ui-block-a" align="left">
					<a href="${pageContext.request.contextPath}/admin/principale.jsp" data-role="button" data-icon="home">Home</a>
				</div>
				<div class="ui-block-b" align="left">		
					<%=session.getAttribute("ULTIMAMODIFICA")%><i> Ultima modifica</i>
				</div>
			</fieldset>
		</div>

	</div>
	
</body>
</html>
