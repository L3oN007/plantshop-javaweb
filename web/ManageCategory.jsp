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
                            <input type="text" id="search-bar" placeholder="Enter category name" name="txtsearch" value="${param.txtsearch}" />
                            <input type="submit" value="searchcategory" name="action" style="display: none">
                            <c:if test="${requestScope.flag != null}">
                                <p>Not found what you looking for!</p>
                            </c:if>
                        </form>
                    </section>

                    <section id="cart" class="section-p1">                                     
                        <table width="100%">
                            <thead>
                                <tr>
                                    <td>Cate ID</td>
                                    <td>Cate Name</td>
                                    <td>Option</td>
                                </tr>
                            </thead>

                            <tbody>                                              
                                <c:forEach items="${empty requestScope.listCate ? PlantDAO.getAllCategory() : requestScope.listCate}" var="p">
                                <form action="MainController" method="post">
                                    <tr>
                                        <td>${p.cateid}</td>
                                        <td><input type="text" value="${p.catename}" name="CateName" /></td>
                                        <td>
                                            <input type="hidden" name="CateID" value="${p.cateid}">                                           
                                            <button type="submit" value="updatecategory" name="action">Update</button>                                            
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
                input
                {
                    margin-bottom: 10px;
                    border: 1px solid #ccc;
                    border-radius: 3px;
                }
                input:hover
                {
                    outline: none;
                    border: 1px solid #095484;
                }
                input {

                    padding: 5px;
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

                #cart table td:nth-child(1) {
                    width: 250px;
                    text-align: center;
                }

                #cart table td:nth-child(2) {
                    width: 250px;
                    text-align: center;
                }
                #cart table td:nth-child(3) {
                    width: 250px;
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
                    width: 150px;
                    padding: 10px;
                    border: none;
                    -webkit-border-radius: 5px;
                    -moz-border-radius: 5px;
                    border-radius: 5px;
                    background-color: #088178;
                    font-size: 16px;
                    color: #fff;
                    cursor: pointer;

                }

                tbody td button:hover {
                    background-color: #088179c7;

                }

                tbody td button i.edit:hover {
                    color: green;
                }

                a{
                    color:black;
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
