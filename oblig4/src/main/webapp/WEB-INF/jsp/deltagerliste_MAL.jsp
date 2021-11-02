<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		
	<c:forEach items="${deltagere}" var="d">
	
		
	<c:if test="${innlogget eq d.mobilNr}">
	
		<tr bgcolor="#ffaaff">
			<th><c:out value="${d.kjonn}"/></th>
			<th align="left"><c:out value="${d.fornavn}"/></th>
			<th align="left"><c:out value="${d.mobilNr}"/></th>
		</tr>
		
	
	</c:if>
	<c:if test="${!(innlogget eq d.mobilNr)}">
	
		<tr bgcolor="#ffffff">
			<th><c:out value="${d.kjonn}"/></th>
			<th align="left"><c:out value="${d.fornavn}"/></th>
			<th align="left"><c:out value="${d.mobilNr}"/></th>
		</tr>
		
	
	
	</c:if>
	</c:forEach>
	</table>
	
	
	
	<p>
		<a href="Loggut">Ferdig</a>
	</p>
</body>
</html>