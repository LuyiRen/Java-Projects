<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ECST</title>
</head>
<body>
<h1>ECST Faculty</h1>
<form action="ecstdisplay" form='get'>
<input type='hidden' name='adddept' value='adddept'>
<button>Add Department</button>
</form>
<form action="ecstdisplay" form='get'>
<input type='hidden' name='addp' value='addp'>
<button>Add Faculty</button>
</form>
<table border="1">
<tr><th>Department</th><th>Faculty</th>

<c:forEach items="${dept}" var = "a" varStatus="row">
<tr>
<c:choose>
<c:when test="${empty a.people}">
</c:when>
<c:otherwise>
<td rowspan='${fn:length(a.people)}'>${a.name}</td>
</c:otherwise>
</c:choose>

<c:forEach items="${a.people}" var="p" varStatus="count">
<td>${p}</td>
</tr>
<tr>
</c:forEach>
</c:forEach>
</table>

</body>
</html>