
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <title><tiles:getAsString name="title"/></title>
    <link rel="stylesheet" href="css/template.css">
  </head>
  <body>
  
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
<!--   ГООООООРИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИИТЬ -->
      	<div class="body">
          <tiles:insertAttribute name="body" />
     	</div>
     	
          <tiles:insertAttribute name="footer" />
   		
  </body>
</html>