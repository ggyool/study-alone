<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="t" value="<script type='text/javascript'>alert(1);</script>" />

<%--${t } --%>  // 경고창 잘 뜸

<c:out value="${t }" escapeXml="true"/> <%--true 기본값 --%> // 변환되기 때문에 코드 그대로 감

<c:out value="${t }" escapeXml="false"/> // 경고창 잘 뜸

</body>
</html>

