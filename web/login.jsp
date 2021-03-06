<!DOCTYPE html>
<html>

<head>
    <link rel=stylesheet href="themes/style.css" type="text/css">
    <title>Login</title>
    <jsp:useBean id="donor" class="model.Donor" scope="session"></jsp:useBean>
    <jsp:useBean id="staff" class="model.Staff" scope="session"></jsp:useBean>
    <% if (staff.getPosition().equals("Management") || staff.getPosition().equals("Staff") || staff.getPosition().equals("Guest")) { %>
    <style>
        a[href=viewmember] {
            display : none;
        }
        a[href=event] {
            display : none;
        }
    </style>
    <% } %>
</head>

<body style="background-color:rgb(240,240,240)">
<div class="topnav" id="myTopnav">
    <div class="logo">
        <a href="homepage.jsp"><img src="pictures/textlogo.png"></a>
    </div>
    <div class="dropdown">
        <a href="aboutus.jsp" class="dropbtn">About Us</a>
    </div>
    <div class="dropdown">
        <a href="faq.jsp" class="dropbtn">FAQ</a>
    </div>
    <div class="right" style="padding-right: 300px;">
        <% if (staff.getPosition().equals("Guest")) {%>
        <a href="login.jsp">Login</a>
        <a href="register.jsp">Register</a>
         <% } else { %>
            <a href="editprofile.jsp">Profile</a>
            <a href="logout">Logout</a>
        <% } %>
    </div>
</div>
    <div class="content">
        <h1>Login</h1>
        <hr/>
        <form class="login" action="login" method="post">
            <input type="text" name="username" id="username" placeholder="Username" required="required"><br/>
            <input type="password" name="password" id="password" placeholder="Password" required="required"><br/>

            <input type="submit" name="submit" id="submit" value="Login"><br/><br/>

            <a href="" onclick="alert('Please contact Oracle Blood Bank committee to change your password.')">Forgot your password ?</a>&nbsp;&nbsp;&nbsp; <a href="register.jsp">Sign Up a new Account</a>
        </form>
    </div>

    <footer>Oracle Blood Bank<sup>&reg;</sup> All Rights Reserved</footer>
</body>
</html>