<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
id : <%=getId() %>
<%!
	// <%! 의 위치는 jsp 파일 어디에 있든 상관 없습니다.
	String id = "u001"; //멤버변수 선언
	public String getId( ) { //메소드 선언
    	return id;
    }
	 
%>
</body>
</html>