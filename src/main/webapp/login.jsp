<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<form action="login" method="post">
    <label for="email">Email:</label> <input type="email" name="email">
    <br>
    <label for="password">Password:</label> <input type="password" name="password">
    <br>
    <input type="submit" value="Sign In">
</form>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>