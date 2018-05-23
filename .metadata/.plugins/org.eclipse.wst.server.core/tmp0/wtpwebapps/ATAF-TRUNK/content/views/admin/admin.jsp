<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<s:set var="sessionUser" value="#session.user" />
<s:set var="sessionAdmin" value="#session.admin" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../../css/styles.css" />
		<title>Adninistraci&oacute;n</title>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
	</head>
	<body>
		<s:if test="%{(null != #sessionUser) && (#sessionAdmin)}">
			<s:div id="adminDiv" class="searcher">
				<fieldset class="">
					<legend>
						<s:property value='getText(\"admin.SystemAdmin\")' />
					</legend>
					<fieldset class="">
						<legend>
							<s:property value='getText(\"admin.UserAdmin\")' />
						</legend>
						<s:div id="userAdminMenu">
							<a href="#" class="sButton adminLinks" id="viewUsersLink">
								<s:property value="%{getText('admin.ViewUsers')}" />
							</a>
							<a href="#" class="sButton adminLinks" id="newUserLink">
								<s:property value="%{getText('admin.NewUser')}" />
							</a>
						</s:div>
					</fieldset>
					<fieldset class="">
						<legend>
							<s:property value='getText(\"admin.RefereeAdmin\")' />
						</legend>
						<s:div id="refereeAdminMenu">
							<a href="#" class="sButton adminLinks" id="viewRefereesLink">
								<s:property value="%{getText('admin.ViewReferees')}" />
							</a>
							<a href="#" class="sButton adminLinks" id="newRefereeLink">
								<s:property value="%{getText('admin.NewReferee')}" />
							</a>
						</s:div>
					</fieldset>
				</fieldset>
			</s:div>
		</s:if>
		<script type="text/javascript">
			$("#viewUsersLink").click(function() {
				$("#webBody").load("./content/views/admin/users.jsp");
			});
			
			$("#newUserLink").click(function() {
				$("#webBody").load("./content/views/admin/new_user.jsp");
			});
		
    		$("#viewRefereesLink").click(function() {
				$("#webBody").load("./content/views/referees.jsp");
			});
			
			$("#newRefereeLink").click(function() {
				$("#webBody").load("./content/views/admin/new_referee.jsp");
			});
    	</script>
	</body>
</html>