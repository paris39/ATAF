<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set name="activeLink" value="" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/styles.css" />
		<title>¡HAZTE &Aacute;RBITRO</title>
	</head>
	<body>
		<div id="imgBody" class="imgBody">
			<img src="/ATAF/content/img/url.jpg" />
		</div>
		<div id="textBody" class="textBody">
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
		</div>
	</body>
</html>