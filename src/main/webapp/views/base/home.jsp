<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<link rel="stylesheet" href="css/home.css">
<div class="container1">
	<div class = "mainText">
		<h4>Hey, dear user</h4>
		<h3>On this web-application u can:</h3>
		<ul>
			<li>Create your own group of users</li>
			<li>Users in group can share files between themself</li>
			<li>And find files very quickly</li>
		</ul>
	</div>
	<sec:authorize access="hasRole('ROLE_ADMIN')">

		<a href="admin">admin page</a>
		<br> <a href="math">math</a>
	</sec:authorize>

	<sec:authorize access="hasRole('ROLE_USER')">
		<a href="profile">profile</a>
		<br> <a href="math">math</a>
	</sec:authorize>

	<sec:authorize access="hasRole('ROLE_CREATOR')">
		<a href="profile">profile</a>
		<br> <a href="math">math</a>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_USER_IN_GROUP')">
		<a href="profile">profile</a>
		<br> <a href="math">math</a>
	</sec:authorize>


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

