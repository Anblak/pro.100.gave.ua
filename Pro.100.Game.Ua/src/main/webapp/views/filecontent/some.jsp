
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>



<div>
<form:form method="POST" commandName="profesor" action="profesort">
	
<form:select path="name"  itemLable="name" itemValue="id"  >
 <form:option value="-" label="--Select phone"/>
                <form:options items="${profesorsMap}" />
		</form:select>
		<input type="submit" value="Submit"/>
	</form:form>
	<p>${profesor}</p>	
	<p>${test}</p>	
</div>

</body>
</html>
