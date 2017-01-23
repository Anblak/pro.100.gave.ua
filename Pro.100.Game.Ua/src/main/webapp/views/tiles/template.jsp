<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<link rel="stylesheet" href="css/tiles.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/group.css">

<title>Pro100.game.ua</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>

	<div class="tiles" style="">





		<sec:authorize access="!isAuthenticated()">




			<button
				onclick="document.getElementById('id01').style.display='block'"
				style="width: auto;">Login</button>

			<div id="id01" class="modal">

				<form:form class="modal-content animate" action="loginprocesing"
					method="post">
					<div class="imgcontainer">
						<span
							onclick="document.getElementById('id01').style.display='none'"
							class="close" title="Close Modal">&times;</span> <img
							src="img/useranon.png" alt="Avatar" class="avatar">
					</div>

					<div class="container">

						<label><b>Username</b></label> <input type="text"
							placeholder="Enter Username" name="username" required> <label><b>Password</b></label>
						<input type="password" placeholder="Enter Password"
							name="password" required>

						<button type="submit">Login</button>
						<!--  <input type="checkbox" checked="checked"> Remember me-->

					</div>
					<div class="container" style="background-color: #f1f1f1">
						<button type="button"
							onclick="document.getElementById('id01').style.display='none'"
							class="cancelbtn">Cancel</button>
						<span class="psw">Forgot <a href="#">password?</a></span>
					</div>
				</form:form>
			</div>

			<button
				onclick="document.getElementById('id02').style.display='block'"
				style="width: auto;">registration</button>

			<div id="id02" class="modal">

				<form:form class="modal-content animate" modelAttribute="user"
					action="saveUser" method="post">
					<div class="imgcontainer">
						<span
							onclick="document.getElementById('id02').style.display='none'"
							class="close" title="Close Modal">&times;</span> <img
							src="img/useranon.png" alt="Avatar" class="avatar">
					</div>

					<div class="container">

						<label><b>name</b></label> <input name="name"
							class="validate[required,custom[username],length[0,100]] feedback-input"
							type="text" placeholder="name ${usernameException}"> <label><b>email</b></label>
						<input name="email"
							class="validate[required,custom[email],length[0,100]] feedback-input"
							type="email" placeholder="email ${emailException}"> <label><b>password</b></label>
						<input name="password"
							class="validate[required,custom[password],length[0,100]] feedback-input"
							type="password" " placeholder="password ${passwordException}">
						<label><b>phone</b></label> <input name="phone"
							placeholder="phone" type="text">

						<button type="submit">Login</button>
						<!--  <input type="checkbox" checked="checked"> Remember me-->

					</div>
					<div class="container" style="background-color: #f1f1f1">
						<button type="button"
							onclick="document.getElementById('id02').style.display='none'"
							class="cancelbtn">Cancel</button>

					</div>
				</form:form>
			</div>



		</sec:authorize>



		<sec:authorize access="isAuthenticated()">

			<!------------- user ------------>
			<button
				onclick="document.getElementById('userSettings').style.display='block'"
				style="" class="userSettings">
				<img class="imgUserSettings" src="img/useranon.png" />
			</button>

			<div id="userSettings" class="modal">

				<form:form class="modal-content animate" action="saveUser"
					method="post">
					<div class="imgcontainer">
						<span
							onclick="document.getElementById('userSettings').style.display='none'"
							class="close" title="Close Modal">&times;</span> <img
							src="img/useranon.png" alt="Avatar" class="avatar">
					</div>

					<div class="container">
						<!-- info -->
						<div class="container">
							<label><b>name</b>: ${user.name}</label>

						</div>
						<div class="container">
							<label><b>email</b>:${user.email}</label>
						</div>
						<div class="container">
							<label><b>phone</b>:${user.phone}</label>
						</div>
						<div class="container">
							<sec:authorize access="hasRole('ROLE_CREATOR')">
								<label><b>uidGroup</b>${group}</label>
						</div>
					</div>
		</sec:authorize>
		<form:form action="logout" method="post" class="logout">
			<button type="submit">logout</button>
			<!-- cancel -->
			<div class="container" style="background-color: #f1f1f1">
				<button type="button"
					onclick="document.getElementById('userSettings').style.display='none'"
					class="cancelbtn">Cancel</button>

			</div>
		</form:form>
		<!--  <input type="checkbox" checked="checked"> Remember me-->

	</div>

	</form:form>
	</div>



	</sec:authorize>



	<!-- 		<div class="lgWrapper" style=""> -->
	<!-- 			<div class="wrapperlg" style=""> -->
	<!-- 				<p style="margin: auto"> -->
	<%-- 				<form action="ua" method=get class="formUA"> --%>
	<!-- 					<button class="buttonUA" id="buttonUA" style=""> -->
	<!-- 						<p class="pUA">UA</p> -->
	<!-- 					</button> -->
	<%-- 				</form> --%>

	<%-- 				<form action="ru" method=get class="formRU"> --%>

	<!-- 					<button class="buttonRU" id="buttonRU" style=""> -->
	<!-- 						<p class="pRU">RU</p> -->
	<!-- 					</button> -->

	<%-- 				</form> --%>
	<!-- 				</p> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	</div>
	<div>
		<tiles:insertAttribute name="body" />
	</div>
	<script src="js/math.js"></script>
</body>
</html>