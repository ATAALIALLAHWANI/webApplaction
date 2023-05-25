<%-- 
    Document   : navbar
    Created on : 10-May-2023, 13:49:56
    Author     : LENOVO
--%>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container">
                <a class="navbar-brand" href="index.jsp">E- tourist-guide </a>
                
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
          <a class="nav-link" href="index.jsp">Home</a>
      </li>
      
         <%
         if(auth != null){%>
           <li class="nav-item">
          <a class="nav-link disabled" href="reports.jsp">reports</a>
        </li>
       
       <li class="nav-item">
        <a class="nav-link" href="Log-Out-Servlet">Logout</a>
      </li>
           <%   }else{%>
             
           <li class="nav-item">
           <a class="nav-link" href="login.jsp">Login</a>
      </li>
     <li>
           <%   }

         %>
         
       
       
      
      
      
      
    </ul>
    
  </div>
  </div>
</nav>