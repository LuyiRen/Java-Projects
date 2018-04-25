<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Money</title>
</head>
<body>

<form action='CurrencyConverter' method='post'>
<input type='text' name='amount' />
<select name='c1'>
<c:forEach items="${data.keySet()}" var="item">
<option>${item}</option>

</c:forEach>
</select>
= ?
<select name='c2'>
<c:forEach items="${data.keySet()}" var="item">
<option>${item}</option>

</c:forEach>
</select>
<button>Convert</button>
</form>


</body>
</html>