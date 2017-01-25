<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/button.css">

</head>

<body>
	<div>
		${groupUID.name}<br>${user.name}${user.email}${user.phone} <br>
		${nameException}
	</div>

	<button
		onclick="document.getElementById('creategroup').style.display='block'"
		style="width: auto;">Create Group</button>

	<div id="creategroup" class="modal">

		<form:form modelAttribute="groupOfUsers" action="createGroup"
			class="modal-content animate" method="post">
			<div class="imgcontainer">
				<span
					onclick="document.getElementById('creategroup').style.display='none'"
					class="close" title="Close Modal">&times;</span> <img
					src="img/group.png" alt="Avatar" class="avatar">
			</div>

			<div class="container">

				<label><b>Group Name</b></label> <input type="text" name="name"
					class="validate[required,custom[name],length[0,100]] feedback-input"
					placeholder="name ${nameException}" required>


				<button type="submit">Create</button>
				<!--  <input type="checkbox" checked="checked"> Remember me-->

			</div>
			<div class="container" style="background-color: #f1f1f1">
				<button type="button"
					onclick="document.getElementById('creategroup').style.display='none'"
					class="cancelbtn">Cancel</button>

			</div>
		</form:form>
	</div>



	<%-- 	<form:form modelAttribute="groupOfUsers" action="createGroup" --%>
	<%-- 		method="post"> --%>
	<!-- 		<input name="name" -->
	<!-- 			class="validate[required,custom[name],length[0,100]] feedback-input" -->
	<%-- 			placeholder="name ${nameException}"> --%>
	<!-- 		<button class="button">create group</button> -->
	<%-- 	</form:form> --%>

	<br>
	<!--  	<p>${uuidBody}</p>-->

	<sec:authorize access="hasRole('ROLE_CREATOR')">
		<br>
		<button
			onclick="document.getElementById('createprofesor').style.display='block'"
			style="width: auto;">add Profesor</button>

		<div id="createprofesor" class="modal">

			<form:form modelAttribute="profesor" action="newProfesor"
				class="modal-content animate" method="post">
				<div class="imgcontainer">
					<span
						onclick="document.getElementById('createprofesor').style.display='none'"
						class="close" title="Close Modal">&times;</span> <img
						src="img/useranon.png" alt="Avatar" class="avatar">
				</div>

				<div class="container">

					<label><b>Profesor Full Name</b></label> <input type="text"
						name="name"
						class="validate[required,custom[name],length[0,100]] feedback-input"
						placeholder="name ${nameException}" required>


					<button type="submit">Create</button>
					<!--  <input type="checkbox" checked="checked"> Remember me-->

				</div>
				<div class="container" style="background-color: #f1f1f1">
					<button type="button"
						onclick="document.getElementById('createprofesor').style.display='none'"
						class="cancelbtn">Cancel</button>

				</div>
			</form:form>
		</div>

	</sec:authorize>
	<%-- 	<form:form modelAttribute="profesor" action="newProfesor" method="post"> --%>
	<!-- 		<input name="name" placeholder="name"> -->
	<!-- 		<button class="button">new profesor</button> -->
	<%-- 	</form:form> --%>


	<%-- 	<form:form method="POST" commandName="profesorID" action="saveProfesor"> --%>

	<%-- 		<form:select path="string" itemLable="name" itemValue="id"> --%>
	<%-- 			<form:option value="-" label="--Select profesor" /> --%>
	<%-- 			<form:options items="${profesorMap}" /> --%>
	<%-- 		</form:select> --%>

	<!-- 		<input type="submit" value="Submit" /> -->
	<%-- 	</form:form> --%>
	<%-- 	${profesorID} --%>

	<sec:authorize access="hasRole('ROLE_CREATOR')">
		<div>
			<!--${list}  -->


			<button
				onclick="document.getElementById('addfile').style.display='block'"
				style="width: auto;">add File</button>

			<div id="addfile" class="modal">

				<form:form class="modal-content animate"
					action='./saveFile?${_csrf.parameterName}=${_csrf.token}'
					method='post' enctype='multipart/form-data'>
					<div class="imgcontainer">
						<span
							onclick="document.getElementById('addfile').style.display='none'"
							class="close" title="Close Modal">&times;</span> <img
							src="img/file.png" alt="Avatar" class="avatar">
					</div>

					<div class="container">

						<label><b></b></label> <input type='file' name='multipartFile'>
						<form:form class="modal-content animate" method="POST"
							commandName="profesor">
							<form:select path="string" itemLable="name" itemValue="id">
								<form:option value="-" label="Select profesor" />
								<form:options items="${profesorMap}" />
							</form:select>
							<button type="submit">safe file</button>

							<div class="container" style="background-color: #f1f1f1">
								<button type="button"
									onclick="document.getElementById('addfile').style.display='none'"
									class="cancelbtn">Cancel</button>
						</form:form>

					</div>
			</div>
			</form:form>
		</div>
	</sec:authorize>
	<%-- 		<form:form action='./saveFile?${_csrf.parameterName}=${_csrf.token}' --%>
	<%-- 			method='post' enctype='multipart/form-data'> --%>
	<!-- 			<input type='file' name='multipartFile'> -->
	<%-- 			<form:form method="POST" commandName="profesor"> --%>
	<%-- 				<form:select path="string" itemLable="name" itemValue="id"> --%>
	<%-- 					<form:option value="-" label="--Select profesor" /> --%>
	<%-- 					<form:options items="${profesorMap}" /> --%>
	<%-- 				</form:select> --%>
	<!-- 				<button class="button">safe file</button> -->

	<%-- 			</form:form> --%>
	<%-- 		</form:form> --%>
	</div>



	<sec:authorize access="hasRole('ROLE_USER')">
		<a href="group">group</a>
	</sec:authorize>

	<sec:authorize access="hasRole('ROLE_CREATOR')">
		<a href="group">group</a>
	</sec:authorize>








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




