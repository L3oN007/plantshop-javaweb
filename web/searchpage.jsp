<%-- Document : searchpage Created on : 12-03-2023, 21:29:03 Author : L3oN --%> <%@page import="java.util.ArrayList"%>
<%@page import="dto.Plant"%> <%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Tech2etc Ecommerce Tutorial</title>
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
        <link rel="stylesheet" href="style.css" />
    </head>

    <body>
        <c:import url="header_user.jsp"/>

        <section id="page-header">
            <h2>#Search</h2>
            <p>Save more with coupons & up to 70% off</p>
        </section>

        <section id="product1" class="section-p1">
            <h2>Search Result For: ${requestScope.keyword}</h2>
            <p>If you are not happy with the results below please do another search</p>
            <div class="pro-container">
                <!-- onclick="window.location.href='sproduct.html'" -->
                <c:if test="${not empty listplants}">
                    <c:forEach items="${listplants}" var="p">
                        <div class="pro" onclick="window.location.href = 'MainController?action=sproduct&id=${p.id}'">
                            <img src="${p.imgpath}" alt="" />
                            <div class="des">
                                <!-- catename -->
                                <span>${p.catename}</span>
                                <!-- name -->
                                <h5>${p.name}</h5>
                                <div class="star">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                </div>
                                <!-- price -->
                                <h4>$${p.price}</h4>
                            </div>
                            <a href="MainController?action=addtocart&amp;id=${p.id}"><i class="fal fa-cart-plus cart"></i></a>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </section>

            <c:import url="footer.jsp"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="script.js"></script>
    </body>
</html>
