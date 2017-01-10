<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>





	${user.name}${user.email}${user.phone}
	<br> ${nameException}

	<form:form modelAttribute="groupOfUsers" action="createGroup"
		method="post">
		<input name="name"
			class="validate[required,custom[name],length[0,100]] feedback-input"
			placeholder="name ${nameException}">
		<button>create group</button>
	</form:form>

	<br>

	<form:form modelAttribute="profesor" action="newProfesor" method="post">
		<input name="name" placeholder="name">
		<button>new profesor</button>
	</form:form>


	<%-- 	<form:form method="POST" commandName="profesorID" action="saveProfesor"> --%>

	<%-- 		<form:select path="string" itemLable="name" itemValue="id"> --%>
	<%-- 			<form:option value="-" label="--Select profesor" /> --%>
	<%-- 			<form:options items="${profesorMap}" /> --%>
	<%-- 		</form:select> --%>

	<!-- 		<input type="submit" value="Submit" /> -->
	<%-- 	</form:form> --%>
	<%-- 	${profesorID} --%>

<div>
		<form:form method="POST" commandName="profesor" action="profesort">

			<form:select path="string" itemLable="name" itemValue="id">
				<form:option value="-" label="--Select phone" />
				<form:options items="${profesorMap}" />
			</form:select>
			<button>submit</button>
		</form:form>
		<p>${profesor}</p>
		<p>${test}</p>
		<form:form action='./saveFile?${_csrf.parameterName}=${_csrf.token}'
			method='post' enctype='multipart/form-data'>
			<input type='file' name='multipartFile'>
			<button>safe file</button>
		</form:form>
</div>








	<%-- 	<form:form action="./saveFile?${_csrf.parameterName}=${_csrf.token}" --%>
	<%--  		method="post" enctype="multipart/form-data"> --%>
	<!-- 		<input type="file" name="multipartFile"> -->
	<!-- 		<button>safe file</button>  -->
	<%--  	</form:form>  --%>




	<%-- 	<form:form method="POST" commandName="profesor" action="safeFile"> --%>

	<%-- 		<form:select path="name" itemLable="name" itemValue="id"> --%>
	<%-- 			<form:option value="-" label="--Select phone" /> --%>
	<%-- 			<form:options items="${profesorsMap}" /> --%>
	<%-- 		</form:select> --%>
	<!-- 		<input type="submit" value="Submit" /> -->
	<%-- 	</form:form> --%>



</body>
</html>




