<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
 PDA-21-login-page
<br>
<a href="pda/v1/login">login</a>

<form action="hello-servlet" method="post">
    <input name = "id" type="text">
    <input name ="submit" type="submit">
</form>

</body>
</html>