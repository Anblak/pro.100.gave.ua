<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  


  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<input type="text" id="title">
<input type="text" id="pages">
<button id="saveBook">save book</button>

<script type="text/javascript">



document.getElementById('saveBook').onclick = function () {

    var city = {

        title : $('#title').val(),
		pages : $('#pages').val()
        

    }

    document.getElementById('title').value = '';
    document.getElementById('pages').value = '';
    $.ajax({

        url: 'saveBook?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(book),
        success : function (res) {



        }


    })



}




















</script>

</body>
</html>