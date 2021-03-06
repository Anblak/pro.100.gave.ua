
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="css/load.css">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>

<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" href="css/template.css">
</head>
<body>

	<div class="mainHeaderDiv">
		<div id="p_prldr">
			<div class="contpre">
				<span class="svg_anm"></span><br>Wait<br>
				<small>loading</small>
			</div>
			<script type="text/javascript">
				$(window)
						.on(
								'load',
								function() {
									var $preloader = $('#p_prldr'), $svg_anm = $preloader
											.find('.svg_anm');
									$svg_anm.fadeOut();
									$preloader.delay(500).fadeOut('slow');

								});
				$('#buttonActionLoad')
						.on(
								'click',
								function() {
									document.getElementById('svg_anm').style = 'margin-left:-20px;';
									var $preloader = $('#p_prldr'), $svg_anm = $preloader
											.find('.svg_anm');
									$svg_anm.fadeIn();
									$preloader.delay(0).fadeIn('slow');

								});
			</script>
		</div>
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>
	<div id="mainBodyDiv" class="mainBodyDiv">
		<div id="mainMenu" class="mainMenu">




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
									placeholder="Enter Username" name="username" required>
								<label><b>Password</b></label> <input type="password"
									placeholder="Enter Password" name="password" required>

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






				<!------------- user ------------>
				<button
					onclick="document.getElementById('userSettingsm').style.display='block';menuLeftClose()"
					style="" class="userSettings">
					<img class="imgUserSettings" src="${user.pathImage}" />
					<div>
						<br>${user.name} <br>

					</div>
				</button>

				<div id="userSettingsm" class="modal">

					<div class="modal-content animate">

						<div class="imgcontainer">
							<span
								onclick="document.getElementById('userSettingsm').style.display='none'"
								class="close" title="Close Modal">&times;</span> <img
								src="img/useranon.png" alt="Avatar" class="avatar">


						</div>

						<div class="container">
							<!------------- add new photo ------------>
							<button class="profilebutton"
								onclick="document.getElementById('savephotom').style.display='block'"
								style="">add new Photo</button>

							<div id="savephotom" class="modal">

								<div class="modal-content animate">
									<div class="imgcontainer">
										<span
											onclick="document.getElementById('savephotom').style.display='none'"
											class="close" title="Close Modal">&times;</span>
									</div>
									<div class="imgcontainer">
										<p>imgcontainer</p>
									</div>

									<div class="container">

										<p>container</p>
										<form:form
											action="./saveImage?${_csrf.parameterName}=${_csrf.token}"
											method="post" enctype="multipart/form-data">
											<input type="file" name="image">
											<button>save image</button>
										</form:form>

									</div>
									<div class="container" style="background-color: #f1f1f1">
										<button type="button"
											onclick="document.getElementById('savephotom').style.display='none'"
											class="cancelbtn">Cancel</button>

									</div>
								</div>
							</div>
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
									<label><div class="uidGroup">
											<b>uidGroup: </b>
											<p class="pu">http://localhost:8080/</p>
											<p class="pu">Pro.100.Game.Ua/confirmAdd/</p>
											<p class="pu">${user.uuid}</p>
										</div></label>
								</sec:authorize>
							</div>
						</div>
						<form:form action="logout" method="post" id="formlogaut">
							<button type="submit" form="formlogaut">logout</button>
						</form:form>
						<!-- cancel -->
						<div class="container" style="background-color: #f1f1f1">
							<form action="user${user.id}" method="get" id="formprofile">
								<button type="button"
									onclick="document.getElementById('userSettingsm').style.display='none'"
									class="cancelbtn">Cancel</button>
								<span class="pwn">
									<button class="profilebutton" form="formprofile">profile</button>
								</span>
							</form>

						</div>

					</div>

					<!--  <input type="checkbox" checked="checked"> Remember me-->

				</div>
			</div>

			<!------------- audio ------------>
			<button class="audioButton"
				onclick="document.getElementById('audiom').style.display='block';menuLeftClose()"
				style="width: auto;">audio</button>

			<div id="audiom" class="modal">

				<div class="modal-content animate">

					<div class="imgcontainer">
						<span
							onclick="document.getElementById('audiom').style.display='none'"
							class="close" title="Close Modal">&times;</span>
					</div>

					<div class="container">

						<p>container</p>
						<div>

							<center>

								<audio src="" id="audioPlayerm"> Sorry, your browser
								doesn't support html5! </audio>
							</center>
						</div>
						<div class="container divPlayList">
							<ul id="playlistm">${music}</ul>
						</div>

						<div class="container" style="background-color: #f1f1f1">
							<button type="button"
								onclick="document.getElementById('audiom').style.display='none'"
								class="cancelbtn">Cancel</button>
							<!------------- addMusic ------------>

							<button class="profilebuttonm"
								onclick="document.getElementById('savemusicm').style.display='block'"
								style="">add new Music</button>

							<div id="savemusicm" class="modal">

								<div class="modal-content animate">
									<div class="imgcontainer">
										<span
											onclick="document.getElementById('savemusicm').style.display='none'"
											class="close" title="Close Modal">&times;</span>
									</div>
									<div class="imgcontainer">
										<p>imgcontainer</p>
									</div>

									<div class="container">

										<p>container</p>
										<form:form
											action="./saveMusic?${_csrf.parameterName}=${_csrf.token}"
											method="post" enctype="multipart/form-data">
											<input type="file" name="multipartFile">
											<button>save music</button>
										</form:form>

									</div>
									<div class="container" style="background-color: #f1f1f1">
										<button type="button"
											onclick="document.getElementById('savemusicm').style.display='none'"
											class="cancelbtn">Cancel</button>

									</div>
								</div>
							</div>

							<!------------- endAddMusic ------------>

						</div>
					</div>
				</div>
			</div>
			<marquee id="playerMusicm"></marquee>







		</div>
		<sec:authorize access="isAuthenticated()">
			<div onclick="menuController()" id="leftIndecatorMenu"
				class="leftIndecatorMenu"></div>
		</sec:authorize>

		<tiles:insertAttribute name="body" />
	</div>
	<div class="mainFutterDiv">
		<tiles:insertAttribute name="footer" />
	</div>
	<script src="js/math.js"></script>

	<script src="js/mainMenu.js"></script>
	<script src="js/audioPlayer.js"></script>
	<link rel="stylesheet" href="css/media.css">
	<script>
		audioPlayer();
		audioPlayerm();
	</script>
</body>
</html>