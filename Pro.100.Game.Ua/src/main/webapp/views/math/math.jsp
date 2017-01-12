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
<body>
<div class="" >

<div class="heder" style="background-image:url(${heder});">
<div class="left" style="background-image:url(${LeftBodyDiv});">
<div class="calcul" style="position:absolute;left:503px;top:225px;witdt:313px;height:407px;">


<button class="button0" onclick="zero()" style="background-image:url(img/0.png)"></button>
<button class="button1" onclick="one()" style="background-image:url(img/1.png)"></button>
<button class="button2" onclick="two()" style="background-image:url(img/2.png)"></button>
<button class="button3" onclick="three()" style="background-image:url(img/3.png)"></button>
<button class="button4" onclick="four()" style="background-image:url(img/4.png)"></button>
<button class="button5" onclick="five()" style="background-image:url(img/5.png)"></button>
<button class="button6" onclick="six()" style="background-image:url(img/6.png)"></button>
<button class="button7" onclick="seven()" style="background-image:url(img/7.png)"></button>
<button class="button8" onclick="eight()" style="background-image:url(img/8.png)"></button>
<button class="button9" onclick="nine()" style="background-image:url(img/9.png)"></button>
<button class="buttonAlt" onclick="alt()" style="background-image:url(img/alt.png)"></button>
<button class="buttonAssociation" onclick="association()" style="background-image:url(img/association.png)"></button>
<button class="buttonBrackets" onclick="brackets()" style="background-image:url(img/brackets.png)"></button>
<button class="buttonOdds" onclick="odds()" style="background-image:url(img/odds.png)"></button>
<button class="buttonDecussation" onclick="decussation()" style="background-image:url(img/decussation.png)"></button>
<button class="buttonComa" onclick="coma()" style="background-image:url(img/coma.png)"></button>




<form:form modelAttribute="baseActionWrapper"  action="do" method="get" class="formCalcul">
<div class="input" style="background-image:url(img/input.png);width:315px;height:50px;">

		<p id="pInputFormul" class="formulP"><input name="formul" placeholder="formul" class="formul" id="formul" onfocus="inputFormul()" ></p>
		<p id="pInputSpace" class="spaceP"><input name="space" placeholder="space" class="space" id="space" onfocus="inputSpace()"  ></p>
		</div>
		<button class="calcButton" style="background-image:url(img/button.png)"></button>
</form:form>
		
</div>
</div>
<div class="right" style="background-image:url(img/copybookRight.png);width:469px;height:750px;position:absolute;left:900px;top:210px">
<div  class="answer" >${space} ${resalt} ${answer}  </div>
</div>
<div class="fotter" style="background-image:url(img/footer.png);width:1360px;height:63px;position:absolute;left0px;top:963px;"></div>


</div>
		</div>
		
		<script src="js/math.js"></script>
</body>
</html>