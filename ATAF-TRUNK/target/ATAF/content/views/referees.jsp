<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<s:set var="refereeFlag" value="#session.refereeFlag" />
<s:set var="sessionUser" value="#session.user" />
<s:set var="sessionAdmin" value="#session.admin" />
<s:set var="refereeLastSearch" value="#session.refereeLastSearch" />
<s:set var="refereeListResult" value="#session.refereeListResult" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/styles.css" />
		<title>&Aacute;rbitros</title>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
		<script type="text/javascript">
			function formReset() {
				document.forms["refereeListForm"].reset();
				document.forms["refereeFormReset"].submit();
			}
			
			function openReferee(url) {
				open(url, "", "top=300, left=300, width=300, height=300");
			}
/* 			$(document).ready(function() {
				var flag = $("#refereeFlag").val();
				alert(flag);
				if (null == flag || !flag) {
					window.document.forms["refereeListForm"].submit();
				}
			}); */
		</script>
	</head>
	<body>
		<s:div id="refereeDiv" class="searcher">
			<s:div id="refereeMenu" class="searchMenu">
				<s:form id="refereeFormReset" name="refereeFormReset" action="refereeFormReset.action" method="post" theme="simple" />
				<s:form id="refereeListForm" name="refereeListForm" action="getRefereeListFunction.action" method="post" onreset="formReset()" theme="simple">
					<s:div>
						<span>
							<s:property value='getText(\"referee.Search_points\")'/> <!-- Buscar árbitro -->
						</span>
						<s:textfield id="refereeSearchText" cssClass="sTextfield" name="refereeSearchText" label="%{getText('referee.Search')}" value="%{refereeLastSearch}" /> <!-- Nombre, apellidos o alias del árbitro -->
					</s:div>
					<s:div>
						<s:submit id="buttonSearchReferees" cssClass="sButton" name="buttonSearchReferees" title="%{getText('referee.Search')}" value="%{getText('Search')}" />
						<s:reset id="buttonResetReferees" cssClass="sButton" name="buttonResetReferees" title="%{getText('referee.ResetSearch')}" value="%{getText('Reset')}" />
					</s:div>
				</s:form>
			</s:div>
			<s:if test="%{null != #refereeListResult || !refereeListResult.isEmpty()}">
				<s:div id="refereeResults" class="searchResults">
					<s:set name="isOddRow" value="true" />
					<table id="refereeTableResults">
						<tr>
							<th>
								<s:property value='getText(\"referee.SURNAME\")' /> <!-- Apellidos -->
							</th>
							<th>
								<s:property value='getText(\"referee.NAME\")' /> <!-- Nombre -->
							</th>
							<th>
								<s:property value='getText(\"referee.CITY\")' /> <!-- Ciudad -->
							</th>
							<th>
								<s:property value="getText('referee.BIRTHDATE')" /> <!-- Fecha de nacimiento -->
							</th>
							<s:if test="%{(null != #sessionUser) && (#sessionAdmin)}">
								<th>
									<s:property value="getText('referee.ALIAS')" /> <!-- Alias -->
								</th>
							</s:if>
							<th>
								<!-- Visualizar -->
							</th>
						</tr>
						<s:iterator value="refereeListResult">
				        	<s:set name="idAux" value="id" />
				        	<s:set name="surnameAux" value="surname" />
							<tr 
								<s:if test="true == #isOddRow">
									<s:set name="isOddRow" value="false" />
									class="oddRow"
								</s:if>
								<s:else>
									<s:set name="isOddRow" value="true" />
									class="evenRow"
								</s:else>
							>
						        <td>
						        	<s:property value="surname" />
						        </td>
						        <td>
						        	<s:property value="name" />
						        </td>
						        <td>
						        	<s:property value="city" />
						        </td>
						        <td>
						        	<s:date name="birthdate" format="dd/MM/yyyy" />
						        </td>
						        <s:if test="%{(null != #sessionUser) && (#sessionAdmin)}">
							        <td>
							        	<s:property value="alias" />
							        </td>
							    </s:if>
						        <td>
						        	<s:form id="searchRefereeForm" name="searchRefereeForm" action="searchReferee.action" method="simple">
						        		<s:hidden id="refereeID" name="referee.id" value="%{#idAux}" />
						        		<s:hidden id="refereeSurname" name="refereeSurname" value="%{#surnameAux}" />
						        		<s:submit id="buttonSearchReferee" cssClass="sButton" name="buttonSearchReferee" title="%{getText('referee.Show') + ' ' + #surnameAux}" value="%{getText('referee.ShowReferee')}" />
						        	</s:form>
						        </td>
						    </tr>
						</s:iterator>
						<tr>
							<th class="thBottom"
								<s:if test="%{(null != #sessionUser) && (#sessionAdmin)}">
									colspan="6"
								</s:if>
								<s:else>
									colspan="5"
								</s:else>
							>
								<span>
									<s:property value='getText(\"referee.TotalREFEREES_points\")'/> <s:property value="#refereeListResult.size" /> <!-- TOTAL -->
								</span>
							</th>
						</tr>
					</table>
				</s:div>
			</s:if>
			<s:else>
				<s:if test="%{(null != #refereeFlag) && (#refereeFlag)}">
					<s:div id="refereeResults" class="searchResults">
						<span>
							<s:property value='getText(\"referee.ResultsNotFound\")'/>
						</span>
					</s:div>
				</s:if>
			</s:else>
		</s:div>
	</body>
</html>