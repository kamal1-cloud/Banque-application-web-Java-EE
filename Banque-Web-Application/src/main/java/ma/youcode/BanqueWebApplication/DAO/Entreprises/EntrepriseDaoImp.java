package ma.youcode.BanqueWebApplication.DAO.Entreprises;

import ma.youcode.BanqueWebApplication.Connectivity.DbConnection;
import ma.youcode.BanqueWebApplication.Modeles.Entreprises;

import java.sql.*;
import java.util.ArrayList;

public class EntrepriseDaoImp implements EntrepriseDAO{
    Statement statement = null;
    PreparedStatement stmt = null;
    ResultSet rst = null;
    Connection conn;
    public ArrayList<Entreprises> getAll() throws ClassNotFoundException, SQLException {

        ArrayList<Entreprises> entreprises = new ArrayList<>();

        Connection conn = DbConnection.getConnection();

        String requete = "SELECT c.*, e.*, l.* FROM Compte c , Entreprises e , Clients l WHERE l.idClient = c.idClient and c.idCompte = e.idCompte";
        PreparedStatement statement = conn.prepareStatement(requete);
        ResultSet resultat = statement.executeQuery();
        while (resultat.next()) {
            Long idClient = resultat.getLong("idClient");
            String client = resultat.getString("client");
            Long idCompte = resultat.getLong("idCompte");
            String nom = resultat.getString("nom");
            String numero = resultat.getString("numero");
            Long solde = resultat.getLong("solde");
            Long idEntreprise = resultat.getLong("idEntreprise");
            Entreprises e = new Entreprises(idClient,client,idCompte,nom,numero, solde,idEntreprise);
            entreprises.add(e);
            System.out.println(idClient+" "+ nom +" "+ solde);
        }

        return entreprises;
    }

    //::::::::: Ajouter Un compte d'entreprise

    public Long AjouterCompteEntreprise(String nom, String numero, Long solde, int idClient) throws ClassNotFoundException, SQLException {

        Connection conn = DbConnection.getConnection();

        String requete = "INSERT INTO Compte (nom,numero,solde,idClient) values (?,?,?,?)";
        stmt = conn.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, nom);
        stmt.setString(2, numero);
        stmt.setLong(3, solde);
        stmt.setInt(4, idClient);

        Long idCompte = 0L;
        boolean isInserted = false;
        int affectedRow = stmt.executeUpdate();
        if (affectedRow == 0) {
            throw new SQLException("inserting failed");
        }
        System.out.println("affected row " + affectedRow);
        rst = stmt.getGeneratedKeys();
        while (rst.next()) {
            System.out.println("has next");
            idCompte = rst.getLong(1);
            isInserted = insertIntoEntreprise(conn, idCompte);
        }
        if (isInserted) return idCompte;
        else throw new SQLException("Entreprise account does not inseted");

    }

    private boolean insertIntoEntreprise(Connection conn, Long idCompte) throws SQLException{
        String requete;
        requete = "INSERT INTO Entreprises(idCompte) values(?)";

        stmt = conn.prepareStatement(requete);
        stmt.setLong(1, idCompte);
        int affectedRows = stmt.executeUpdate();

        if (affectedRows == 0) {
            return false;
        }
        return true;
    }
    //::::::::: Update data
    @Override
    public Long updateCompte(Long idCompte, String nom, String numero, Long solde, Long idClient) throws ClassNotFoundException, SQLException {
        Connection conn = null;

        String query = "Update Compte set nom = ?, numero = ?, solde = ?, idClient = ? FROM Compte c JOIN Entreprises e ON c.idCompte = e.idCompte  where c.idCompte = ?";
       // String query = "Update Compte set nom = ?, numero = ?, solde = ?, idClient = ? where idCompte = ?";
        stmt = DbConnection.getConnection().prepareStatement(query);

        stmt.setString(1, nom);
        stmt.setString(2, numero);
        stmt.setLong(3, solde);
        stmt.setLong(4, idClient);
        stmt.setLong(5, idCompte);
        stmt.executeUpdate();
        System.out.println("Row updated");


        int affectedRow = stmt.executeUpdate();

        if (affectedRow == 0) {
            throw new SQLException("Update failed");
        }

        return 1L;
    }
    //::::::::: DElET ENTREPRISES COMPTE
    @Override
    public boolean deleteById(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            String requete = "DELETE FROM Compte WHERE idCompte = ?";
            PreparedStatement statement = DbConnection.getConnection().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Compte Supprimé");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
