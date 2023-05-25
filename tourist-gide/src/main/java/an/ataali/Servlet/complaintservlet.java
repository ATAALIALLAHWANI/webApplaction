/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package an.ataali.Servlet;

import InterFaceModel.ICity;
import InterFaceModel.ITourist;
import InterFaceModel.IViolations;
import an.ataali.connection.Dbcon;
import an.ataali.dao.CityDao;
import an.ataali.dao.TouristDao;
import an.ataali.dao.ViolationDao;
import an.ataali.model.Tourist;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "complaintservlet", urlPatterns = {"/Complaint-Servlet"})
public class complaintservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet complaintservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet complaintservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
      processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        	response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
//        
//            Date date = new Date();
//           SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
           String date = request.getParameter("date");
           String name = request.getParameter("name");
           String phone = request.getParameter("phone");
           String city = request.getParameter("city");
           String type = request.getParameter("type");
           String image = request.getParameter("image");
           
           
           //
            
            Tourist T = new Tourist();
            ITourist daoT = new TouristDao(Dbcon.getConnection());
            boolean result = daoT.saveInfo(name, phone );
           
             T = daoT.findByPhone(phone);
           if(T.getCount() < 3){
                 ICity daoC  = new CityDao(Dbcon.getConnection());
                 int id_city = daoC.getId_city(city);
            //
               IViolations daoV =  new ViolationDao(Dbcon.getConnection());
           
          
             boolean result2=  daoV.saveViolation( date, type, image,T.getId(),id_city);
             
              response.sendRedirect("index.jsp");
           }else{
               
               out.println("you on the blacklist ");
           }
            
            
           
          
}       catch (Exception ex) {
            Logger.getLogger(complaintservlet.class.getName()).log(Level.SEVERE, null, ex);
}

           
         
//        processRequest(request, response);
    }
        
        
 

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
