<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/math.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>math</title>

</head>
<body  >
<div class="" >
<div class="heder" style="background-image:url(img/heder.png);width:1360px;height:100px"></div>
<div class="left" style="background-image:url(img/LeftBodyDiv.png);width:900px;height:750px">
<div class="calcul" style="position:absolute;left:503px;top:491px;witdt:313px;height:407px;background:black">
<form:form modelAttribute="baseActionWrapper"  action="doMath" method="get" class="formCalcul" stype="">
<div class="input" style="background-image:url(img/input.png);width:308px;height:35px">
		<input name="formul" placeholder="formul" class="formul">
		<input name="space" placeholder="space" class="space">
		</div>
		<button class="button" style="background-image:url(img/button.png);width:308px;height:64px;position:absolute;top:342px;left:0px"></button>
</form:form>
		<div  class="answer">${answer}</div>
</div>
</div>
<div class="right" style="background-image:url(img/copybookRight.png);width:469px;height:750px;position:absolute;left:900px;top:210px"></div>
<div class="right" style="background-image:url(img/footer.png);width:1360px;height:63px;"></div>


		</div>
</body>
</html>