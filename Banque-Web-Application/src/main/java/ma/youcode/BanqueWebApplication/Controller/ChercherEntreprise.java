package ma.youcode.BanqueWebApplication.Controller;

import ma.youcode.BanqueWebApplication.DAO.Entreprises.EntrepriseDAO;
import ma.youcode.BanqueWebApplication.DAO.Entreprises.EntrepriseDaoImp;
import ma.youcode.BanqueWebApplication.DAO.Personnes.PersonneDAO;
import ma.youcode.BanqueWebApplication.DAO.Personnes.PersonneDaoImp;
import ma.youcode.BanqueWebApplication.Modeles.Personnes;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ChercherEntreprise", value = "/ChercherEntreprise")
public class ChercherEntreprise extends HttpServlet {
    RequestDispatcher dispatcher = null;
    EntrepriseDAO entrepriseDAO ;
    PersonneDAO personneDAO = null;
    public ChercherEntreprise(){
        entrepriseDAO = new EntrepriseDaoImp();
        personneDAO = new PersonneDaoImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("word");
        try {
            List<Personnes> personnes = personneDAO.Searsh(query);
            request.setAttribute("personnes", personnes);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Views/list-personnes.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
