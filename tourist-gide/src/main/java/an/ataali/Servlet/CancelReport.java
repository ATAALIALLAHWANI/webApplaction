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
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "cancelreport", urlPatterns = {"/Cancel-Report"})
public class CancelReport extends HttpServlet {

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
            out.println("<title>Servlet CancelReport</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CancelReport at " + request.getContextPath() + "</h1>");
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
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
             String action = request.getParameter("action");
             String id = request.getParameter("id");
             
                ITourist  daoT = new TouristDao(Dbcon.getConnection());
              ICity  DaoC = new CityDao(Dbcon.getConnection());
              IViolations daoV =  new ViolationDao(Dbcon.getConnection());
            
             
              if(action.equals("con") ){
                  String id_c = request.getParameter("id_c");
                  
                 if(Integer.parseInt(id) != 0){
                       
                       String status = daoV.checkCityStatus(Integer.parseInt(id_c));
                       DaoC.updateCityRate(Integer.parseInt(id_c));
                       DaoC.updateCityStatus(Integer.parseInt(id_c), status);
                       daoV.confirmReport(Integer.parseInt(id));
                       response.sendRedirect("reports.jsp");
                 }else{
                     out.println("id == 0 ");
                 }
                
             } 
             else if(action.equals("can")){
                 String id_u = request.getParameter("id_u");
                  if(Integer.parseInt(id) != 0){
                      daoT.IncreaseCount(Integer.parseInt(id_u));
                      daoV.cencelReport(Integer.parseInt(id));
                      response.sendRedirect("reports.jsp");
                  }else{
                     out.println("id == 0 ");
                 }
                 

             }
             else{
                 out.println("this is not true " + action);
             }
             
             
             }   catch (Exception ex) {
            Logger.getLogger(CancelReport.class.getName()).log(Level.SEVERE, null, ex);
             }
        
        
        //
    }
            
            
//           
//             if(action.endsWith("can")){
//                  if(id !=null){
//               
//                daoT.IncreaseCount(Integer.parseInt(id_u));
//               
//                  daoV.cencelReport(Integer.parseInt(id));
//
//               
//            }
//             }
//                if(action.equals("con")){
//                      if(id !=null){
//                          
//                         daoV.confirmReport(Integer.parseInt(id));
//                      }
//                }
//             
//                
//                
//            response.sendRedirect("reports.jsp");
//            
//        }catch (SQLException ex) {
//            Logger.getLogger(CancelReport.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(CancelReport.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//        
//        
//        processRequest(request, response);
   

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
        processRequest(request, response);
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
