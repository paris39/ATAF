<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<s:set var="userFlag" value="#session.userFlag" />
<s:set var="sessionUser" value="#session.user" />
<s:set var="sessionAdmin" value="#session.admin" />
<s:set var="userLastSearch" value="#session.userLastSearch" />
<s:set var="userListResult" value="#session.userListResult" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../../css/styles.css" />
		<title>Usuarios</title>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
		<script type="text/javascript">
			function formReset() {
				document.forms["userListForm"].reset();
				document.forms["userFormReset"].submit();
			}
		</script>
	</head>
	<body>
		<s:if test="%{(null != #sessionUser) && (#sessionAdmin)}">
			<s:div id="userDiv" class="searcher">
				<s:div id="userMenu" class="searchMenu">
					<s:form id="userFormReset" name="userFormReset" action="userFormReset.action" method="post" theme="simple" />
					<s:form id="userListForm" name="userListForm" action="getUserListFunction.action" method="post" onreset="formReset()" theme="simple">
						<s:div>
							<span>
								<s:property value='getText(\"user.Search_points\")'/> <!-- Buscar usuario -->
							</span>
							<s:textfield id="userSearchText" cssClass="sTextfield" name="usuarioSearchText" label="%{getText('user.Search')}" value="%{userLastSearch}" /> <!-- Nombre, apellidos o alias del usuario -->
						</s:div>
						<s:div>
							<s:submit id="buttonSearchUser" cssClass="sButton" name="buttonSearchUser" title="%{getText('user.Search')}" value="%{getText('Search')}" />
							<s:reset id="buttonResetUsers" cssClass="sButton" name="buttonResetUsers" title="%{getText('user.ResetSearch')}" value="%{getText('Reset')}" />
						</s:div>
					</s:form>
				</s:div>
				<s:if test="%{null != #userListResult || !userListResult.isEmpty()}">
					<s:div id="userResults" class="searchResults">
						<s:set name="isOddRow" value="true" />
						<table id="userTableResults">
							<tr>
								<th>
									<s:property value="getText('user.ALIAS')" /> <!-- Alias -->
								</th>
								<th>
									<s:property value='getText(\"user.SURNAME\")' /> <!-- Apellidos -->
								</th>
								<th>
									<s:property value='getText(\"user.NAME\")' /> <!-- Nombre -->
								</th>
								<th>
									<s:property value='getText(\"user.EMAIL\")' /> <!-- Email -->
								</th>
								<th>
									<!-- Visualizar -->
								</th>
							</tr>
							<s:iterator value="userListResult">
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
							        	<s:property value="alias" />
							        </td>
							        <td>
							        	<s:property value="surname" />
							        </td>
							        <td>
							        	<s:property value="name" />
							        </td>
								    <td>
							        	<s:property value="email" />
							        </td>
							        <td>
							        	<s:form id="searchUserForm" name="searchUserForm" action="searchUser.action" method="simple">
							        		<s:hidden id="userID" name="user.id" value="%{#idAux}" />
							        		<s:hidden id="userAlias" name="userAlias" value="%{#aliasAux}" />
							        		<s:submit id="buttonSearchUser" cssClass="sButton" name="buttonSearchUser" title="%{getText('user.Show') + ' ' + #aliasAux}" value="%{getText('user.ShowUser')}" />
							        	</s:form>
							        </td>
							    </tr>
							</s:iterator>
							<tr>
								<th class="thBottom" colspan="5">
									<span>
										<s:property value='getText(\"user.TotalUSERS_points\")'/> <s:property value="#userListResult.size" /> <!-- TOTAL -->
									</span>
								</th>
							</tr>
						</table>
					</s:div>
				</s:if>
				<s:else>
					<s:if test="%{(null != #userFlag) && (#userFlag)}">
						<s:div id="userResults" class="searchResults">
							<span>
								<s:property value='getText(\"user.ResultsNotFound\")'/>
							</span>
						</s:div>
					</s:if>
				</s:else>
			</s:div>
		</s:if>
	</body>
</html>