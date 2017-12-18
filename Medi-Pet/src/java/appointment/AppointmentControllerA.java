/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appointment.Appointment;
import appointment.AppointmentDAO;
import util.DBUtil;
import javax.servlet.RequestDispatcher;

public class AppointmentControllerA extends HttpServlet {
 private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/appointmentA.jsp";
    private static String LIST_APP = "/listAppA.jsp";
    private AppointmentDAO dao;

    public AppointmentControllerA() {
        super();
        dao = new AppointmentDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            String appNo = request.getParameter("appNo");
            dao.deleteApp(appNo);
            forward = LIST_APP;
            request.setAttribute("apps", dao.getAllApp());    
        } else if(action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            String appNo = request.getParameter("appNo");
            Appointment app = dao.getAppByAppNo(appNo);
            request.setAttribute("app", app);
        } else if (action.equalsIgnoreCase("listAppA")){
            forward = LIST_APP;
            request.setAttribute("apps", dao.getAllApp());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Appointment app = new Appointment();
        app.setAppNo(request.getParameter("appNo"));
        app.setDate(request.getParameter("date"));
        app.setTime(request.getParameter("time"));
        app.setTypeVacc(request.getParameter("typeVacc"));
        app.setUsername(request.getParameter("username"));
        app.setName(request.getParameter("name"));
        
        String appNo = request.getParameter("appNo");
        if(appNo == null || appNo.isEmpty())
        {
            dao.addApp(app);
        }
        else
        {
            app.setAppNo(request.getParameter(appNo));
            dao.checkApp(app);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_APP);
        request.setAttribute("apps", dao.getAllApp());
        view.forward(request, response);
    }
}