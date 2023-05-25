<%-- 
    Document   : reports
    Created on : 17-May-2023, 11:42:08
    Author     : LENOVO
--%>

<%@page import="InterFaceModel.ICity"%>
<%@page import="InterFaceModel.IViolations"%>
<%@page import="an.ataali.dao.CityDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="an.ataali.connection.Dbcon"%>
<%@page import="an.ataali.dao.ViolationDao"%>
<%@page import="an.ataali.model.Violation"%>
<%@page import="an.ataali.model.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
Admin auth = (Admin)  request.getSession().getAttribute("auth");

IViolations doa = new ViolationDao(Dbcon.getConnection());
List <Violation> list_v = new ArrayList<>();
list_v = doa.getAllViolations();

ICity c_dao = new CityDao(Dbcon.getConnection());

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>violations</title>
          <%@include file="includes/head.jsp"%>
    </head>
    <body>
         <%@include file="includes/navbar.jsp"%>
      
        
         <div class="container">
		<div class="card-header my-3">All violations</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">city</th>
					<th scope="col">Category</th>
					<th scope="col">image</th>
					<th scope="col">confirm</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			
			<%
if (list_v != null) {
    for (Violation o : list_v) {
        if (o.isIs_hide()) {
            continue; // Skip this iteration if the violation is hidden
        }
%>
    <tr>
        <td><%= o.getDate() %></td>
        <td><%= c_dao.getNameCity(o.getCity_id()) %></td>
        <td><%= o.getViolation_type() %></td>
        <td>
            <img src="violationimages/<%= o.getImage() %>" style="width: 100px; height: auto;">
        </td>
        <td><a class="btn btn-sm btn-danger" href="Cancel-Report?action=con&id=<%= o.getId() %>&id_c=<%= o.getCity_id()%>">confirm</a></td>
        <td><a class="btn btn-sm btn-danger" href="Cancel-Report?action=can&id=<%= o.getId() %>&id_u=<%= o.getUser_id() %>">Cancel</a></td>
    </tr>
<%
    }
}
%>

			
			
			</tbody>
		</table>
	</div>
        
        
        
        
        
           <%@include file="includes/footer.jsp"%>
    </body>
</html>
