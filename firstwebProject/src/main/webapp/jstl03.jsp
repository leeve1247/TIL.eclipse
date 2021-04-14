<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<% 	
request.setAttribute("score",53);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${score >= 90}">
		A학점인 것인데스웅	
	</c:when>
	<c:when test="${score >= 80 && score <90}">
		B학점인 것인데스웅	
	</c:when>
	<c:when test="${score >= 70 }">
		C학점인 것인데스웅	
	</c:when>
	<c:when test="${score >= 60 }">
		D학점인 것인데스웅	
	</c:when>
	<c:otherwise>
		F학점인 것인데스웅	
	</c:otherwise>
</c:choose>

</body>
</html>