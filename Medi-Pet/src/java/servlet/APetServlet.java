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

import dao.PetDAO;
import bean.Pet;

public class APetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/petA.jsp";
    private static String LIST_PET = "/listAPet.jsp";
    private PetDAO dao;

    public APetServlet() {
        super();
        dao = new PetDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int petId = Integer.parseInt(request.getParameter("petId"));
            dao.deletePet(petId);
            forward = LIST_PET;
            request.setAttribute("pets", dao.getAllPets());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int petId = Integer.parseInt(request.getParameter("petId"));
            Pet pet = dao.getPetById(petId);
            request.setAttribute("pet", pet);
        } else if( action.equalsIgnoreCase( "insert" ) ) {
            forward = INSERT_OR_EDIT;
	} else {
            forward = LIST_PET;
            request.setAttribute("pets", dao.getAllPets() );
	}
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pet pet = new Pet();
        pet.setName(request.getParameter("name"));
        pet.setDob(request.getParameter("dob"));
        pet.setSex(request.getParameter("sex"));
        pet.setBreed(request.getParameter("breed"));
        pet.setFullname(request.getParameter("fullname"));
        String petid = request.getParameter("petid");
        if(petid == null || petid.isEmpty())
        {
            dao.addPet(pet);
        }
        else
        {
            pet.setPetid(Integer.parseInt(petid));
            dao.checkPet(pet);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_PET);
        request.setAttribute("pets", dao.getAllPets());
        view.forward(request, response);
    }
}