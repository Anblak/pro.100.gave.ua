<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<link rel="stylesheet" href="css/tiles.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/group.css">
<link rel="stylesheet" href="css/button.css">
<script src="https://code.jquery.com/jquery-2.2.0.js"></script>



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
		
	</div>

	<script src="js/math.js"></script>
	<script src="js/audioPlayer.js"></script>
	<script>
		audioPlayer();
	</script>


