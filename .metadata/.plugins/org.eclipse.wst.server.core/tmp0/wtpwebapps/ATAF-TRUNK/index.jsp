<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="sessionUser" value="#session.user" />
<s:set var="sessionAdmin" value="#session.admin" />
<s:set var="loginError" value="#session.loginError" />
<s:set var="activeLink" value="#session.activeLink" />
<s:set var="defaultLang" value="#session.defaultLang" />
<s:set var="languageFlag" value="#session.languageFlag" />
<s:set var="languageList" value="#session.languageList" />
<s:set var="messageBody" value="#session.messageBody" />
<s:set var="messageFlag" value="#session.messageFlag" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<!-- <META HTTP-EQUIV="Refresh" CONTENT="0;URL=holaMundo.action" /> -->
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<link rel="stylesheet" type="text/css" href="./content/css/styles.css" />
    	<title>ATAF - Asociaci&oacute;n Talaverana de &Aacute;rbitros de F&uacute;tbol</title>
    	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    	<script type="text/javascript" language="JavaScript">
    		/* Función que se ejecuta al cargar la página */
    		function onLoad(page, languageFlag, messageFlag, messageBody) {
    			if (null != languageFlag && languageFlag) {
    				// TODO
    			} else {
	    			document.forms["languageForm"].submit(); // Formulario de idiomas
    			}
    			
    			// Página a cargar
    			switch (page) {
    				case "ADMIN":
    					$("#webBody").load("./content/views/admin/admin.jsp");
						break;
					case "REFEREE":
						$("#webBody").load("./content/views/referees.jsp");
						break;
					case "REFEREE_INFO":
						$("#webBody").load("./content/views/referee_details.jsp");
						break;
					case "USER":
						$("#webBody").load("./content/views/admin/users.jsp");
						break;
					case "USER_INFO":
						$("#webBody").load("./content/views/admin/user_details.jsp");
						break;
					case "CALENDARS":
						$(document).ready(function() {
							$("#webBody").load("./content/views/calendars.jsp");
						});
						break;
					default: 
						$(document).ready(function() {
							$("#webBody").load("./content/views/welcome.jsp");
						});
						break;
				} // End Switch
				
				// Mensajes al cargar las páginas
				if ((null != messageFlag && messageFlag) && (null != messageBody && "" != messageBody)) {
					alert(messageBody);
					// Llamada a un formulario que resetee las variables. P.Ej: index.action 
					document.forms["indexForm"].submit(); // Formulario de index
				}
    		} // End Function
    	</script>
    </head>
	<body onload="onLoad('<s:property value="#activeLink"/>', '<s:property value="#languageFlag"/>', '<s:property value="#messageFlag"/>', '<s:property value="#messageBody"/>')"><!-- onload="changeContent()"-->
		<s:div id="mainContainer" class="mainContainer">
			<s:div id="mainTitle" class="mainTitle"> <!-- Títulos superiores -->
				<s:div id="mainTitleLogo" class="mainTitleLogo">
					<a href="#" id="indexLink"> <!-- a onclick="onLoad('/ATAF/index.jsp')"-->
						<span id="atafLogo">A.T.A.F.</span>
					</a>
				</s:div>
				<s:div id="mainSubtitleLogo" class="mainSubtitleLogo">
					<span id="atafSubtitle">
						<s:property value="getText('Soccer_Referees_Talaveran_Association')"/> <!-- Asociación Talaverana de Árbitros de Fútbol -->
					</span>
				</s:div>
				<s:div id="mainSubtitleLanguage" class="mainSubtitleLanguage">
					<s:form id="languageForm" name="languageForm" action="languagesForm.action" method="post" theme="simple">
						<s:if test="%{(null != #languageFlag && #languageFlag)}">
							<span class="languageSpan"> <!-- IDIOMAS -->
								<s:property value='getText(\"Language_points\")' />
							</span>
							<s:select list="languageList" listKey="id" listValue="name" cssClass="sSelect" value="defaultLang" />
						</s:if>
					</s:form>
				</s:div>
			</s:div>
			<s:div id="mainMenu" class="mainMenu"> <!-- Menú principal -->
				<!-- SESSION -->
				<s:if test="%{(null == #sessionUser || '' == #sessionUser) && !(#sessionAdmin)}">
					<s:div id="login" class="mainMenuLoginElement">
						<s:form id="loginForm" name="loginForm" action="login.action" method="post">
							<span>
								<s:property value="getText('User_points')"/> <input type="text" id="userID" name="user.alias" /> <!-- Usuario -->
							</span>
							&nbsp;
							<span>
								<s:property value="getText('Password_points')"/> <input type="password" id="password" name="user.password" /> <!-- Contraseña -->
							</span>
							&nbsp;
							<input type="submit" id="buttonLogin" name="buttonLogin" value="<s:property value='getText(\"Send\")'/>" />
							<s:if test="%{#loginError}"> <!-- LOGIN INCORRECTO -->
								<span id="loginError" class="loginError">
									<s:property value="getText('loginError')"/>
								</span>
							</s:if>
						</s:form>
					</s:div>
				</s:if>
				<s:else>
					<s:div id="administer" class="mainMenuAdminElement">
						<a href="#" id="adminLink">
							<span title="<s:property value='getText(\"administerTitle\")'/>">
								<s:property value="getText('ADMINISTER')"/> <!-- ADMINISTRAR -->
							</span>
						</a>
					</s:div>
					<s:div id="loged" class="mainMenuLogedElement">
						<s:form id="logoutForm" name="logoutForm" action="logout.action" method="post">
							<span>
								<s:property value="getText('Welcome_user')"/> <span id="userLoged" class="userLoged"><s:property value="#sessionUser.alias"/></span> <!-- LOGOUT -->
							</span>
							&nbsp;
							<input type="submit" id="buttonLogout" name="buttonLogout" value="<s:property value='getText(\"Logout\")'/>" />
						</s:form>
					</s:div>
				</s:else>
				<s:div id="referees" class="mainMenuElement">
					<!-- <a href="./content/views/referees.jsp"> -->
					<a href="#" id="refereesLink">
						<span title="<s:property value='getText(\"refereesTitle\")'/>">
							<s:property value="getText('REFEREES')"/> <!-- ÁRBITROS -->
						</span>
					</a>
				</s:div>
				<s:div id="calendars" class="mainMenuElement">
					<a href="#">
						<span title="<s:property value='getText(\"calendarsTitle\")'/>">
							<s:property value="getText('CALENDARS')"/> <!-- CALENDARIOS -->
						</span>
					</a>
				</s:div>
				<s:div id="competitions" class="mainMenuElement">
					<a href="#">
						<span title="<s:property value='getText(\"competitionsTitle\")'/>">
							<s:property value="getText('COMPETITIONS')"/> <!-- COMPETICIONES -->
						</span>
					</a>
				</s:div>
				<s:div id="history" class="mainMenuElement">
					<a href="#">
						<span title="<s:property value='getText(\"historyTitle\")'/>">
							<s:property value="getText('HISTORY')"/> <!-- HISTORIA -->
						</span>
					</a>
				</s:div>
			</s:div> <!-- END DIV mainMenu -->
			<s:div id="webBody" class="webBody">
				<%-- <div id="imgBody" class="imgBody">
					<img src="./content/img/url.jpg" />
				</div>
				<s:div id="textBody" class="textBody">
					<span id="slogan" class="slogan">
						<s:property value='getText(\"join_together\")'/>  <!-- slogan -->
					</span>
					<br />
					<span id="telephone" class="contact">
						<s:property value='getText(\"join_together_telephone\")'/>  <!-- teléfono -->
						<s:property value='getText(\"join_together_address\")'/>  <!-- dirección -->
					</span>
					<span id="city" class="contact">
						<s:property value='getText(\"join_together_city\")'/>  <!-- ciudad -->
					</span>
				</s:div> --%>
			</s:div> <!-- END DIV webBody -->
		</s:div> <!-- END DIV container -->
		<s:form id="indexForm" name="indexForm" action="index.action" method="post" theme="simple" />
		<script type="text/javascript">
			$("#adminLink").click(function() {
				$("#webBody").load("./content/views/admin/admin.jsp");
			});
			
			$("#indexLink").click(function() {
				$("#webBody").load("./content/views/welcome.jsp");
			});
		
    		$("#refereesLink").click(function() {
				$("#webBody").load("./content/views/referees.jsp");
			});
    	</script>
	</body>
</html>