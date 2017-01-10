
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>



	<div>
		${user.name}${user.email}${user.phone}
		<form:form method="POST" commandName="profesor" action="profesort">

			<form:select path="string" itemLable="name" itemValue="id">
				<form:option value="-" label="--Select phone" />
				<form:options items="${profesorsMap}" />
			</form:select>
			<button>submit</button>
		</form:form>
		<p>${profesor}</p>
		<p>${test}</p>
		${saveFileForm}
	</div>
	<%-- <form:form action="./saveFile?${_csrf.parameterName}=${_csrf.token}" --%>
	<%--  		method="post" enctype="multipart/form-data"> --%>
	<!-- 		<input type="file" name="multipartFile"> -->
	<!-- 		<button>safe file</button>  -->
	<%--  	</form:form>  --%>
</body>

<script src="js/some.js"></script>
</html>
