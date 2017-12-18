/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ServiceDAO;
import bean.Service;

public class UServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/serviceU.jsp";
    private static String LIST_SERVICE = "/listServiceU.jsp";
    private ServiceDAO dao;

    public UServiceServlet() {
        super();
        dao = new ServiceDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int serviceNo = Integer.parseInt(request.getParameter("serviceNo"));
            dao.deleteService(serviceNo);
            forward = LIST_SERVICE;
            request.setAttribute("services", dao.getAllServices());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int serviceNo = Integer.parseInt(request.getParameter("serviceNo"));
            Service service = dao.getServiceById(serviceNo);
            request.setAttribute("service", service);
        } else if (action.equalsIgnoreCase("insert")){
            forward = INSERT_OR_EDIT;
        } else {
            forward = LIST_SERVICE;
            request.setAttribute("services", dao.getAllServices());
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = new Service();
        //service.setServiceNo(request.getParameter("serviceNo"));
        service.setServiceType(request.getParameter("serviceType"));
        service.setPetType(request.getParameter("petType"));
        service.setStatus(request.getParameter("status"));
        String serviceNo = request.getParameter("serviceNo");
        if(serviceNo == null || serviceNo.isEmpty())
        {
            dao.addService(service);
        }
        else
        {
            service.setServiceNo(Integer.parseInt(serviceNo));
            dao.checkService(service);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_SERVICE);
        request.setAttribute("services", dao.getAllServices());
        view.forward(request, response);
    }
}