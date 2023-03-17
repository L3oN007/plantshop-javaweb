<%@page import="dto.Plant"%> <%@page contentType="text/html" pageEncoding="UTF-8"%> <%@taglib prefix="c"
                                                                                              uri="http://java.sun.com/jsp/jstl/core" %>
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

        <section id="prodetails" class="section-p1">
            <div class="single-pro-image">
                <img src="${plantdetail.imgpath}" width="100%" id="MainImg" alt="" />
            </div>
            <div class="single-pro-details">
                <c:if test="${not empty plantdetail}">
                    <h6>Category: ${plantdetail.catename}</h6>
                    <h4>${plantdetail.name}</h4>
                    <h2>$${plantdetail.price}</h2>
                    <!--<input type="number" value="1" min="1" max="10" />-->
                    <button
                        class="normal"
                        onclick="window.location.href = 'MainController?action=addtocart&amp;id=${plantdetail.id}'"
                        >
                        Add to Cart
                    </button>
                    <h4>Product Details</h4>
                    <p>${plantdetail.description}</p>
                </c:if>
            </div>
        </section>

        <c:import url="footer.jsp"/>


        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="script.js"></script>
    </body>
</html>
