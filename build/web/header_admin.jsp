<%-- Document : header_user Created on : 13-03-2023, 11:46:19 Author : L3oN --%> <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
        <section id="header">
            <a href="#"><img src="img/logo.png" alt="" class="logo" /></a>
            <div>
                <!-- ! Navbar -->
                <ul id="navbar">
                    <li><a class="active" href="index.jsp">Test Shop</a></li>
                    <li><a href="Admin.jsp">Manage Accounts</a></li>
                    <li><a href="ManageOrder.jsp">Manage Orders</a></li>
                    <li><a href="ManagePlant.jsp">Manage Plants</a></li>
                    <li><a href="ManageCategory.jsp">Manage Categories</a></li>                                       
                    <li>
                        <a href="#"><i class="fas fa-user-circle" onclick="menuToggle();" style="font-size: 25px"></i></a>
                    </li>
                </ul>
                <!-- !Account -->
                <div class="action">
                    <div class="profile" onclick="menuToggle();"></div>
                    <div class="menu">
                        <% if (session.getAttribute("account") != null) { %>
                        <h3>${sessionScope.account.fullname}<br /><span>Admin</span></h3>
                            <%} else {%>
                        <h3>To log in or register, please click the button below</h3>
                        <% }%>
                        <ul>
                            <% if (session.getAttribute("account") != null) { %>
                            <li><img src="img/account/edit.png" alt="" /><a href="AccountSetting.jsp">Edit Profile</a></li>
                                <c:if test="${sessionScope.account.role == 1}">
                                <li><img src="img/account/admin.png" alt="" /><a href="Admin.jsp">Admin Page</a></li>
                                </c:if>
                            <li><img src="img/account/settings.png" alt="" /><a href="AccountSetting.jsp">Setting</a></li>
                            <form action="LogoutServlet">
                                <li><img src="img/account/log-out.png" alt="" /><button type="submit" name="btAction" value="Log Out">Logout</button></li>
                            </form>
                            <%} else {%>
                            <li><img src="img/account/login.png" alt="" /><a href="login.jsp">Login</a></li>
                            <li><img src="img/account/verify.png" alt="" /><a href="login.jsp">Register</a></li>
                                <% }%>
                        </ul>
                    </div>
                </div>
            </div>
        </section>
        <style>
            .action ul li button {
                background: none;
                border: none;
                color: red;
                padding: 0;
                font: inherit;
                cursor: pointer;
                outline: inherit;
            }
        </style>                             
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="script.js"></script>
    </body>
</html>
