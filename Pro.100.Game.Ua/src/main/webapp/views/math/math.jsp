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
<div class="heder" style="background-image:url(${heder});width:1360px;height:100px"></div>
<div class="left" style="background-image:url(${LeftBodyDiv});width:900px;height:750px">
<div class="calcul" style="position:absolute;left:503px;top:491px;witdt:313px;height:407px;">


<button class="button"  style="background-image:url(img/0.png);width:77px;height:69px;position:absolute;top:268px;left:238px"></button>
<button class="button"  style="background-image:url(img/1.png);width:77px;height:69px;position:absolute;top:53px;left:82px"></button>
<button class="button"  style="background-image:url(img/2.png);width:77px;height:69px;position:absolute;top:53px;left:160px"></button>
<button class="button"  style="background-image:url(img/3.png);width:77px;height:69px;position:absolute;top:53px;left:238px"></button>
<button class="button"  style="background-image:url(img/4.png);width:77px;height:69px;position:absolute;top:124px;left:82px"></button>
<button class="button"  style="background-image:url(img/5.png);width:77px;height:69px;position:absolute;top:124px;left:160px"></button>
<button class="button"  style="background-image:url(img/6.png);width:77px;height:69px;position:absolute;top:124px;left:238px"></button>
<button class="button"  style="background-image:url(img/7.png);width:77px;height:69px;position:absolute;top:196px;left:82px"></button>
<button class="button"  style="background-image:url(img/8.png);width:77px;height:69px;position:absolute;top:196px;left:160px"></button>
<button class="button"  style="background-image:url(img/9.png);width:77px;height:69px;position:absolute;top:196px;left:238px"></button>
<button class="button"  style="background-image:url(img/alt.png);width:77px;height:69px;position:absolute;top:53px;left:0px"></button>
<button class="button"  style="background-image:url(img/association.png);width:77px;height:69px;position:absolute;top:268px;left:0px"></button>
<button class="button"  style="background-image:url(img/brackets.png);width:77px;height:69px;position:absolute;top:268px;left:160px"></button>
<button class="button"  style="background-image:url(img/odds.png);width:77px;height:69px;position:absolute;top:124px;left:0px"></button>
<button class="button"  style="background-image:url(img/decussation.png);width:77px;height:69px;position:absolute;top:196px;left:0px"></button>
<button class="button"  style="background-image:url(img/coma.png);width:77px;height:69px;position:absolute;top:268px;left:82px"></button>




<form:form modelAttribute="baseActionWrapper"  action="doMath" method="get" class="formCalcul" style="position:apsolute;top:0px;left:0px;width:315px;height:50px;"	>
<div class="input" style="background-image:url(img/input.png);width:315px;height:50px;">

		<input name="formul" placeholder="formul" class="formul" >
		<input name="space" placeholder="space" class="space">
		</div>
		<button class="calcButton" style="background-image:url(img/button.png);width:316px;height:64px;position:absolute;top:342px;left:0px"></button>
</form:form>
		
</div>
</div>
<div class="right" style="background-image:url(img/copybookRight.png);width:469px;height:750px;position:absolute;left:900px;top:210px">
<div  class="answer" style="width:400px;height:600px;margin:auto;position:absolute;top:62px;left:39px;">${space}${answer}</div>
</div>
<div class="right" style="background-image:url(img/footer.png);width:1360px;height:63px;"></div>


		</div>
</body>
</html>