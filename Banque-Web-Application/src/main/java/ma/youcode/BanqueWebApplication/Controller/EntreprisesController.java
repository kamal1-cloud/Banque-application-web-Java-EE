package ma.youcode.BanqueWebApplication.Controller;

import ma.youcode.BanqueWebApplication.DAO.Entreprises.EntrepriseDAO;
import ma.youcode.BanqueWebApplication.DAO.Entreprises.EntrepriseDaoImp;
import ma.youcode.BanqueWebApplication.DAO.Personnes.PersonneDAO;
import ma.youcode.BanqueWebApplication.DAO.Personnes.PersonneDaoImp;
import ma.youcode.BanqueWebApplication.Modeles.Entreprises;
import ma.youcode.BanqueWebApplication.Modeles.Personnes;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "EntrepriseServlet", value = "/enterprise-servlet")
public class EntreprisesController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    RequestDispatcher dispatcher = null;
    EntrepriseDAO entrepriseDAO ;


    public EntreprisesController() {
        entrepriseDAO = new EntrepriseDaoImp();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String action = request.getParameter("action");

        if(action == null) {
            action = "LIST";
        }

        try {
            switch (action) {
                case "LIST":
                    listEntreprise(request, response);
                    break;
                case "DELETE":
                    deleteEntreprise(request, response);
                    break;
                case "EDIT":
                 //   getSinglePersonne(request, response);
                    break;
                case "/update":

                    break;
                default:
                    listEntreprise(request, response);
                    break;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }

    private void listEntreprise(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {

        ArrayList<Entreprises> theList = entrepriseDAO.getAll();

        request.setAttribute("list", theList);

        dispatcher = request.getRequestDispatcher("/Views/list-entreprise.jsp");

        dispatcher.forward(request, response);
    }
    private void deleteEntreprise(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {

        String id = request.getParameter("id");

        if(entrepriseDAO.deleteById(Integer.parseInt(id))) {
            request.setAttribute("NOTIFICATION", "Personne Deleted Successfully!");
        }

        listEntreprise(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

    }
}