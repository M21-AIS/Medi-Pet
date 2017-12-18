package servlet;

import java.io.*;

import java.sql.*;

import javax.servlet.ServletException;

import javax.servlet.http.*;
import util.DBUtil;

public class AppointmentServletU extends HttpServlet {

       public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

              response.setContentType("text/html");
              PrintWriter out = response.getWriter();        
              String name=request.getParameter("fullname");                          

              try{

                     Connection con=DBUtil.getConnection();               

                     PreparedStatement ps=con.prepareStatement("select * from appointment where fullname=?");

                     ps.setString(1,name);                   

                     out.print("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "<title>View Pet</title>\n" +
                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                    "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                    "<meta name=\"keywords\" content=\"Best Pets Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, \n" +
                    "	SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design\" />\n" +
                    "<script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\n" +
                    "<!-- Custom Theme files -->\n" +
                    "<link href=\"css/bootstrap.css\" type=\"text/css\" rel=\"stylesheet\" media=\"all\">\n" +
                    "<link href=\"css/style.css\" type=\"text/css\" rel=\"stylesheet\" media=\"all\">   \n" +
                    "<link href=\"css/font-awesome.css\" rel=\"stylesheet\"> <!-- font-awesome icons -->\n" +
                    "<link rel=\"stylesheet\" href=\"css/flexslider.css\" type=\"text/css\" media=\"screen\" property=\"\" />\n" +
                    "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
                    "<!-- //Custom Theme files -->  \n" +
                    "<!-- web-fonts -->   \n" +
                    "<link href=\"//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i\" rel=\"stylesheet\">\n" +
                    "<link href=\"//fonts.googleapis.com/css?family=Dosis:200,300,400,500,600,700,800\" rel=\"stylesheet\">\n" +
                    "<!-- //web-fonts -->\n" +
                    "<style>\n" +
                    ".button {\n" +
                    "    background-color: #FF7F50;\n" +
                    "    border: none;\n" +
                    "    color: white;\n" +
                    "    padding: 16px 32px;\n" +
                    "    text-align: center;\n" +
                    "    text-decoration: none;\n" +
                    "    display: inline-block;\n" +
                    "    font-size: 16px;\n" +
                    "    margin: 4px 2px;\n" +
                    "    -webkit-transition-duration: 0.4s; /* Safari */\n" +
                    "    transition-duration: 0.4s;\n" +
                    "    cursor: pointer;\n" +
                    "    border-radius: 12px;\n" +
                    "    background-color: white; \n" +
                    "    color: black; \n" +
                    "    border: 2px solid #FF7F50;\n" +
                    "}\n" +
                    "\n" +
                    ".button:hover {\n" +
                    "    background-color: #FF7F50;\n" +
                    "    color: white;\n" +
                    "}\n" +
                    "\n" +
                    ".control-label{\n" +
                    "    font-size: 20px;\n" +
                    "    color : white;\n" +
                    "}\n" +
                    "\n" +
                    "h1 {\n" +
                    "    color: white;\n" +
                    "}\n" +
                    "\n" +
                    "</style>\n" +
                    "</head>\n" +
                    "<body> \n" +
                    "	<!-- banner -->\n" +
                    "	<div class=\"w3ls-banner jarallax\">\n" +
                    "		<div class=\"w3lsbanner-info\">\n" +
                    "			<!-- header -->\n" +
                    "			<div class=\"header\">\n" +
                    "				<div class=\"container\">   \n" +
                    "					<div class=\"agile_header_grid\"> \n" +
                    "						<div class=\"header-mdl agileits-logo\"><!-- header-two --> \n" +
                    "							<h1><a href=\"index.jsp\">Medi Pet</a></h1> \n" +
                    "						</div>\n" +
                    "						<div class=\"agileits_w3layouts_sign_in\">\n" +
                    "							<ul>\n" +
                    "                                                            <li>Welcome</li>\n" +
                    "                                                            <li>|</li>\n" +
                    "                                                            <li><a href=\"<%=request.getContextPath()%>/LogoutServlet\" data-toggle=\"modal\" class=\"play-icon\">Logout</a></li>\n" +
                    "                                                            <li>Call us : <span>(+07) 553 0070</span></li>\n" +
                    "							</ul>\n" +
                    "						</div>\n" +
                    "						<div class=\"clearfix\"> </div>\n" +
                    "					</div> \n" +
                    "					<div class=\"header-nav\"><!-- header-three --> 	\n" +
                    "						<nav class=\"navbar navbar-default\">\n" +
                    "							<div class=\"navbar-header\">\n" +
                    "								<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\n" +
                    "									<span class=\"sr-only\">Toggle navigation</span>\n" +
                    "									<span class=\"icon-bar\"></span>\n" +
                    "									<span class=\"icon-bar\"></span>\n" +
                    "									<span class=\"icon-bar\"></span>\n" +
                    "								</button> \n" +
                    "							</div>\n" +
                    "							<!-- top-nav -->\n" +
                    "							<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n" +
                    "								<ul class=\"nav navbar-nav cl-effect-16\">\n" +
                    "									<li><a href=\"index.jsp\" class=\"active\" data-hover=\"Home\">Home</a></li>\n" +
                    "									<li><a href=\"about.html\" data-hover=\"About\">About</a></li> \n" +
                    "									<li><a href=\"gallery.html\" data-hover=\"Gallery\">Gallery</a></li>\n" +
                    "									<li><a href=\"contact.jsp\" data-hover=\"Contact\">Contact</a></li>\n" +
                    "								</ul>  \n" +
                    "								<div class=\"clearfix\"> </div>	\n" +
                    "							</div>\n" +
                    "						</nav>    \n" +
                    "					</div>	\n" +
                    "				</div>	\n" +
                    "			</div>	\n" +
                    "			<!-- //header --> \n" +
                    "			<!-- banner-text -->\n" +
                    "			<div class=\"banner-text agileinfo\"> \n" +
                    "                                <center>\n" +
                    "                                <div class=\"w3-container w3-centered\">");
                     out.print("<table class=\"w3-table w3-bordered\">");

                     out.print("<center><h1>Appointment Detail:</h1></center><br>");

                     ResultSet rs=ps.executeQuery();                

                     /* Printing column names */

                     ResultSetMetaData rsmd=rs.getMetaData();

                     while(rs.next())

                        {

                     out.print("<td class=\"w3-red\">"+rsmd.getColumnName(1)+"</td>");

                        out.print("<td class=\"w3-white\">"+rs.getString(1)+"</td></tr>");

                        out.print("<tr><td class=\"w3-red\">"+rsmd.getColumnName(2)+"</td>");

                        out.print("<td class=\"w3-white\">"+rs.getString(2)+"</td></tr>");

                        out.print("<tr><td class=\"w3-red\">"+rsmd.getColumnName(3)+"</td>");

                        out.print("<td class=\"w3-white\">"+rs.getString(3)+"</td></tr>");

                        out.print("<tr><td class=\"w3-red\">"+rsmd.getColumnName(4)+"</td>");

                        out.print("<td class=\"w3-white\">"+rs.getString(4)+"</td></tr>");   
                        
                        out.print("<tr><td class=\"w3-red\">"+rsmd.getColumnName(5)+"</td>");

                        out.print("<td class=\"w3-white\">"+rs.getString(5)+"</td></tr>");   
                        
                        out.print("<tr><td class=\"w3-red\">"+rsmd.getColumnName(6)+"</td>");

                        out.print("<td class=\"w3-white\">"+rs.getString(6)+"</td></tr>");   
                        
                     }

                     out.print("</table>");

 

              }catch (Exception e2)

                {

                    e2.printStackTrace();

                }

 

              finally{out.close();

                }

       }

 

} 