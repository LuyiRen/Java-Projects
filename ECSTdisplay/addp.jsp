<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
             <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add someone</title>
</head>
<body>
<form action='ecstdisplay' method='post'>
<table border='1'>
<tr>
<th>
Department:<th>
<select name='whatdept'>
<c:forEach items="${dept}" var="a" varStatus="row">
<option value="${a.name}">${a.name}</option>
</c:forEach>
</select>
</tr>

<tr>
<th>Name: </th>
<td>
<input type='text' name='n'></td>
</tr>

<tr>
<th>Chair: </th>
<td>
<input type='checkbox' name='chair' value='chair'></td>
</tr>
<button>Add person</button>
</form>

</table>
</body>
</html>