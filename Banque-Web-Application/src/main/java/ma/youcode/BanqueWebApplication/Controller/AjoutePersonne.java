package ma.youcode.BanqueWebApplication.Controller;

import ma.youcode.BanqueWebApplication.DAO.Personnes.PersonneDAO;
import ma.youcode.BanqueWebApplication.DAO.Personnes.PersonneDaoImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AjoutePersonne", value = "/AjoutePersonne")
public class AjoutePersonne extends HttpServlet {
    RequestDispatcher dispatcher = null;
    PersonneDAO personneDAO = null;
    public AjoutePersonne(){
        personneDAO = new PersonneDaoImp();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
