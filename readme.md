#### Today I Learned



#### 꺾쇠가 어디에 들어가는가

jsp 코딩시

```jsp
<%
	System.out.print("jspService()");
%>
```

jsp가 java 파일로 컴파일 될 때 <% 는  service 문 내부에 들어감

프로그래밍 코드 기술에 사용



```jsp
<%!
	public void jspInit(){
	System.out.print("jspInit()");
	}
%>
```

jsp가 java 파일로 컴파일(servlet)이 될 때 <!% 는 service 문 바깥에 들어감 클래스 바디쪽이 수정되거나 바디쪽에 들어감

전역변수 선언 및



jsp 주석 처리 단축키 <kbd>ctrl</kbd>+ <kbd>shift</kbd>+ <kbd>/</kbd>

```jsp
<%-- --%>
```

JSP 주석 제거 단축키  <kbd>ctrl</kbd>+ <kbd>shift</kbd>+ <kbd>\\</kbd>