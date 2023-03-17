<%-- Document : index Created on : 12-03-2023, 19:12:55 Author : L3oN --%> <%@page import="dao.AccountDAO"%>
<%@page import="dto.Account"%>
<%@page import="dao.PlantDAO"%> <%@page import="dto.Plant"%> <%@page
    import="java.util.ArrayList"%> <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <title>Tech2etc Ecommerce Tutorial</title>
            <link
                rel="stylesheet"
                href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
                integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
                crossorigin="anonymous"
                />
            <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
            <link rel="stylesheet" href="style.css" />
            <link rel="stylesheet" href="toast.css" />
        </head>

        <body>
            <%
// get the token from the cookie
                Cookie[] cookies = request.getCookies();
                String token = null;
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("token")) {
                            token = cookie.getValue();
                            break;
                        }
                    }
                }

// check if the token matches the token in the database
                if (token != null) {
                    Account account = AccountDAO.getAccountByToken(token);
                    if (account != null) {
                        // set the account in the session
                        session.setAttribute("account", account);
                    }
                }
            %>

            <c:import url="header_user.jsp" />

            <section id="hero">
                <h4>Flower shop</h4>
                <h2>Supernorwe badgwg</h2>
                <h1>on all product</h1>
                <p>Save more with coupons & up to 70% off</p>
                <button>Shop Now</button>
            </section>

            <section id="feature" class="section-p1">
                <div class="fe-box">
                    <img src="img/features/f1.png" alt="" />
                    <h6>Free Shipping</h6>
                </div>
                <div class="fe-box">
                    <img src="img/features/f2.png" alt="" />
                    <h6>Online Order</h6>
                </div>
                <div class="fe-box">
                    <img src="img/features/f3.png" alt="" />
                    <h6>Save Money</h6>
                </div>
                <div class="fe-box">
                    <img src="img/features/f4.png" alt="" />
                    <h6>Promotions</h6>
                </div>
                <div class="fe-box">
                    <img src="img/features/f5.png" alt="" />
                    <h6>Happy Sell</h6>
                </div>
                <div class="fe-box">
                    <img src="img/features/f6.png" alt="" />
                    <h6>24/7 Support</h6>
                </div>
            </section>

            <section id="product1" class="section-p1">
                <h2>Featured Products</h2>
                <p>Summer Collection New Morden Design</p>
                <div class="pro-container">
                    <c:forEach items="${PlantDAO.getPlantByCate('Garden Flowers')}" var="r">
                        <div class="pro" onclick="window.location.href = 'MainController?action=sproduct&id=${r.id}'">
                            <img src="${r.imgpath}" alt="" />
                            <div class="des">
                                <!-- catename -->
                                <span>${r.catename}</span>
                                <!-- name -->
                                <h5>${r.name}</h5>
                                <div class="star">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                </div>
                                <!-- price -->
                                <h4>$${r.price}</h4>
                            </div>
                            <a href="MainController?action=addtocart&amp;id=${r.id}"><i class="fal fa-cart-plus cart"></i></a>
                        </div>
                    </c:forEach>
                </div>
            </section>

            <section id="banner" class="section-m1">
                <h4>Repair Services</h4>
                <h2>Up to <span> 70% Off</span> All T-Shirt & Accessories</h2>
                <button class="normal">Explore More</button>
            </section>

            <section id="product1" class="section-p1">
                <h2>New Arrivals</h2>
                <p>Summer Collection New Morden Design</p>
                <div class="pro-container">
                    <c:forEach items="${PlantDAO.getAllPlants()}" var="r">
                        <div class="pro" onclick="window.location.href = 'MainController?action=sproduct&id=${r.id}'">
                            <img src="${r.imgpath}" alt="" />
                            <div class="des">
                                <!-- catename -->
                                <span>${r.catename}</span>
                                <!-- name -->
                                <h5>${r.name}</h5>
                                <div class="star">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                </div>
                                <!-- price -->
                                <h4>$${r.price}</h4>
                            </div>
                            <a href="MainController?action=addtocart&amp;id=${r.id}"><i class="fal fa-cart-plus cart"></i></a>
                        </div>
                    </c:forEach>
                </div>
            </section>

            <c:import url="footer.jsp" />                
            <div id="toast"></div>
            <script>
                $(document).ready(function () {
                    var addSuccess = '${requestScope.addSuccess}';
                    if (addSuccess !== '') {
                        showToast();
                    }
                });

                function showToast() {
                    toast({
                        title: 'Succeeded',
                        message: '${requestScope.addSuccess}',
                        type: 'success',
                        duration: 5000,
                    });
                }

            </script>               



            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script src="script.js"></script>
        </body>
    </html>
