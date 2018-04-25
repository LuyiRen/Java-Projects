<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rename This File</title>
</head>
<body>
<form action='rename' method='post'>
<input type="text" name = "newname"/>
<input type="hidden" name="id" value="${id}"/>
<button> Submit Change</button>

</form>

</body>
</html>