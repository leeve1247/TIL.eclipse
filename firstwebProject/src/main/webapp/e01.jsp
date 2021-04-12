<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 	
request.setAttribute("k",10);
request.setAttribute("m",true);
%>
<!DOCTYPE html>
<%
	pageContext.setAttribute("p1","page scope value");
	request.setAttribute("r1","request scope");
	session.setAttribute("s1","session scope value");
	application.setAttribute("a1","application scope value");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	k: %{k} <br>
	k + 5 : ${k + 5 }<br>
	k - 5 : ${k - 5 }<br>
	k * 5 : ${k * 5 }<br>
	k / 5 : ${k div 5 }<br>
	
	k : ${k }<br>
	m : ${m }<br>
	k: ${k} <br>
	
	k > 5 : ${k > 5 }<br>
	k <= 5 : ${k <= 5 }<br>
	k >= 5 : ${k >= 5 }<br>
	m : ${m}<br>
	!m : ${!m}<br>
</body>
</html>