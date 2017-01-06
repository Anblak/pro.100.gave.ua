<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	
<sec:authentication property="name" />

<sec:authorize access="isAuthenticated()">

	<form:form action="logout" method="post">
		<button>logout</button>
	</form:form>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
	<br>
	<a href="loginpage">login</a>
	<br>
	<a href="registration">registration</a>
	<br>
	<a href="math">math</a>
</sec:authorize>


<sec:authorize access="hasRole('ROLE_ADMIN')">

	<a href="admin">admin page</a>

</sec:authorize>

<sec:authorize access="hasRole('ROLE_USER')">
	<a href="profile">profile</a>
</sec:authorize>




