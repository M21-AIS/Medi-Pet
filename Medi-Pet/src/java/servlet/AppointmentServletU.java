package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Appointment;
import bean.Appointment;
import dao.AppointmentDAO;
import dao.AppointmentDAO;
import util.DBUtil;
import javax.servlet.RequestDispatcher;


public class AppointmentServletU extends HttpServlet {
 private static final long serialVersionUID = 1L;
    private static String LIST_APP = "/listAppU.jsp";

    private AppointmentDAO dao;

    public AppointmentServletU() {
        super();
        dao = new AppointmentDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("listAppU"))
        {
            forward = LIST_APP;
            request.setAttribute("apps", dao.getAllApp());
        } else
        {
            forward = LIST_APP;
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
        app.setFullname(request.getParameter("fullname"));
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
