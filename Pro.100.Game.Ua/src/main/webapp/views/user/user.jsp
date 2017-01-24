<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="container">
			<!-- info -->
			<div class="container">
				<div>
					<label><img src="http://localhost:8080/Pro.100.Game.Ua/${user.pathImage}" alt="img/useranon.png"
						class="avatar"></label>
				</div>



				<br>

				<button
					onclick="document.getElementById('savephoto').style.display='block'"
					style="width: auto;">Save Photo</button>

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
				<div id="" class="modal">


					<label><b>name</b>: ${userT.name}</label>

				</div>
				<div class="container">
					<label><b>email</b>:${userT.email}</label>
				</div>
				<div class="container">
					<label><b>phone</b>:${userT.phone}</label>
				</div>
				<div class="container">
					<sec:authorize access="hasRole('ROLE_CREATOR')">
						<label><div class="uidGroup">
								<b>uidGroup: </b>
								<p class="pu">http://localhost:8080/</p>
								<p class="pu">Pro.100.Game.Ua/confirmAdd/</p>
								<p class="pu">${groupUID.uuid}</p>
							</div></label>
					</sec:authorize>
				</div>
			</div>
</body>
</html>