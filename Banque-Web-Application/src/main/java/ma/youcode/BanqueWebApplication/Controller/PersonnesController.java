package ma.youcode.BanqueWebApplication.Controller;

import ma.youcode.BanqueWebApplication.DAO.Personnes.PersonneDAO;
import ma.youcode.BanqueWebApplication.DAO.Personnes.PersonneDaoImp;
import ma.youcode.BanqueWebApplication.Modeles.Personnes;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "PersonsServlet", value = "/persons-servlet")
public class PersonnesController extends HttpServlet {
    RequestDispatcher dispatcher = null;
    PersonneDAO personneDAO = null;
    public PersonnesController(){
        personneDAO = new PersonneDaoImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action == null) {
            action = "LIST";
        }

        try {
            switch (action) {
                case "LIST":
                    listPersonnes(request, response);
                    break;
                case "DELETE":
                    deletePersonne(request, response);
                    break;
                case "EDIT":
                    getSinglePersonne(request, response);
                    break;
                case "/update":

                    break;
                default:
                    listPersonnes(request, response);
                    break;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }


    }
    private void listPersonnes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {

        ArrayList<Personnes> theList2 = personneDAO.getAll();

        request.setAttribute("list2", theList2);

        dispatcher = request.getRequestDispatcher("/Views/list-personnes.jsp");

        dispatcher.forward(request, response);
    }
    private void getSinglePersonne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String idCompte = request.getParameter("id");

        Personnes thePersonne = personneDAO.get(Integer.parseInt(idCompte));

        request.setAttribute("pers", thePersonne);

        dispatcher = request.getRequestDispatcher("/Views/personnes-form.jsp");

        dispatcher.forward(request, response);
    }

    private void deletePersonne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {

        String id = request.getParameter("id");

        if(personneDAO.deleteById(Integer.parseInt(id))) {
            request.setAttribute("NOTIFICATION", "Personne Deleted Successfully!");
        }

        listPersonnes(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
}
