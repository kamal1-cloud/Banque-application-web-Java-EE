package ma.youcode.BanqueWebApplication.DAO.Entreprises;

import ma.youcode.BanqueWebApplication.Modeles.Entreprises;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EntrepriseDAO {
    public ArrayList<Entreprises> getAll() throws ClassNotFoundException, SQLException;
    public Long AjouterCompteEntreprise(String nom, String numero, Long solde, int idClient) throws ClassNotFoundException, SQLException;
    public boolean deleteById(int id) throws ClassNotFoundException, SQLException;
    public Long updateCompte(Long idCompte, String nom, String numero, Long solde, Long idClient) throws ClassNotFoundException, SQLException;

}
