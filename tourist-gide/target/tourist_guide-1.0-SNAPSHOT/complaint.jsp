<%-- 
    Document   : complaint
    Created on : 15-May-2023, 19:46:20
    Author     : LENOVO
--%>

<%@page import="InterFaceModel.ICity"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="an.ataali.dao.CityDao"%>
<%@page import="an.ataali.model.City"%>
<%@page import="an.ataali.connection.Dbcon"%>
<%@page import="an.ataali.model.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<% 
Admin auth = (Admin) request.getSession().getAttribute("auth");
if(auth != null){
request.setAttribute("auth", auth);
    } 
  ICity cd = new CityDao(Dbcon.getConnection());
  List <City> cities = cd.getAllcities();
  Date date = new Date();
   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    %>
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>complaint</title>
        <%@include file="includes/head.jsp"%>
    </head>
    <body>
          <%@include file="includes/navbar.jsp"%>
       <div class ="container">
            <div class ="card w-50 mx-auto my-5">
                <div class="card-header text-center"> Make a complaint </div>
                <div class="card-body">
                    <form action="Complaint-Servlet" method="post">
                        <div class="from-group"> 
                            <label>Date:</label>
                            <input type="text" class="form-control"  name="date" value="<%= formatter.format(date) %>">
                        </div>
                        <div class="from-group"> 
                            
                          <label for="phone"> your name </label>
			<input type="text" class="form-control" name="name" required>  
                          </div> 
                        
                      
                        <div class="from-group"> 
                        <label for="phone"> Phone Number </label>
			<input type="text"  name="phone" class="form-control" required></div>
                        
                         <div class="from-group"> 
                            <label>Country:</label>
                            <input type="text" class="form-control" name="Country:"  value="Jordan">
                            
                        </div>
                        <div class="from-group"> 
                            <label for="city">City:</label>
                            <select  name="city" required>
                                <% 
                                if(cities != null){
                                for(City p :cities){ %>
                                 <option value="<%=p.getName() %>"> <%=p.getName() %></option>
                                  <%  } 
                                    }  
                                %>
                               
                                
                            </select>
                                
                                <div class="from-group"> 
                          <label for="violation">Select the type of violation:</label>
			<select id="violation" name="type" required>
				<option value="" selected disabled>Select Violation</option>
				<option value="Red light crossing">Red light crossing</option>
				<option value="Running a stop sign">Running a stop sign</option>
				<option value="Jaywalking">Jaywalking</option>
				<option value="Littering">Littering</option>
			</select>
                            
                        </div>
                                
                         <div class="from-group"> 
                            <label for="image">Upload Image/Video (max 20MB):</label>
                          <input type="file" name="image" accept="image/*, video/*" required>
                            
                        </div>
                                
                        </div>
                        <div class="text-center"> 
        
                          <button type="submit" class="btn btn-primary">Done</button>
                        </div>
                    </form>
                </div>  
            </div>
        </div>
        
         <%@include file="includes/footer.jsp"%>
    </body>
</html>
