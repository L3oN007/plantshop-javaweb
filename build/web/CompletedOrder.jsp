<%-- Document : CartDetail Created on : 13-03-2023, 12:40:06 Author : L3oN --%> <%@page import="dao.OrderDAO"%> <%@page import="dto.Order"%> <%@page
import="java.util.ArrayList"%> <%@page import="dao.PlantDAO"%> <%@page import="dto.Plant"%> <%@page contentType="text/html" pageEncoding="UTF-8"%>
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
		<c:import url="header_user.jsp" />

		<section id="page-header">
			<h2>#Cart</h2>
			<p>Save more with coupons & up to 70% off</p>
		</section>
                
                <c:set value="${OrderDAO.getOrderByStatus(sessionScope.account.accID,2)}" var="check"/>
		<c:if test="${not empty check}">
			<section id="cart" class="section-p1">
				<table width="100%">
					<thead>
						<tr>
							<td>Order ID</td>
							<td>Order Date</td>
							<td>Ship Date</td>
							<td>Order's Status</td>
							<td>View</td>
							<td>Option</td>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${OrderDAO.getOrderByStatus(sessionScope.account.accID,2)}" var="o">
							<tr>
								<td>${o.orderID}</td>
								<td>${o.ordDate}</td>
								<td>${o.shipdate}</td>
								<c:if test="${o.status == 3}">
									<td><p class="status cancelled">Cancelled</p></td>
								</c:if>
								<c:if test="${o.status == 1}">
									<td><p class="status pending">Pending</p></td>
								</c:if>
								<c:if test="${o.status == 2}">
									<td><p class="status delivered">Delivered</p></td>
								</c:if>
								<td><a href="OrderDetail.jsp?orderID=${o.orderID}">Detail</a></td>
								<c:if test="${o.status == 1}">
									<td>
										<button type="submit" value="remove" name="action"><i class="fal fa-minus-circle"></i></button>
									</td>
								</c:if>
								<c:if test="${o.status == 3 || o.status == 2 }">
									<td>
										<button type="submit" value="remove" name="action"><i class="fas fa-redo-alt rebuy"></i></button>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</section>
		</c:if>
        <c:if test="${empty check}">
            <div style="text-align: center; padding: 80px">
                <img src="img/emptyList.png" alt="">
            </div>
        </c:if>
		<style>
			#cart table tbody tr td i.rebuy:hover {
				color: green;
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
