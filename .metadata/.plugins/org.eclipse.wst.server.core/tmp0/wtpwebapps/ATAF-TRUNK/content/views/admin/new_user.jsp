<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="sessionUser" value="#session.user" />
<s:set var="sessionAdmin" value="#session.admin" />
<s:set var="userAddMessage" value="getText('user.addMessage')" />
<s:set var="userCancelAdd" value="getText('user.CancelAdd')" />
<s:set var="userCancelAddMessage" value="getText('user.cancelAddMessage')" />
<s:set var="user_aliasMessage" value="getText('user.error_AliasField')" />
<s:set var="user_emailMessage" value="getText('user.error_EmailField')" />
<s:set var="user_passwordMessage" value="getText('user.error_PasswordField')" />
<s:set var="user_repeatPassMessage" value="getText('user.error_RepeatPasswordField')" />
<s:set var="user_notEqualsPassMessage" value="getText('user.error_PasswordsNotEquals')" />
<s:set var="user_nameMessage" value="getText('user.error_NameField')" />
<s:set var="user_surnameMessage" value="getText('user.error_SurnameField')" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../../css/styles.css" />
		<title>¡HAZTE &Aacute;RBITRO</title>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
		<script type="text/javascript" language="JavaScript">
		    /* Función que mediante el flag de modificar muestra un mensaje de confirmación a la hora de modificar un usuario */
    		function confirmAddUser(mainMessage, aliasMessage, passMessage, repeatPassMessage, notEqualsPassMessage, nameMessage, surnameMessage, emailMessage) {
    			// Evaluación de campos obligatorios y características
    			var alias = /^[A-Za-z][0-9A-Za-z_\-]{4,}[A-Za-z0-9]$/;
    			var pass = /^[\w]{8,15}$/;
    			var name = /^[A-Z]{1}[A-Za-z\s]+$/; // También válido para surname
    			var email = /^[^0-9][a-z0-9_\.]+@[a-z]+\.*[a-z]*[a-z]+\.[a-z]{2,3}$/;
    			
    			if (!alias.test(document.forms["addUserForm"].userAliasTextfield.value)) { // Alias
    				alert(aliasMessage);
    				document.forms["addUserForm"].userAliasTextfield.focus();
    				return false;
    			}
    			if (!pass.test(document.forms["addUserForm"].userPasswordTextfield.value)) { // Password
    				alert(passwordMessage);
    				document.forms["addUserForm"].userPasswordTextfield.focus();
    				return false;
    			}
    			if (!pass.test(document.forms["addUserForm"].userRepeatPasswordTextfield.value)) { // Repeat Password
    				alert(repeatPassMessage);
    				document.forms["addUserForm"].userRepeatPasswordTextfield.focus();
    				return false;
    			}
    			if (!(document.forms["addUserForm"].userPasswordTextfield.value == document.forms["addUserForm"].userRepeatPasswordTextfield.value)) { // Passwords Equal
					alert(notEqualsPassMessage);
					document.forms["addUserForm"].userPasswordTextfield.focus();
					return false;
				}
    			if (!name.test(document.forms["addUserForm"].userNameTextfield.value)) { // Name
    				alert(nameMessage);
    				document.forms["addUserForm"].userNameTextfield.focus();
    				return false;
    			}
    			if (!name.test(document.forms["addUserForm"].userSurnameTextfield.value)) { // Surname
    				alert(surnameMessage);
    				document.forms["addUserForm"].userSurnameTextfield.focus();
    				return false;
    			}
    			if (!email.test(document.forms["addUserForm"].userEmailTextfield.value)) { // Email
    				alert(emailMessage);
    				document.forms["addUserForm"].userEmailTextfield.focus();
    				return false;
    			}
    			
				if (confirm(mainMessage)) {
					return true;
				} else {
					return false;
				}
			} // End function
			
			/* Función que cancela la modificación de usuario */
			function cancelAddUser(message) {
				if (confirm(message)) {
					document.forms["cancelAddUserForm"].submit(); // Formulario de cancelación de modificación de usuario
				}
			}
		</script>
	</head>
	<body>
		<s:if test="%{(null != #sessionUser) && (#sessionAdmin)}">
			<s:div id="newUserDiv" class="tableInfo">
				<fieldset class="">
					<legend>
						<s:property value='getText(\"user.PersonalData\")' />
					</legend>
					<s:form id="addUserForm" name="addUserForm" action="addUser.action" method="post" theme="simple" onsubmit="return confirmAddUser('%{#userAddMessage}', '%{#user_aliasMessage}', '%{#user_passwordMessage}', '%{#user_repeatPassMessage}', '%{#user_notEqualsPassMessage}', '%{#user_nameMessage}', '%{#user_surnameMessage}', '%{#user_emailMessage}')">
						<s:div class="messageObligatoriyFields"> <!--  Mensaje de campos obligatorios -->
							<span>
								<s:property value='getText(\"messageObligatoriyFields\")' />
							</span>
						</s:div>
						<s:div class="personalDataDiv"> <!-- ALIAS -->
							<span>
								<s:property value='getText(\"user.Alias_points\")' />
							</span>
							<s:textfield id="userAliasTextfield" name="user.alias" cssClass="sTextfield" label='%{getText("user.Alias")}' />
						</s:div>
						<s:div class="personalDataDiv"> <!-- PASSWORD -->
							<span>
								<s:property value='getText(\"user.Password_points\")' />
							</span>
							<s:password id="userPasswordTextfield" name="user.password" cssClass="sTextfield" label='%{getText("user.Password")}' />
						</s:div>
						<s:div class="personalDataDiv"> <!-- REPETIR PASSWORD -->
							<span>
								<s:property value='getText(\"user.PasswordRepeat_points\")' />
							</span>
							<s:password id="userRepeatPasswordTextfield" name="user.repeatPassword" cssClass="sTextfield" label='%{getText("user.PasswordRepeat")}' />
						</s:div>
						<s:div class="personalDataDiv"> <!-- NOMBRE -->
							<span>
								<s:property value='getText(\"user.Name_points\")' />
							</span>
							<s:textfield id="userNameTextfield" name="user.name" cssClass="sTextfield" label='%{getText("user.Name")}' />
						</s:div>
						<s:div class="personalDataDiv"> <!-- APELLIDOS -->
							<span>
								<s:property value='getText(\"user.Surname_points\")' />
							</span>
							<s:textfield id="userSurnameTextfield" name="user.surname" cssClass="sTextfield" label='%{getText("user.Surname")}' />
						</s:div>
						<s:div class="personalDataDiv"> <!-- EMAIL -->
							<span>
								<s:property value='getText(\"user.Email_points\")' />
							</span>
							<s:textfield id="userEmailTextfield" name="user.email" cssClass="sTextfield" label='%{getText("user.Email")}' />
						</s:div>
						<s:div class="buttonPadForm">
							<s:submit cssClass="sButton" id="buttonAddUser" name="buttonAddUser" title="%{getText('user.AddUser')}" value="%{getText('user.AddUser')}" />
							<s:reset cssClass="sButton" id="buttonAddResetUser" name="buttonAddResetUser" title="%{getText('user.ResetAdd')}" value="%{getText('Reset')}" />
							<a href="#" onclick="cancelAddUser('<s:property value='#userCancelAddMessage'/>')" class="sButton" title="<s:property value='#user.CancelAddUser'/>" id="buttonLink">
								<s:property value="%{getText('Cancel')}" />
							</a>
						</s:div>
					</s:form>
					<s:form name="cancelAddUserForm" id="cancelAddUserForm" action="cancelAddUser.action" method="post" theme="simple" />
				</fieldset>
			</s:div>
		</s:if>
	</body>
</html>