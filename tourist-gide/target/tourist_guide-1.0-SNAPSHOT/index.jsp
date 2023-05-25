<%-- 
    Document   : index
    Created on : 14-May-2023, 12:12:09
    Author     : LENOVO
--%>


<%@page import="InterFaceModel.IViolations"%>
<%@page import="InterFaceModel.ICity"%>
<%@page import="an.ataali.dao.ViolationDao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="an.ataali.model.City"%>
<%@page import="an.ataali.connection.Dbcon"%>
<%@page import="an.ataali.dao.CityDao"%>
<%@page import="an.ataali.model.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
Admin auth = (Admin) request.getSession().getAttribute("auth");
if(auth != null){
request.setAttribute("auth", auth);
    } 
  ICity cd = new CityDao(Dbcon.getConnection());
  List <City> cities = cd.getAllcities();
  IViolations v = new ViolationDao(Dbcon.getConnection());
  v.isExpired();

    %>
<!DOCTYPE html>
<html>
    <head>
          
         <title> hello Jordan </title>
        <%@include file="includes/head.jsp"%>
        
         
    </head>
    <body>
         
      <%@include file="includes/navbar.jsp"%>   
         
         <div class="container" >
            <div class="card-header my-3"> all cities </div>
            <div class="row">
                <% 
                
                   if(!cities.isEmpty()){
                   for(City p:cities){%>
                    <div class="col-md-3 my-3">
                                        <div class="card w-100" style="width: 18rem;">
                                            <img class="card-img-top" src="City-images/<%=p.getImage()%>" alt="Card image cap">
                      <div class="card-body">
                 
                          <h5 class="card-title"> <%=p.getName() %> </h5>
                         
                          <h6 class="category"> <%=p.getStatus()%>  </h6>
                           
                            
                          <div class="mt-3 d-flex justify-content-between">
                             
                              <button type="button" class="btn btn-outline-info"> <%= p.getRate() %> </button>
                             <a href= "complaint.jsp" class="btn btn-primary"> Make a complaint </a>
                          </div>
                       
                      </div>
                    </div>
                </div>
                  <%  }
                    }   else {
			out.println("There is no proucts");
			}           

                %>
              
            </div>
        </div>
        
         
         
            
 <%@include file="includes/footer.jsp"%>
    </body>
</html>
