<%-- Document : CartDetail Created on : 13-03-2023, 12:40:06 Author : L3oN --%> <%@page import="dao.PlantDAO"%>
<%@page import="dto.Plant"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html"
        pageEncoding="UTF-8"%> <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    </head>

    <body>
        <c:import url="header_user.jsp" />

        <section id="page-header">
            <h2>#Cart</h2>
            <p>Save more with coupons & up to 70% off</p>
        </section>
        <!-- !Sample -->

        <!-- !Sample -->
        <%
            //doc cart trong session
            HashMap<String, Integer> cart = (HashMap) session.getAttribute("cart");
            if (cart != null && cart.size() > 0) {
        %>
        <section id="cart" class="section-p1">
            <table width="100%">
                <thead>
                    <tr>
                        <td>Remove</td>
                        <td>Image</td>
                        <td>Plant</td>
                        <td>Price</td>
                        <td>Quantity</td>
                        <td>Subtotal</td>
                    </tr>
                </thead>

                <tbody>
                    <%
                        float total = 0;
                        for (String id : cart.keySet()) {
                            Plant p = PlantDAO.getPlant(id);
                    %>
                <form action="MainController" method="post">
                    <tr>
                        <td>
                            <!-- FIXME::fix to button -->
                            <button type="submit" value="remove" name="action"><i class="fal fa-minus-circle"></i></button>
                        </td>
                        <td><img src="<%= p.getImgpath()%>" alt="" /></td>
                        <td><%= p.getName()%></td>
                        <td><%= p.getPrice()%></td>
                        <td>
                            <div class="wrapper-quantity">
                                <button class="minus" onclick="minus(event)" type="submit" value="update" name="action">-</button>
                                <input id="<%= p.getId()%>" class="num" type="number" value="<%= cart.get(id)%>" min="1" max="10" name="quantity" readonly>
                                <button class="plus" onclick="plus(event)" type="submit" value="update" name="action">+</button>
                            </div>
                        </td>
                        <td><%= p.getPrice() * cart.get(id)%></td>
                    <input type="hidden" value="<%= p.getId()%>" name="plantid"/>
                    </tr>
                </form>
                <%
                        total = total + p.getPrice() * cart.get(id);
                    }
                %>
                </tbody>
            </table>
        </section>

        <section id="cart-add" class="section-p1">
            <div id="coupon">
                <h3>Apply Coupon</h3>
                <div>
                    <input type="text" placeholder="Enter Your Coupon" />
                    <button class="normal">Apply</button>
                </div>
            </div>

            <div id="subtotal">
                <h3>Cart Totals</h3>
                <table>
                    <tr>
                        <td>Cart Subtotal</td>
                        <td>$<%= total%></td>
                    </tr>
                    <tr>
                        <td>Shipping</td>
                        <td>Free</td>
                    </tr>
                    <tr>
                        <td><strong>Total</strong></td>
                        <td><strong>$<%= total%></strong></td>
                    </tr>
                </table>
                <form action="MainController" method="post">
                    <button id="checkout-btn" class="normal" type="submit" value="checkout" name="action">Proceed to checkout</button>
                </form>
            </div>
        </section>
        <%
        } else { %>
        <div style="text-align: center; padding: 80px">
            <img src="img/noCart1.png" alt="" style="">
        </div>
        <%}
        %>
        <style>


            tbody td button {
                background: none;
                border: none;
                color: inherit;
                padding: 0;
                font: inherit;
                cursor: pointer;
                outline: inherit;
            }

            input[type=number]::-webkit-inner-spin-button, 
            input[type=number]::-webkit-outer-spin-button { 
                -webkit-appearance: none; 
                margin: 0; 
            }
        </style>

        <c:import url="footer.jsp" />
        <div id="toast"></div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="script.js"></script>
        <script>
                                    $(document).ready(function () {
                                        var removeSuccess = '${requestScope.removeSuccess}';
                                        if (removeSuccess !== '') {
                                            showToast();
                                        }
                                    });

                                    function showToast() {
                                        toast({
                                            title: 'Succeeded',
                                            message: '${requestScope.removeSuccess}',
                                            type: 'success',
                                            duration: 5000,
                                        });
                                    }

                                    // !button + -
                                    function minus(event) {
                                        var id = event.target.parentNode.querySelector('.num').id;
                                        var input = document.getElementById(id);
                                        if (input.value > 1) {
                                            input.value--;
                                        }
                                    }

                                    function plus(event) {
                                        var id = event.target.parentNode.querySelector('.num').id;
                                        var input = document.getElementById(id);
                                        if (input.value < 10) {
                                            input.value++;
                                        }
                                    }

                                    
        </script>
    </body>
</html>
