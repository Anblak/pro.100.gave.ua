<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
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
						<label><img
							src="img/useranon.png" alt="Avatar" class="avatar"></label>
							</div>
							
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