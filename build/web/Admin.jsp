<%-- Document : index Created on : 12-03-2023, 19:12:55 Author : L3oN --%> <%@page import="dao.AccountDAO"%> <%@page import="dto.Account"%> <%@page
    import="dao.PlantDAO"%> <%@page import="dto.Plant"%> <%@page import="java.util.ArrayList"%> <%@taglib prefix="c"
                                                                                                      uri="http://java.sun.com/jsp/jstl/core" %> <%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                boolean search = false;
            %>

            <c:import url="header_admin.jsp" />

            <section id="hero">
                <h4>Admin Page</h4>
                <h2>Hello and welcome back, admin!</h2>
                <h1>gggg</h1>
            </section>

            <section id="product1" class="section-p1">
                <h2>Accounts List</h2>
                <p>Summer Collection New Morden Design</p>
            </section>

            <section id="cart" class="section-p1">               
                <form class="search-container" action="MainController" method="post">
                    <input type="text" id="search-bar" placeholder="Enter email or fullname" name="txtsearch" value="${param.txtsearch}" />
                    <input type="submit" value="searchacc" name="action" style="display: none">
                    <a href="#"><img class="search-icon" src="http://www.endlessicons.com/wp-content/uploads/2012/12/search-icon.png" /></a>
                </form>
                <table width="100%">
                    <thead>
                        <tr>
                            <td>Acc ID</td>
                            <td>Email</td>
                            <td>Password</td>
                            <td>Full Name</td>
                            <td>Phone Number</td>
                            <td>Option</td>
                            <td>Option</td>
                        </tr>
                    </thead>

                    <tbody>                                              
                    <c:forEach items="${AccountDAO.getAllAccounts()}" var="a">
                        <form action="MainController" method="post">
                            <tr>
                                <td>${a.accID}</td>
                                <td>${a.email}</td>
                                <td>${a.password}</td>
                                <td>${a.fullname}</td>
                                <td>${a.phone}</td>
                                <c:if test="${a.status == 1}">
                                    <td><p class="status delivered">Available</p></td>
                                </c:if>
                                <c:if test="${a.status == 0}">
                                    <td><p class="status cancelled">Ban</p></td>
                                </c:if>
                                <c:if test="${a.role == 0}">
                                    <td>
                                        <input type="hidden" value="${a.email}" name="email"/>
                                        <input type="hidden" value="${a.status}" name="status"/>
                                        <c:if test="${a.status == 1}">
                                            <button type="submit" value="banacc" name="action">Ban</button>
                                        </c:if>
                                        <c:if test="${a.status == 0}">
                                            <button type="submit" value="banacc" name="action">Unban</button>
                                        </c:if>
                                    </td>
                                </c:if>
                            </tr>
                        </form>
                    </c:forEach>
                    </tbody>
                </table>
            </section>

            <c:import url="footer.jsp" />
            <div id="toast"></div>
            <style>
                #cart {
                    padding-top: 0;
                }

                #hero {
                    background-image: url('img/banner/admin.png');
                    height: 90vh;
                    width: 100%;
                    background-position: top 25% right 0;
                    background-size: cover;
                    padding: 0 80px;
                    display: flex;
                    align-items: flex-start;
                    justify-content: center;
                    flex-direction: column;
                }

                #hero h2 {
                    color: #fff;
                }

                #cart table td:nth-child(1) {
                    width: 100px;
                    text-align: center;
                }

                #cart table td:nth-child(2) {
                    width: 150px;
                    text-align: center;
                }

                #cart table td:nth-child(3) {
                    width: 150px;
                    text-align: center;
                }

                #cart table td:nth-child(4),
                #cart table td:nth-child(5),
                #cart table td:nth-child(6),
                #cart table td:nth-child(7){
                    width: 150px;
                    text-align: center;
                }

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

                tbody td button {
                    background: none;
                    border: none;
                    color: inherit;
                    padding: 0;
                    font: inherit;
                    cursor: pointer;
                    outline: inherit;
                    color: red;
                }

                input[type=number]::-webkit-inner-spin-button, 
                input[type=number]::-webkit-outer-spin-button { 
                    -webkit-appearance: none; 
                    margin: 0; 
                }
            </style>
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
