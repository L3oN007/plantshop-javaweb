<%-- 
    Document   : EditPlant
    Created on : Mar 20, 2023, 11:51:37 AM
    Author     : L3oN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Workplace Complaint Form</title>
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
            integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
        <link rel="stylesheet" href="style.css" />
        <style>
            html,
            body {
                min-height: 100%;
            }
            body,
            div,
            form,
            input,
            select,
            p {
                padding: 0;
                margin: 0;
                outline: none;
                font-size: 14px;
                color: #666;
                line-height: 22px;
            }
            h1 {
                margin: 15px 0;
                font-weight: 600;
                font-size: 30px;
            }
            .testbox {
                height: inherit;
                padding: 3px;
                width: 50%;
            }
            #form-section {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin-top: 50px;
                margin-bottom: 120px;
            }
            form {
                width: 100%;
                padding: 20px;
                background: #fff;
                box-shadow: 0 2px 5px #ccc;
            }
            input,
            select,
            textarea {
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }
            input:hover,
            select:hover,
            textarea:hover {
                outline: none;
                border: 1px solid #095484;
            }
            input {
                width: calc(100% - 10px);
                padding: 5px;
            }
            select {
                width: 100%;
                padding: 7px 0;
                background: transparent;
            }
            textarea {
                width: calc(100% - 6px);
            }
            .item {
                position: relative;
                margin: 10px 0;
            }
            input[type='date']::-webkit-inner-spin-button {
                display: none;
            }
            .item i,
            input[type='date']::-webkit-calendar-picker-indicator {
                position: absolute;
                font-size: 20px;
                color: #a9a9a9;
            }
            .item i {
                right: 2%;
                top: 30px;
                z-index: 1;
            }
            [type='date']::-webkit-calendar-picker-indicator {
                right: 1%;
                z-index: 2;
                opacity: 0;
                cursor: pointer;
            }
            .btn-block {
                margin-top: 20px;
                text-align: center;
            }
            button {
                width: 150px;
                padding: 10px;
                border: none;
                -webkit-border-radius: 5px;
                -moz-border-radius: 5px;
                border-radius: 5px;
                background-color: #095484;
                font-size: 16px;
                color: #fff;
                cursor: pointer;
            }
            button:hover {
                background-color: #0666a3;
            }
            a.back {
                width: 150px;
                padding: 10px;
                border: none;
                -webkit-border-radius: 5px;
                -moz-border-radius: 5px;
                border-radius: 5px;
                background-color: #095484;
                font-size: 16px;
                color: #fff;
                cursor: pointer;
                text-decoration: none;
                background-color: red;
            }
            a.back:hover {
                background-color: rgba(255, 0, 0, 0.758);
            }
            input[readonly]{
                background-color: #e9ecef;
                color: #585f61;
            }
            
            span{
                color: red;
            }
        </style>
    </head>
    <body>
        <c:choose>
            <c:when test="${sessionScope.admin == null}">                   
                <jsp:forward page="login.jsp"/>
            </c:when>
            <c:otherwise>               
                <section id="form-section">
                    <div class="testbox">
                        <form action="EditPlantServlet">
                            <h1>Manage Plants Section</h1>
                            <div class="item">
                                <p>Plant ID</p>
                                <input type="number" name="PID" placeholder="PID" value="${param.PID}" readonly/>
                            </div>
                            <div class="item">
                                <p>Plant Name</p>
                                <input type="text" name="PName" placeholder="Plant Name" />
                            </div>
                            <div class="item">
                                <p>Price</p>
                                <input type="number" name="price" placeholder="Price" />
                            </div>
                            <div class="item">
                                <p>Cate ID</p>
                                <select name="CateID">
                                    <option value="">Please select Cate ID</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="3">4</option>
                                   
                                </select>
                            </div>                           
                            <!-- <div class="item">
                                    <p>Date of complaint</p>
                                    <input type="date" name="name" required />
                                    <i class="fas fa-calendar-alt"></i>
                            </div> -->
                            <div class="item">
                                <p>Imgpath</p>
                                <select name="Imgpath">
                                    <option value="">Please select Imgpath</option>
                                    <option value="img/products/p1.jpg">p1</option>
                                    <option value="img/products/p2.jpg">p2</option>
                                    <option value="img/products/p3.jpg">p3</option>
                                    <option value="img/products/p4.jpg">p4</option>
                                    <option value="img/products/p5.jpg">p5</option>
                                    <option value="img/products/p6.jpg">p6</option>
                                    <option value="img/products/p7.jpg">p7</option>
                                    <option value="img/products/p8.jpg">p8</option>
                                    <option value="img/products/p9.jpg">p9</option>
                                    <option value="img/products/p1.jpg0">p10</option>
                                </select>
                            </div>
                            <div class="item">
                                <p>Description</p>
                                <textarea rows="5" name="description"></textarea>
                            </div>
                            <span>${requestScope.update}</span>
                            <div class="btn-block">
                                <a href="ManagePlant.jsp" class="back">Back</a>
                                <button type="submit" href="/">Update</button>
                            </div>
                        </form>
                    </div>
                </section>

                <c:import url="footer.jsp" />
            </c:otherwise>
        </c:choose>

    </body>
</html>

