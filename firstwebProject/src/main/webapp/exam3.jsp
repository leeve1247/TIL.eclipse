<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
	//request, out은 이미 내장 객체로, 선언할 거 없이 써먹을 수가 있다
	StringBuffer url = request.getRequestURL();
	
	out.print("url :" + url.toString());
	out.print("<br>");
	
%>
</body>
</html>