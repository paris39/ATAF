<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/styles.css" />
		<title>¡HAZTE &Aacute;RBITRO</title>
	</head>
	<body>
		<div>
			<form id="newUser" name="newUser" action="newUser.action" method="post">
				<span>Nombre de usuario: </span><input type="text" id="userID" name="user.alias" /> <!-- Usuario -->
				<span>Contrase&ntilde;a: </span><input type="password" id="password" name="user.password" />
				<input type="submit" id="buttonNewUser" name="buttonNewUser" value="<s:property value='getText(\"Send\")'/>" />
			</form>
		</div>
	</body>
</html>