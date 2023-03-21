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
            <c:choose>
                <c:when test="${sessionScope.admin == null}">                   
                    <jsp:forward page="login.jsp"/>
                </c:when>
                <c:otherwise>
                    <c:import url="header_admin.jsp" />

                    <section id="hero">
                        <h4>Admin Page</h4>
                        <h2>Hello and welcome back, admin!</h2>
                        <h1>gggg</h1>
                    </section>

                    <section id="product1" class="section-p1">
                        <h2>Plants List</h2>
                        <p>Summer Collection New Morden Design</p>
                    </section>

                    <section id="search-box">
                        <form class="search-container" action="MainController" method="post">
                            <input type="text" id="search-bar" placeholder="Enter plant name" name="txtsearch" value="${param.txtsearch}" />
                            <input type="submit" value="searchplant" name="action" style="display: none">
                            <c:if test="${requestScope.flag != null}">
                                <p>Not found what you looking for!</p>
                            </c:if>
                        </form>
                    </section>

                    <section id="cart" class="section-p1">                                     
                        <table width="100%">
                            <thead>
                                <tr>
                                    <td>PID</td>
                                    <td>Img</td>
                                    <td>Plant Name</td>
                                    <td>Description</td>
                                    <td>Price</td>
                                    <td>Status</td>
                                    <td>Cate id</td>
                                    <td>Cate name</td>
                                    <td>Option</td>
                                </tr>
                            </thead>

                            <tbody>                                              
                                <c:forEach items="${empty requestScope.listplants ? PlantDAO.getAllPlants() : requestScope.listplants}" var="p">
                                <form action="MainController" method="post">
                                    <tr>
                                        <td>${p.id}</td>
                                        <td><img src="${p.imgpath}"/></td>
                                        <td>${p.name}</td>
                                        <td><a href="">Detail</a></td>
                                        <td>$${p.price}</td>
                                        <td>
                                            <c:if test="${p.status == 1}">
                                                <p class="status delivered">Available</p>
                                            </c:if>
                                            <c:if test="${p.status == 0}">
                                                <p class="status cancelled">Out of stock</p>
                                            </c:if>
                                        </td>
                                        <td>${p.cateid}</td>
                                        <td>${p.catename}</td>
                                        <td>
                                            <input type="hidden" name="PID" value="${p.id}">
                                            <input type="hidden" name="status" value="${p.status}">
                                            <button type="submit" value="updateplantstatus" name="action"><i class="fas fa-times"></i></button>
                                            <a href="EditPlant.jsp?PID=${p.id}"><i class="far fa-edit edit"></i></a>
                                            <!--<button><i class="fas fa-store-alt-slash"></i></button>-->
                                        </td>                                
                                    </tr>
                                </form>
                            </c:forEach>
                            </tbody>
                        </table>
                    </section>

                    <c:import url="footer.jsp" />
                </c:otherwise>
            </c:choose>
            <div id="toast"></div>
            <style>
                #search-box{
                    margin-bottom: 50px;
                }
                #search-box p{
                    text-align: center;
                    color: red;
                }
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

                #cart table td:nth-child(2) {
                    width: 150px;
                    text-align: center;
                }

                #cart table td:nth-child(3) {
                    width: 150px;
                    text-align: center;
                }
                #cart table td:nth-child(4) {
                    width: 100px;
                    text-align: center;
                }
                #cart table td:nth-child(5) {
                    width: 150px;
                    text-align: center;
                }


                #cart table td:nth-child(6),
                #cart table td:nth-child(7),
                #cart table td:nth-child(1),
                #cart table td:nth-child(8),
                #cart table td:nth-child(9){
                    width: 100px;
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
                    margin-right: 5px;
                    font-weight: 20px;

                }
                tbody td button i.edit:hover {
                    color: green;
                }

                a{
                    color:black;
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
