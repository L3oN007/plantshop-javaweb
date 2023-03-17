<%-- Document : CartDetail Created on : 13-03-2023, 12:40:06 Author : L3oN --%> <%@page import="dao.OrderDAO"%>
<%@page import="dto.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.PlantDAO"%>
<%@page import="dto.Plant"%>
<%@page contentType="text/html"
        pageEncoding="UTF-8"%> <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <c:import url="header_user.jsp" />

        <section id="page-header">
            <h2>#Cart</h2>
            <p>Save more with coupons & up to 70% off</p>
        </section>

        <section id="cart" class="section-p1">
            <table width="100%">
                <thead>
                    <tr>
                        <td>Order ID</td>
                        <td>Order Image</td>
                        <td>Plant Name</td>
                        <td>Order's Status</td>
                        <td>Quantity</td>
                        <td>Price</td>
                    </tr>
                </thead>

                <tbody>                   
                    <%String orderID = request.getParameter("orderID"); //get orderID%>                                          
                    <c:if test="${not empty param.orderID}">  
                        <c:set var="total" value="0" />
                        <c:forEach items="${OrderDAO.getOrderByOrderID(param.orderID)}" var="o">
                            <tr>
                                <td>
                                    ${o.orderID}
                                </td>
                                <td><img src="${o.imgPath}" alt="" /></td>                                   
                                <td>${o.plantName}</td>
                                <c:if test="${o.status == 3}">
                                    <td><p class="status cancelled">Cancelled</p></td>
                                </c:if>
                                <c:if test="${o.status == 1}">
                                    <td><p class="status pending">Pending</p></td>
                                </c:if>                              
                                <c:if test="${o.status == 2}">
                                    <td><p class="status delivered">Delivered</p></td>
                                </c:if>

                                <td>${o.quantity}</td>
                                <td>
                                    ${o.price}
                                </td>
                            </tr>
                            <c:set var="total" value="${total + (o.quantity * o.price)}" />
                        </c:forEach>
                    </c:if>
                </tbody>
            </table>
        </section>

        <section id="cart-add" class="section-p1">
            <div id="coupon">
                <h3>We hope you enjoy our service.</h3>
                <div>

                </div>
            </div>
            <div id="subtotal">
                <h3>Order Totals</h3>
                <table>
                    <tr>
                        <td>Order Subtotal</td>
                        <td>$${total}</td>
                    </tr>
                    <tr>
                        <td>Shipping</td>
                        <td>Free</td>
                    </tr>
                    <tr>
                        <td><strong>Total</strong></td>
                        <td><strong>$${total}</strong></td>
                    </tr>
                </table>
            </div>
        </section>
        <style>


            .status {
                padding: 10px 0;
                border-radius: 2rem;
                text-align: center;
                width: 100%;

            }

            .status.delivered {
                background-color: #86e49d;
                color: #006b21;
            }

            .status.cancelled {
                background-color: #d893a3;
                color: #b30021;
            }

            .status.pending {
                background-color: #ebc474;
            }

            .status.shipped {
                background-color: #6fcaea;
            }
            tbody td button {
                background: none;
                border: none;
                color: inherit;
                padding: 0;
                font: inherit;
                cursor: pointer;
                outline: inherit;
            }
        </style>


        <c:import url="footer.jsp" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="script.js"></script>
    </body>
</html>
