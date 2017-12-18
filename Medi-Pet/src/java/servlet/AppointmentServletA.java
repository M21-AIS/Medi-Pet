/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Appointment;
import dao.AppointmentDAO;
import javax.servlet.RequestDispatcher;

public class AppointmentServletA extends HttpServlet {
 private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/appointmentA.jsp";
    private static String LIST_APP = "/listAppA.jsp";
    private AppointmentDAO dao;

    public AppointmentServletA() {
        super();
        dao = new AppointmentDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int appNo = Integer.parseInt(request.getParameter("appNo"));
            dao.deleteApp(appNo);
            forward = LIST_APP;
            request.setAttribute("apps", dao.getAllApp());    
        } else if(action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int appNo = Integer.parseInt(request.getParameter("appNo"));
            Appointment app = dao.getAppByAppNo(appNo);
            request.setAttribute("app", app);
        } else if (action.equalsIgnoreCase("insert")){
            forward = INSERT_OR_EDIT;     
        } else {
            forward = LIST_APP;
            request.setAttribute("apps", dao.getAllApp());
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Appointment app = new Appointment();
        app.setDate(request.getParameter("date"));
        app.setTime(request.getParameter("time"));
        app.setTypeVacc(request.getParameter("typeVacc"));
        app.setFullname(request.getParameter("fullname"));
        app.setName(request.getParameter("name"));
        String[] typeVacc = request.getParameterValues("typeVacc");
        String appNo = request.getParameter("appNo");
        if( appNo == null || appNo.isEmpty())
        {
            dao.addApp(app);
        }
        else
        {
            app.setAppNo(Integer.parseInt(appNo));
            dao.checkApp(app);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_APP);
        request.setAttribute("apps", dao.getAllApp());
        view.forward(request, response);
    }
}