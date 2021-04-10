<%@ page language="java"
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"
%>
<!-- 모든 JSP는 서블릿으로 바뀌어서 동작함
	 이때 사용되는 상단 꺽쇠는 페이지 지시문 
	 language = "java" 이론적으로 여러 언어를 쓸 수 있지만 jsp에서는 jav만 써라
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	int total = 0;
	for(int i = 1; i <= 10; i++){
		total = total + i;
	}
%>
<!--  상단의 경우 scriptlet이라 하며, 자바코드를 넣을 수 있다. -->

1부터 10까지의 합: <%= total %>
<!-- out.print(total); -> <%=total%> -->
</body>
</html>