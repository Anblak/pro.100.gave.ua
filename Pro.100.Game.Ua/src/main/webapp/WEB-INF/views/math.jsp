<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>math</title>
<link rel="stylesheet" href="css/math.css">
</head>
<body>


<h1>Math</h1>

<form:form modelAttribute="baseActionWrapper"  action="doMath" method="get" class="formCalcul">
		<input name="formul" placeholder="formul" class="formul">
		<input name="space" placeholder="space" class="space">
		<button class="buttonAnswer">rishyty</button>
</form:form>
		<div class="answer">${answer}</div>
</body>
</html>