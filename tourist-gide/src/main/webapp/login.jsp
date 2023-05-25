<%-- 
    Document   : login
    Created on : 15-May-2023, 12:46:09
    Author     : LENOVO
--%>

<%@page import="an.ataali.model.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 

Admin auth = (Admin)  request.getSession().getAttribute("auth");
if(auth != null){
response.sendRedirect("index.jsp");
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>  Tourist Guide </title>
          <%@include file="includes/head.jsp"%>
    </head>
    <body>
         <%@include file="includes/navbar.jsp"%>
       
         <div class ="container">
            <div class ="card w-50 mx-auto my-5">
                <div class="card-header text-center">Admin Login</div>
                <div class="card-body">
                    <form action="Login-Servlet" method="post">
                        <div class="from-group"> 
                            <label>Email Address</label>
                            <input type="email" class="form-control" name="login-email" placeholder="Enter your email" required>
                        </div>
                         <div class="from-group"> 
                            <label>Password Address</label>
                            <input type="password" class="form-control" name="login-password" placeholder="*******" required>
                        </div>
                        <div class="text-center"> 
        
                          <button type="submit" class="btn btn-primary">Login</button>
                        </div>
                    </form>
                </div>  
            </div>
        </div>
        
        
          <%@include file="includes/footer.jsp"%>
    </body>
</html>
