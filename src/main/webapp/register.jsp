<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<form action="register" method="post">

    <label for="first_name">First Name :</label> <input name="first_name">
    <br>
    <label for="second_name">Second Name :</label> <input name="second_name">
    <br>
    <label for="age">Age :</label> <input name="age">
    <br>
    <label for="email">Email :</label> <input name="email">
    <br>
    <label for="password">Password : </label> <input name="password">
    <br>
    <input type="submit" value="submit">
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
