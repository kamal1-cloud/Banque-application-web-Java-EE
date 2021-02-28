package ma.youcode.BanqueWebApplication.DAO.Comptes;

import ma.youcode.BanqueWebApplication.Connectivity.DbConnection;
import ma.youcode.BanqueWebApplication.Modeles.Comptes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompteDaoImp implements CompteDAO{
    public ArrayList<Comptes> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<Comptes> comptes = new ArrayList<>();

        Connection conn = DbConnection.getConnection();

        String requete = "SELECT c.*, l.* FROM Compte c , Clients l WHERE l.idCient = c.idClient";
        PreparedStatement statement = conn.prepareStatement(requete);
        ResultSet resultat = statement.executeQuery();
        while (resultat.next()) {
            Long idClient = resultat.getLong("idClient");
            String client = resultat.getString("client");
            Long idCompte = resultat.getLong("idCompte");
            String nom = resultat.getString("nom");
            String numero = resultat.getString("numero");
            Long solde = resultat.getLong("solde");
            Comptes compte = new Comptes(idClient, client,idCompte,nom,numero, solde);
            comptes.add(compte);
            System.out.println(idCompte+" "+nom+" "+numero+" "+solde);
        }

        return comptes;
    }
}
