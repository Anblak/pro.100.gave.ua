<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Search</title>
</head>
<body>
<c:forEach var="file" items="${searchResult}">
    <a href="http://localhost:8080/${file.path}">${file.name}</a>
    <br>
</c:forEach>
</body>
</html>