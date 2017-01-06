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

<h1>${answer.string}</h1>

<form:form modelAttribute="string"  action="doMath" method="post">
		<input name="string" placeholder="formul ${answer}">
		<input name="space" placeholder="space ${answer}">
		<button>rishyty</button>
</form:form>

${answer}

</body>
</html>