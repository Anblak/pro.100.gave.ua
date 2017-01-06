<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>math</title>
</head>
<body>


<h1>Math${answer}</h1>

<<<<<<< HEAD
<form:form modelAttribute="baseActionWrapper"  action="domath" method="get">
		<input name="formul" placeholder="formul"/>
		<input name="space" placeholder="space"/>
=======
<h1>${answer.string}</h1>

<form:form modelAttribute="string"  action="doMath" method="post">
		<input name="string" placeholder="formul ${answer}">
		<input name="space" placeholder="space ${answer}">
>>>>>>> branch 'dermo' of https://github.com/Anblak/pro.100.gave.ua.git
		<button>rishyty</button>
</form:form>
		<div>${answer}</div>



</body>
</html>