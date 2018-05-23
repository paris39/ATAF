<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<s:set var="refereeFlag" value="#session.refereeFlag" />
<s:set var="sessionUser" value="#session.user" />
<s:set var="sessionAdmin" value="#session.admin" />
<s:set var="refereeResult" value="#session.refereeResult" />
<s:set var="seasonsList" value="#session.seasonsList" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/styles.css" />
		<title>&Aacute;rbitros</title>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
		<script type="text/javascript" language="JavaScript">
			function formReset() {
				document.forms["refereeListForm"].reset();
				document.forms["refereeFormReset"].submit();
			}
			
			function openReferee(url) {
				open(url, "", "top=300, left=300, width=300, height=300");
			}
		</script>
	</head>
	<body>
		<s:div id="refereeInfo" class="refereeInfo">
			<fieldset class="">
				<legend>
					<s:property value='getText(\"referee.PersonalData\")' />
				</legend>
				<s:if test="%{(null != #sessionUser) && (#sessionAdmin)}">
					<s:div class="personalDataDiv personalDataIdDiv">
						<s:textfield id="refereeIdTextfield" cssClass="sTextfield" label='%{getText("referee.ID")}' value="%{#refereeResult.id}" readonly="true" />
					</s:div>
			    </s:if>
				<s:div class="personalDataDiv"> <!-- APELLIDOS -->
					<s:textfield id="refereeSurnameTextfield" cssClass="sTextfield" label='%{getText("referee.Surname")}' value="%{#refereeResult.surname}" readonly="true" />
				</s:div>
				<s:div class="personalDataDiv"> <!-- NOMBRE -->
					<s:textfield id="refereeNameTextfield" cssClass="sTextfield" label='%{getText("referee.Name")}' value="%{#refereeResult.name}" readonly="true" />
				</s:div>
				<s:div class="personalDataDiv"> <!-- DNI -->
					<s:textfield id="refereeDniTextfield" cssClass="sTextfield" label='%{getText("referee.DNI")}' value="%{#refereeResult.dni}" readonly="true" />
				</s:div>
				<s:div class="personalDataDiv"> <!-- FECHA DE NACIMIENTO -->
					<s:textfield id="refereeBirthdateTextfield" cssClass="sTextfield" label='%{getText("referee.Birthdate")}' value="%{getText('format.date', {#refereeResult.birthdate})}" readonly="true" />
				</s:div>
				<s:div class="personalDataDiv"> <!-- DIRECCIÓN -->
					<s:textfield id="refereeAddressTextfield" cssClass="sTextfield" label='%{getText("referee.Address")}' value="%{#refereeResult.address}" readonly="true" />
				</s:div>
				<s:div class="personalDataDiv"> <!-- PAÍS -->
					<s:textfield id="refereeCountryTextfield" cssClass="sTextfield" label='%{getText("referee.Country")}' value="%{#refereeResult.country}" readonly="true" />
				</s:div>
				<s:if test="%{(null != #sessionUser) && (#sessionAdmin)}">
					<s:div class="personalDataDiv"> <!-- ALIAS -->
						<s:textfield id="refereeAliasTextfield" cssClass="sTextfield" label='%{getText("referee.Alias")}' value="%{#refereeResult.alias}" readonly="true" />
					</s:div>
					<s:form id="modifyRefereeForm" name="modifyRefereeForm" action="" method="post" theme="simple">
						<s:div class="modifyRefereeDiv">  <!-- MODIFICAR ÁRBITRO -->
							<s:submit cssClass="sButton" id="buttonMofifyReferee" name="buttonMofifyReferee" title="%{getText('referee.Modify_points') + ' ' + #refereeResult.surname}" value="%{getText('Modify')}" />
						</s:div>
					</s:form>
			    </s:if>
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