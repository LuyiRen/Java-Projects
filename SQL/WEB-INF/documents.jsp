<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Avaliable Documents</title>
</head>
<body>
<c:choose>
<c:when test="${empty file}">
Nothing found.
<a href="lab19">Beginning</a>
</c:when>
<c:otherwise>
<h1><a href="lab19?click=${click2}&current=${current}">...</a> \ ${current}</h1>
<p><a href="AddFolder">Add Folder</a></p>


<table>
<c:forEach items="${file}" var="f">
<c:if test="${f.owner_id==1 and f.is_folder==true and f.parent_id==0}">
<tr>
<th>
<p><a href="lab19?current=${f.name}&click=${f.id}" >${f.name}</a>
</p>
<td>
<form method="get" action="rename">
<input type='hidden' name='id' value="${f.id}"/>
<input type='hidden' name='name' value='${f.name}'/>
<button>Rename</button>
</form>
</td>
<td>
<form method="get" action="delete">
<input type='hidden' name='delete' value="${f.id}"/>
<button>Delete</button>
</form>
<td>
<th>
</c:if>
</c:forEach>
</tr>
<c:forEach items="${file}" var="f">
<tr>
<c:if test="${f.owner_id==1 and f.is_folder==false}">
<th>
<p>${f.name}</p>
<td>
<form method="get" action="rename">
<input type='hidden' name='id' value="${f.id}"/>
<button>Rename</button>
</form>
</td>
<td>
<form method="get" action="delete">
<input type='hidden' name='delete' value="${f.id}"/>
<button>Delete</button>
</form>
</td>
</th>
<tr>
</c:if>
</c:forEach>
</c:otherwise>
</c:choose>
</table>
</body>
</html>