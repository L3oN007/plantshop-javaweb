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
                <!-- !Search bar -->
                <form action="MainController" method="get">
                    <div class="wrapper" style="display: none">
                        <div class="search_box">
                            <div class="dropdown">
                                <input type="hidden" name="searchby" />
                                <div id="selectText" class="default_option" onclick="toggleDropdown()">SEARCH BY</div>
                                <ul class="dropdown-menu">
                                    <li class="options" onclick="selectOption('byname')">By Name</li>
                                    <li class="options" onclick="selectOption('bycategory')">By Category</li>
                                </ul>
                            </div>
                            <div class="search_field">
                                   <input type="text" class="input" id="inputfield" placeholder="Search" name="txtsearch" value="<%=(request.getParameter("keyword")
                                           != null) ? request.getParameter("keyword") : ""%>" />
                                <input type="submit" value="find" name="action" style="display: none" />
                                <i class="fas fa-search"></i>
                            </div>
                        </div>
                    </div>
                </form>
                <!-- ! Navbar -->
                <ul id="navbar">
                    <li><a class="active" href="index.jsp">Home</a></li>
                    <li><a href="AllOrder.jsp">All Orders</a></li>
                    <li><a href="CompletedOrder.jsp">Completed Orders</a></li>
                    <li><a href="ProcessingOrder.jsp">Processing Orders</a></li>                    
                    <li><a href="CanceledOrder.jsp">Canceled Orders</a></li>
                    <li>
                        <a href="#"><i class="far fa-search search_icon" style="font-size: 18px"></i></a>
                    </li>
                    <li>
                        <a href="MainController?action=viewdetailcart"><i class="far fa-shopping-bag" style="font-size: 18px"></i></a>
                    </li>
                    <li>
                        <a href="#"><i class="fas fa-user-circle" onclick="menuToggle();" style="font-size: 25px"></i></a>
                    </li>
                </ul>
                <!-- !Account -->
                <div class="action">
                    <div class="profile" onclick="menuToggle();"></div>
                    <div class="menu">
                        <% if (session.getAttribute("account") != null) { %>
                        <h3>${sessionScope.account.fullname}<br /><span>User</span></h3>
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
                                <input type="hidden" value="${sessionScope.account.accID}" name="accID"/>
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
