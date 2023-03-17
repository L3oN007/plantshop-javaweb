<%-- 
    Document   : AccountSetting
    Created on : 13-03-2023, 17:56:58
    Author     : L3oN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <title>Account Settings UI Design</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport" />
        <link
            rel="stylesheet"
            type="text/css"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
        <c:import url="header_user.jsp"/>
        <section class="py-5 my-5">
            <div class="container">
                <h1 class="mb-5">Account Settings</h1>
                <div class="bg-white shadow rounded-lg d-block d-sm-flex">
                    <div class="profile-tab-nav border-right">
                        <div class="p-4">
                            <div class="img-circle text-center mb-3">
                                <img src="img/account/ok.jpg" alt="Image" class="shadow" />
                            </div>
                            <h4 class="text-center">${sessionScope.account.fullname}</h4>
                        </div>
                        <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                            <a
                                class="nav-link active"
                                id="account-tab"
                                data-toggle="pill"
                                href="#account"
                                role="tab"
                                aria-controls="account"
                                aria-selected="true"
                                >
                                <i class="fa fa-home text-center mr-1"></i>
                                Account
                            </a>
                            <a
                                class="nav-link"
                                id="password-tab"
                                data-toggle="pill"
                                href="#password"
                                role="tab"
                                aria-controls="password"
                                aria-selected="false"
                                >
                                <i class="fa fa-key text-center mr-1"></i>
                                Password
                            </a>
                        </div>
                    </div>
                    <div class="tab-content p-4 p-md-5" id="v-pills-tabContent">
                        <div class="tab-pane fade show active" id="account" role="tabpanel" aria-labelledby="account-tab">
                            <h3 class="mb-4">Account Settings</h3>
                            <form action="ManageAccountServlet" method="post">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Email</label>
                                            <input name="email" type="text" class="form-control" value="${sessionScope.account.email}" / readonly>                                            
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Full Name</label>
                                            <input name="newFullname" type="text" class="form-control" value="${sessionScope.account.fullname}" />
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Phone number</label>
                                            <input name="newPhone" type="text" class="form-control" value="${sessionScope.account.phone}" />
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Password</label>
                                            <input name="currentPassword" type="text" class="form-control" />
                                            <c:if test = "${not empty requestScope.errorMessage}">
                                                <label style="color: red">${requestScope.errorMessage}</label>                                                
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <button class="btn btn-primary" type="submit" style="color: white; background-color: #007bff">Update</button>
                                </div>
                            </form>
                        </div>
                        <div class="tab-pane fade" id="password" role="tabpanel" aria-labelledby="password-tab">
                            <h3 class="mb-4">Password Settings</h3>
                            <form action="ManageAccountServlet" method="post">
                                <div class="row">
                                    <div class="col-md-6" style="display: none;">
                                        <div class="form-group">
                                            <label>Email</label>
                                            <input name="email" type="text" class="form-control" value="${sessionScope.account.email}" / readonly>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Old password</label>
                                            <input name="currentPassword" type="password" class="form-control" />
                                            <c:if test = "${not empty requestScope.errorMessage}">
                                                <label style="color: red">${requestScope.errorMessage}</label>                                                
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>New password</label>
                                            <input name="newPassword" type="password" class="form-control" />
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Confirm new password</label>
                                            <input name="confirmPassword" type="password" class="form-control" />
                                            <c:if test = "${not empty requestScope.errorConfirmMessage}">
                                                <label style="color: red">${requestScope.errorConfirmMessage}</label>                                                
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <button class="btn btn-primary" type="submit" style="color: white; background-color: #007bff">Update</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <c:import url="footer.jsp"/>
        <style>
            @import url('https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap');
            body {
                background: #f9f9f9;
                font-family: 'Roboto', sans-serif;
            }

            .shadow {
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1) !important;
            }

            .profile-tab-nav {
                min-width: 250px;
            }

            .tab-content {
                flex: 1;
            }

            .form-group {
                margin-bottom: 1.5rem;
            }

            .nav-pills a.nav-link {
                padding: 15px 20px;
                border-bottom: 1px solid #ddd;
                border-radius: 0;
                color: #333;
            }
            .nav-pills a.nav-link i {
                width: 20px;
            }

            .img-circle img {
                height: 100px;
                width: 100px;
                border-radius: 100%;
                border: 5px solid #fff;
            }
        </style>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="script.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>

