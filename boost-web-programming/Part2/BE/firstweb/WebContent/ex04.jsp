<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%-- jsp �ּ� �Դϴ�. --%>
<!-- html �ּ� �Դϴ�.  -->

<%
// �ڹ� �ּ� �Դϴ�.
/* ������ */
for(int i=1; i<=5; ++i){
%>
<h<%=i%>> �Ƹ��ٿ� �ѱ� </h<%=i%>>
<%
}
%>


</body>
</html>