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
<link rel="stylesheet" href="css/profile.css">


</head>

<body>
	<div class="container1">
		<div>
			${groupUID.name}<br>${user.name}${user.email}${user.phone} <br>
			${nameException}
		</div>
		<sec:authorize access="hasRole('ROLE_USER')">
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
					</div>
					<div class="container" style="background-color: #f1f1f1">
						<button type="button"
							onclick="document.getElementById('creategroup').style.display='none'"
							class="cancelbtn">Cancel</button>

					</div>
				</form:form>
			</div>

		</sec:authorize>



		<sec:authorize access="hasRole('ROLE_CREATOR')">

			<button
				onclick="document.getElementById('grupAddUser').style.display='block'"
				style="width: auto;">Add User In Group</button>

			<div id="grupAddUser" class="modal">

				<div class="modal-content animate">
					<div class="imgcontainer">
						<span
							onclick="document.getElementById('grupAddUser').style.display='none'"
							class="close" title="Close Modal">&times;</span> <img
							src="img/group.png" alt="Avatar" class="avatar">
					</div>

					<div class="container">${groupUserAdd.string}</div>
					<div class="container" style="background-color: #f1f1f1">
						<button type="button"
							onclick="document.getElementById('grupAddUser').style.display='none'"
							class="cancelbtn">Cancel</button>

					</div>
				</div>
			</div>
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
		<sec:authorize access="hasRole('ROLE_USER_IN_GROUP')">
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

							<label><b></b></label> <input type='file' name='multipartFile'
								id="file" onchange="checkf()">
							<form:form class="modal-content animate" method="POST"
								commandName="profesor">
								<form:select path="string" itemLable="name" itemValue="id">
									<%-- 								<form:option value="" label="Select Profesor" /> --%>
									<form:options items="${profesorMap}" />
								</form:select>
								<button id="savef" disabled="disabled" onmouseover="checkf()">safe
									file</button>

								<div class="container" style="background-color: #f1f1f1">
									<button type="button"
										onclick="document.getElementById('addfile').style.display='none'"
										class="cancelbtn">Cancel</button>
							</form:form>

						</div>
					</form:form>
				</div>
			</div>
		</sec:authorize>

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

							<label><b></b></label> <input type='file' name='multipartFile'
								id="file" onchange="checkf()">
							<form:form class="modal-content animate" method="POST"
								commandName="profesor">
								<form:select path="string" itemLable="name" itemValue="id">
									<%-- 								<form:option value="" label="Select Profesor" /> --%>
									<form:options items="${profesorMap}" />
								</form:select>
								<button id="savef" disabled="disabled" onmouseover="checkf()">safe
									file</button>

								<div class="container" style="background-color: #f1f1f1">
									<button type="button"
										onclick="document.getElementById('addfile').style.display='none'"
										class="cancelbtn">Cancel</button>
							</form:form>

						</div>
					</form:form>
				</div>
			</div>
		</sec:authorize>

		<!-- 	</div> -->





		<sec:authorize access="!hasRole('ROLE_USER')">
			<a href="group">group</a>
		</sec:authorize>


		<script type="text/javascript">
			function checkf() {

				if (document.getElementById('file').value == ''
						&& document.getElementById('prof').value == '-') {

					document.getElementById('savef').disabled = 'disabled';

				} else {

					document.getElementById('savef').disabled = '';
				}
			}
		</script>



		<div class="pizza">
			<div class="crust"></div>
			<div class="crust-highlight"></div>
			<div class="crust-shine-1"></div>
			<div class="crust-shine-2"></div>
			<div class="pizza-body-border"></div>
			<div class="pizza-body"></div>
			<div class="pizza-shine-large"></div>
			<div class="pizza-shine-small"></div>
			<div class="left-eye"></div>
			<div class="right-eye"></div>
			<div class="left-pupil"></div>
			<div class="right-pupil"></div>
			<div class="left-shine"></div>
			<div class="right-shine"></div>
			<div class="smile"></div>
			<div class="pepperoni-1"></div>
			<div class="pepperoni-2"></div>
			<div class="pepperoni-3"></div>
			<div class="pepperoni-shine-1-left"></div>
			<div class="pepperoni-shine-1-right"></div>
			<div class="pepperoni-shine-2-left"></div>
			<div class="pepperoni-shine-2-right"></div>
			<div class="pepperoni-shine-3-left"></div>
			<div class="pepperoni-shine-3-right"></div>
		</div>
		<div class="left-sparkle">
			<div class="sparkle"></div>
		</div>
		<div class="right-sparkle">
			<div class="sparkle"></div>
		</div>
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




