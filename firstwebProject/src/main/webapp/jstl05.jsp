<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core"%>

<c:import url="http://localhost:8080/firstwebProject/jstlValue.jsp" var="urlValue" scope="request"/>
<!-- 크롤링할 수 있는 강력한 툴이지 않을까 -->
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 ${urlValue }
</body>
</html>