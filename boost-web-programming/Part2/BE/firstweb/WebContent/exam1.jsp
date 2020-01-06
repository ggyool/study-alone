<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
id : <%=getId()%>
<%!
	String id = "u001";
	public String getId(){
		return id;
	}
%>
</body>
</html>