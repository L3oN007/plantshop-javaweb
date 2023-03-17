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
                <input >
                <table width="100%">
                    <thead>
                        <tr>
                            <td>Acc ID</td>
                            <td>Email</td>
                            <td>Password</td>
                            <td>Full Name</td>
                            <td>Phone Number</td>
                            <td>Option</td>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${AccountDAO.getAllAccounts()}" var="a">
                            <tr>
                                <td>${a.accID}</td>
                                <td>${a.email}</td>
                                <td>${a.password}</td>
                                <td>${a.fullname}</td>
                                <td>${a.phone}</td>                                                            
                                    <td>
                                        <button type="submit" value="remove" name="action"><i class="fas fa-redo-alt rebuy"></i></button>
                                    </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </section>
        


        <c:import url="footer.jsp" />                
        <div id="toast"></div>
        <style>
            #cart{
                padding-top: 0;
            }
            
            #hero{
                background-image: url("img/banner/admin.png");
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

            #hero h2{
                color: #fff;
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
