<%-- 
    Document   : header_user
    Created on : 13-03-2023, 11:46:19
    Author     : L3oN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link
            rel="stylesheet"
            href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
            />
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
        <footer class="section-p1">
            <div class="col">
                <img class="logo" src="img/logo.png" alt="">
                <h4>Contact</h4>
                <p><strong>Address:</strong> FPT University</p>
                <p><strong>Phone:</strong> +84 4567 8910</p>
                <p><strong>Hours:</strong> 9:00 - 17:30, Mon - Sat</p>
                <div class="follow">	
                    <h4>Follow us</h4>
                    <div class="icon">
                        <i class="fab fa-facebook facebook"></i>
                        <i class="fab fa-twitter twitter"></i>
                        <i class="fab fa-instagram instagram"></i>
                        <i class="fab fa-pinterest pinterest"></i>
                        <i class="fab fa-youtube youtube"></i>
                    </div>
                </div>
            </div>

            <div class="col">
                <h4>About</h4>
                <a href="#">About us</a>
                <a href="#">Delivery Information</a>
                <a href="#">Privacy Policy</a>
                <a href="#">Terms & Conditions</a>
                <a href="#">Contact Us</a>
            </div>

            <div class="col">
                <h4>My Account</h4>
                <a href="#">Sign in</a>
                <a href="#">View Cart</a>
                <a href="#">My Wishlist</a>
                <a href="#">Track My Order</a>
                <a href="#">Help</a>
            </div>

            <div class="col install"> 
                <h4>Install App</h4>
                <p>From App Store or Google Play</p>
                <div class="row">
                    <img src="img/pay/app.jpg" alt="">
                    <img src="img/pay/play.jpg" alt="">
                </div>
                <p>Secured payment Gateways </p>
                <img src="img/pay/pay.png" alt="">
            </div>

            <div class="copyright">
                <p>&copy; 2023, PRJ301 - Vu Minh Nhat</p>
            </div>
        </footer>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="script.js"></script> 
    </body>
</html>
