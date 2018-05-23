<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="refereeCancelModify" value="getText('referee.CancelModify')" />
<s:set var="refereeCancelModifyMessage" value="getText(\'referee.cancelModifyMessage\')" />
<s:set var="refereeCssClassTextField" value="#session.refereeCssClassTextField" />
<s:set var="refereeFlag" value="#session.refereeFlag" />
<s:set var="refereeModifyFlag" value="#session.refereeModifyFlag" />
<s:set var="refereeReadOnly" value="#session.refereeReadOnly" />
<s:set var="refereeResult" value="#session.refereeResult" />
<s:set var="refereeUpdateMessage" value="getText(\'referee.updateMessage\')" />
<s:set var="sessionAdmin" value="#session.admin" />
<s:set var="seasonsList" value="#session.seasonsList" />
<s:set var="sessionUser" value="#session.user" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/styles.css" />
		<title>&Aacute;rbitros</title>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
		<script type="text/javascript" language="JavaScript">
		    /* Función que mediante el flag de modificar muestra un mensaje de confirmación a la hora de modificar un árbitro */
    		function confirmRefereeUpdate(refereeModifyFlag, message) {
    			if (null != refereeModifyFlag && "true" == refereeModifyFlag) {
					if (confirm(message)) {
						return true;
					} else {
						return false;
					}
				}
			} // End function
			
			/* Función que cancela la modificación de árbitro */
			function cancelModifyReferee(message) {
				if (confirm(message)) {
					document.forms["cancelModifyRefereeForm"].submit(); // Formulario de cancelación de modificación de árbitro
				}
			}
		</script>
	</head>
	<body>
		<s:div id="refereeInfo" class="tableInfo">
			<fieldset class="">
				<legend>
					<s:property value='getText(\"referee.PersonalData\")' />
				</legend>
				<s:form id="modifyRefereeForm" name="modifyRefereeForm" action="modifyReferee.action" method="post" theme="simple" onsubmit="return confirmRefereeUpdate('%{#refereeModifyFlag}', '%{#refereeUpdateMessage}')">
					<s:if test="%{(null != #sessionUser) && (#sessionAdmin)}">
						<s:div class="personalDataDivReadOnly personalDataIdDiv">
							<span>
								<s:property value='getText(\"referee.ID_points\")' />
							</span>
							<s:textfield id="refereeIdTextfield" name="referee.id" cssClass="sTextfield" label='%{getText("referee.ID")}' value="%{#refereeResult.id}" readonly="true" />
						</s:div>
				    </s:if>
					<s:div class="%{#refereeCssClassTextField}"> <!-- APELLIDOS -->
						<span>
							<s:property value='getText(\"referee.Surname_points\")' />
						</span>
						<s:textfield id="refereeSurnameTextfield" name="referee.surname" cssClass="sTextfield" label='%{getText("referee.Surname")}' value="%{#refereeResult.surname}" readonly="%{#refereeReadOnly}" />
					</s:div>
					<s:div class="%{#refereeCssClassTextField}"> <!-- NOMBRE -->
						<span>
							<s:property value='getText(\"referee.Name_points\")' />
						</span>
						<s:textfield id="refereeNameTextfield" name="referee.name" cssClass="sTextfield" label='%{getText("referee.Name")}' value="%{#refereeResult.name}" readonly="%{#refereeReadOnly}" />
					</s:div>
					<s:div class="%{#refereeCssClassTextField}"> <!-- DNI -->
						<span>
							<s:property value='getText(\"referee.DNI_points\")' />
						</span>
						<s:textfield id="refereeDniTextfield" name="referee.dni" cssClass="sTextfield" label='%{getText("referee.DNI")}' value="%{#refereeResult.dni}" readonly="%{#refereeReadOnly}" />
					</s:div>
					<s:div class="%{#refereeCssClassTextField} personalDataDateDiv"> <!-- FECHA DE NACIMIENTO -->
						<span>
							<s:property value='getText(\"referee.Birthdate_points\")' />
						</span>
						<s:textfield id="refereeBirthdateTextfield" name="referee.birthdate" cssClass="sTextfield" label='%{getText("referee.Birthdate")}' value="%{getText('format.date', {#refereeResult.birthdate})}" readonly="%{#refereeReadOnly}" />
					</s:div>
					<s:div class="%{#refereeCssClassTextField}"> <!-- DIRECCIÓN -->
						<span>
							<s:property value='getText(\"referee.Address_points\")' />
						</span>
						<s:textfield id="refereeAddressTextfield" name="referee.address" cssClass="sTextfield" label='%{getText("referee.Address")}' value="%{#refereeResult.address}" readonly="%{#refereeReadOnly}" />
					</s:div>
					<s:if test="%{(null != #refereeModifyFlag && #refereeModifyFlag)}">					
						<s:div class="%{#refereeCssClassTextField}"> <!-- CIUDAD -->
							<span>
								<s:property value='getText(\"referee.City_points\")' />
							</span>
							<s:textfield id="refereeCityTextfield" name="referee.city" cssClass="sTextfield" label='%{getText("referee.City")}' value="%{#refereeResult.city}" readonly="%{#refereeReadOnly}" />
						</s:div>
						<s:div class="%{#refereeCssClassTextField}"> <!-- PAÍS -->
							<span>
								<s:property value='getText(\"referee.Country_points\")' />
							</span>
							<s:textfield id="refereeCountryTextfield" name="referee.country" cssClass="sTextfield" label='%{getText("referee.Country")}' value="%{#refereeResult.country}" readonly="%{#refereeReadOnly}" />
						</s:div>
					</s:if>
					<s:else>
						<s:div class="personalDataDivReadOnly"> <!-- CIUDAD (PAÍS) -->
							<span>
								<s:property value='getText(\"referee.City_points\")' />
							</span>
							<s:textfield id="refereeCityTextfield" cssClass="sTextfield" label='%{getText("referee.City")}' value="%{#refereeResult.city  + ' ' + '(' + #refereeResult.country + ')'}" readonly="%{#refereeReadOnly}" />
						</s:div>
					</s:else>
					<s:if test="%{(null != #sessionUser) && (#sessionAdmin)}">
						<s:div class="personalDataDivReadOnly"> <!-- ALIAS -->
							<span>
								<s:property value='getText(\"referee.Alias_points\")' />
							</span>
							<s:textfield id="refereeAliasTextfield" name="referee.alias" cssClass="sTextfield" label='%{getText("referee.Alias")}' value="%{#refereeResult.alias}" readonly="true" />
						</s:div>
						<s:div class="modifyRefereeDiv">  <!-- MODIFICAR o GUARDAR ÁRBITRO -->
							<s:if test="%{(null != #refereeModifyFlag && #refereeModifyFlag)}">
								<s:submit cssClass="sButton" id="buttonSaveModifiedReferee" name="buttonModifiedReferee" title="%{getText('referee.Save_points') + ' ' + #refereeResult.surname}" value="%{getText('Save')}" />
								<!-- input type="button" class="sButton" id="cancelModifyReferee" name="cancelModifyReferee" title="%{getText('referee.CancelModify')}" value="<s:property value='getText(\"Cancel\")'/>" onclick="cancelModifyReferee('%{#refereeCancelModifyMessage}')" /-->
								<a href="#" onclick="cancelModifyReferee('<s:property value='#refereeCancelModifyMessage'/>')" class="sButton" title="<s:property value='#refereeCancelModify'/>" id="buttonLink">
									<s:property value="%{getText('Cancel')}" />
								</a>
								<!-- s:reset cssClass="sButton" id="cancelModifyReferee" name="cancelModifyReferee" title="%{getText('referee.CancelModify')}" value="%{getText('Cancel')}" onclick="cancelModifyReferee('%{#refereeCancelModifyMessage}')" /-->
							</s:if>
							<s:else>
								<s:submit cssClass="sButton" id="buttonModifyReferee" name="buttonModifyReferee" title="%{getText('referee.Modify_points') + ' ' + #refereeResult.surname}" value="%{getText('Modify')}" />
							</s:else>
						</s:div>
				    </s:if>
			    </s:form>
			    <s:form name="cancelModifyRefereeForm" id="cancelModifyRefereeForm" action="cancelModifyReferee.action" method="post" theme="simple" />
			</fieldset>
			<fieldset class="refereeDataFieldset">
				<legend>
					<s:property value='getText(\"referee.RefereeData\")' />
				</legend>
				<s:div class="refereeDataDivRight">
					<span class="seasonSpan"> <!-- TEMPORADAS -->
						<s:property value='getText(\"referee.Season_points\")' />
					</span>
					<s:select list="seasonsList" listKey="id" listValue="name" cssClass="sSelect" headerKey="0" headerValue="%{getText('referee.SeasonsAll')}" />
				</s:div>
				<s:div class="refereeDataDiv">
					<s:textfield id="refereeSurnameTextfield" cssClass="sTextfield" label='%{getText("referee.Surname")}' value="%{#refereeResult.surname}" disabled="true" />
				</s:div>
			</fieldset>
		</s:div>
	</body>
</html>