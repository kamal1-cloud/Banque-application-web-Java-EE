package ma.youcode.BanqueWebApplication.Controller;

import ma.youcode.BanqueWebApplication.DAO.Entreprises.EntrepriseDAO;
import ma.youcode.BanqueWebApplication.DAO.Entreprises.EntrepriseDaoImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AjouterEntreprise", value = "/AjouterEntreprise")
public class AjouterEntreprise extends HttpServlet {
    RequestDispatcher dispatcher = null;
    EntrepriseDAO entrepriseDAO ;
    public AjouterEntreprise(){
        entrepriseDAO = new EntrepriseDaoImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String numero = request.getParameter("numero");
        Long solde = Long.parseLong(request.getParameter("solde"));
        Long idClient = Long.parseLong(request.getParameter("idClient"));


        try {
            entrepriseDAO.AjouterCompteEntreprise(nom,numero,solde, Math.toIntExact(idClient));
            request.setAttribute("message", "personne added successfuly");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("/Views/entreprises-form.jsp").forward(request, response);
    }
}
