<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>

${user.id} <br>
${user.password} <br>

<form method="post" action="/dologin">
	<input type="text" name="id" />
	<input type="text" name="password" />
	<input type="submit" />
</form>

</body>
</html>