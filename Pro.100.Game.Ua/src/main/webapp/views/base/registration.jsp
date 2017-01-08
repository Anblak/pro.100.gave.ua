<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<fieldset>

${usernameException}${emailException}${passwordException}
<form:form modelAttribute="user" action="saveUser" method="post">
<input name="name" class="validate[required,custom[username],length[0,100]] feedback-input" placeholder="name ${usernameException}">
<input name="email" class="validate[required,custom[email],length[0,100]] feedback-input" type="email" placeholder="email ${emailException}">
<input name="password" class="validate[required,custom[password],length[0,100]] feedback-input" type="password"" placeholder="password ${passwordException}">
<input name="phone" placeholder="phone">
<button>save user</button>
</form:form>
</fieldset>
