<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<link rel="stylesheet" href="css/tiles.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/group.css">
<link rel="stylesheet" href="css/button.css">
<link rel="stylesheet" href="css/media.css">
<link rel="stylesheet" href="css/load.css">
<script src="https://code.jquery.com/jquery-2.2.0.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>





<div class="tiles" style="">




	<div id="p_prldr" style="opacity: 0; display: none">
		<div class="contpre">
			<span id="svg_anm"></span><br>Wait<br>
			<small>loading</small>
		</div>
	</div>
	<sec:authorize access="!isAuthenticated()">


		<div id="returnpas" class="modal">

			<form:form class="modal-content animate"
				action="researchUserIntoMail" method="get">
				<div class="imgcontainer">
					<span
						onclick="document.getElementById('returnpas').style.display='none'"
						class="close" title="Close Modal">&times;</span>
				</div>

				<div class="container">

					<label><b>email</b></label> <input name="email" type="email"
						placeholder="email">

					<button type="submit" id='buttonActionLoad'>registration</button>
					<!--  <input type="checkbox" checked="checked"> Remember me-->

				</div>
				<script type="text/javascript">
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
				<div class="container" style="background-color: #f1f1f1">
					<button type="button"
						onclick="document.getElementById('returnpas').style.display='none'"
						class="cancelbtn">Cancel</button>

				</div>
			</form:form>
		</div>

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
					<input type="password" placeholder="Enter Password" name="password"
						required>

					<button type="submit">Login</button>
					<!--  <input type="checkbox" checked="checked"> Remember me-->

				</div>
				<div class="container" style="background-color: #f1f1f1">
					<button type="button"
						onclick="document.getElementById('id01').style.display='none'"
						class="cancelbtn">Cancel</button>
					<span class="psw">Forgot <a href="#"
						onclick="document.getElementById('returnpas').style.display='block';document.getElementById('id01').style.display='none';">password?</a></span>
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
					<label><b>phone</b></label> <input name="phone" placeholder="phone"
						type="text">

					<button type="submit">registration</button>
					<!--  <input type="checkbox" checked="checked"> Remember me-->

				</div>
				<div class="container" style="background-color: #f1f1f1">
					<button type="button"
						onclick="document.getElementById('id02').style.display='none'"
						class="cancelbtn">Cancel</button>

				</div>
			</form:form>
		</div>

		<p>${messages.string}</p>

	</sec:authorize>



	<sec:authorize access="isAuthenticated()">

		<div class="fullMainMenu">
			<!------------- audio ------------>
			<button class="audioButton"
				onclick="document.getElementById('audio').style.display='block'"
				style="width: auto;">audio</button>

			<div id="audio" class="modal">

				<div class="modal-content animate">

					<div class="imgcontainer">
						<span
							onclick="document.getElementById('audio').style.display='none'"
							class="close" title="Close Modal">&times;</span>
					</div>

					<div class="container">

						<p>container</p>
						<div>

							<center>

								<audio src="" id="audioPlayer"> Sorry, your browser
									doesn't support html5!
								</audio>
							</center>
						</div>
						<div class="container divPlayList">
							<ul id="playlist">${music}</ul>
						</div>

						<div class="container" style="background-color: #f1f1f1">
							<button type="button"
								onclick="document.getElementById('audio').style.display='none'"
								class="cancelbtn">Cancel</button>
							<!------------- addMusic ------------>

							<button class="profilebutton"
								onclick="document.getElementById('savemusic').style.display='block'"
								style="">add new Music</button>

							<div id="savemusic" class="modal">

								<div class="modal-content animate">
									<div class="imgcontainer">
										<span
											onclick="document.getElementById('savemusic').style.display='none'"
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
											onclick="document.getElementById('savemusic').style.display='none'"
											class="cancelbtn">Cancel</button>

									</div>
								</div>
							</div>

							<!------------- endAddMusic ------------>

						</div>
					</div>
				</div>
			</div>
			<!------------- user ------------>
			<button
				onclick="document.getElementById('userSettings').style.display='block'"
				style="" class="userSettings">
				<img class="imgUserSettings" src="${user.pathImage}" />
			</button>

			<div id="userSettings" class="modal">

				<div class="modal-content animate">

					<div class="imgcontainer">
						<span
							onclick="document.getElementById('userSettings').style.display='none'"
							class="close" title="Close Modal">&times;</span> <img
							src="${user.pathImage}" alt="Avatar" class="avatar">


					</div>

					<div class="container">
						<!------------- add new photo ------------>
						<button class="profilebutton"
							onclick="document.getElementById('savephoto').style.display='block'"
							style="">add new Photo</button>

						<div id="savephoto" class="modal">

							<div class="modal-content animate">
								<div class="imgcontainer">
									<span
										onclick="document.getElementById('savephoto').style.display='none'"
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
										onclick="document.getElementById('savephoto').style.display='none'"
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
								onclick="document.getElementById('userSettings').style.display='none'"
								class="cancelbtn">Cancel</button>
							<span class="pwn">
								<button class="profilebutton" form="formprofile">profile</button>
							</span>
						</form>

					</div>

				</div>

				<!--  <input type="checkbox" checked="checked"> Remember me-->

			</div>

			<marquee id="playerMusic"></marquee>
		</div>
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
<div></div>

<script src="js/math.js"></script>
<script src="js/audioPlayer.js"></script>
<script>
	audioPlayer();
</script>


