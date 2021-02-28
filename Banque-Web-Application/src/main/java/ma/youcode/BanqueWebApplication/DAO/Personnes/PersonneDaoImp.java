package ma.youcode.BanqueWebApplication.DAO.Personnes;

import ma.youcode.BanqueWebApplication.Connectivity.DbConnection;
import ma.youcode.BanqueWebApplication.Modeles.Personnes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonneDaoImp implements PersonneDAO{
    Statement statement = null;
    PreparedStatement stmt = null;
    ResultSet rst = null;
    Connection conn;

    public ArrayList<Personnes> getAll() throws ClassNotFoundException, SQLException {

        ArrayList<Personnes> personnes = new ArrayList<>();

        Connection conn = DbConnection.getConnection();

        String requete = "SELECT c.*, p.*, l.* FROM Compte c , Personnes p , Clients l WHERE l.idClient = c.idClient and c.idCompte = p.idCompte";
        PreparedStatement statement = conn.prepareStatement(requete);
        ResultSet resultat = statement.executeQuery();
        while (resultat.next()) {
            Long idClient = resultat.getLong("idClient");
            String client = resultat.getString("client");
            Long idCompte = resultat.getLong("idCompte");
            String nom = resultat.getString("nom");
            String numero = resultat.getString("numero");
            Long solde = resultat.getLong("solde");
            Long idPersonne = resultat.getLong("idPersonne");
            String prenom = resultat.getString("prenom");
            Personnes p = new Personnes(idClient,client,idCompte,nom,numero, solde,idPersonne,prenom);
            personnes.add(p);
            System.out.println(idClient+" "+ client+" "+ nom +" "+ prenom+" "+solde);
        }

        return personnes;
    }

    //::::::::::::::::: GET PERSONNE BY ID
    @Override
    public Personnes get(int id) {
        Personnes personne = null;
        try {
            personne = new Personnes();
            String requete = "SELECT c.*, p.*, l.* FROM Compte c , Personnes p , Clients l WHERE l.idClient = c.idClient and c.idCompte = p.idCompte";
            String sql = "SELECT * FROM Compte c, Personnes p where c.idCompte= p.idCompte and idCompte="+id;
            conn = DbConnection.getConnection();
            statement = conn.createStatement();
            rst = statement.executeQuery(sql);
            if(rst.next()) {
                personne.setIdPersonne(rst.getLong("id"));
                personne.setNom(rst.getString("nom"));
                personne.setPrenom(rst.getString("prenom"));
                personne.setNumero(rst.getString("numero"));
                personne.setSolde(rst.getLong("solde"));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return personne;
    }


    //::::::::::::::::::::::::::::::::::::::

    @Override
    public Long AjouterComptePer(String nom, String numero, Long solde,Long idClient ,String prenom) throws ClassNotFoundException, SQLException {

        String requete = "INSERT INTO Compte (nom,numero,solde,idClient) values (?,?,?,?)";

        conn = DbConnection.getConnection();
        stmt = conn.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, nom);
        stmt.setString(2, numero);
        stmt.setLong(3, solde);
        stmt.setLong(4, idClient);



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
            isInserted = insertIntoPersonne(conn, idCompte, prenom);
        }
        if (isInserted) return idCompte;
        else throw new SQLException("Personne account does not inseted");
    }

    private boolean insertIntoPersonne(Connection conn, Long idCompte, String prenom) throws SQLException{
        String requete;
        requete = "INSERT INTO Personnes(prenom, idCompte) values(?, ?)";

        stmt = conn.prepareStatement(requete);
        stmt.setString(1,prenom);
        stmt.setLong(2, idCompte);
        int affectedRows = stmt.executeUpdate();

        if (affectedRows == 0) {
            return false;
        }
        return true;
    }

    //::::::::::::::::: Update Personne
    @Override
    public Long updateCompte(Long idCompte, String nom, String numero, Long solde, Long idClient ,String prenom) throws ClassNotFoundException, SQLException {
        Connection conn = null;

            String query = "Update Compte set nom = ?, numero = ?, solde = ?, idClient = ? where idCompte = ?";
            stmt = DbConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, nom);
            stmt.setString(2, numero);
            stmt.setLong(3, solde);
            stmt.setLong(4, idClient);
            stmt.setLong(5, idCompte);
            stmt.executeUpdate();
            System.out.println("Row updated");

            boolean isUpdated = false;

            int affectedRow = stmt.executeUpdate();

            if (affectedRow == 0) {
                throw new SQLException("Update failed");
            }

           rst = stmt.getGeneratedKeys();
            while (rst.next()) {
                System.out.println("Update");
                isUpdated = updatePersonne(conn, idCompte,prenom);
            }

        if (isUpdated) return 1L;
        else throw new SQLException("Personne account does not Updated");
    }

    private boolean updatePersonne(Connection conn, long idCompte ,String prenom) throws SQLException{
        String query;
        query = "Update Personnes set prenom = ? where idCompte = ? ";

        stmt = DbConnection.getConnection().prepareStatement(query);
        stmt.setString(1,prenom);
        stmt.setLong(2,idCompte);
        int affectedRows = stmt.executeUpdate();

        if (affectedRows == 0) {
            return false;
        }
        return true;
    }
    //::::::::: DElET ENTREPRISES COMPTE
    @Override
    public boolean deleteById(int id) throws ClassNotFoundException, SQLException {
        try {
            String requete = "DELETE FROM Compte WHERE idCompte = ?";
            PreparedStatement statement = DbConnection.getConnection().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Compte Supprimé");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
    //:::::::::::::::: search for a comptes

    public List<Personnes> Searsh(String pattern) throws SQLException, ClassNotFoundException {
        List<Personnes> personnes = new ArrayList<>();
        String query = "SELECT * FROM Personnes, Compte WHERE Compte.idCompte= Personnes.idCompte and nom LIKE ?";

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, "%"+pattern+"%");
            rst = preparedStatement.executeQuery();
            while (rst.next()) {
                Long idClient = rst.getLong("idClient");
                Long idCompte = rst.getLong("idCompte");
                String nom = rst.getString("nom");
                String numero = rst.getString("numero");
                Long solde = rst.getLong("solde");
                Long idPersonne =rst.getLong("idPersonne");
                String prenom = rst.getString("prenom");
                Personnes p = new Personnes(idClient,idCompte,nom,numero, solde,idPersonne,prenom);
                personnes.add(p);
                System.out.println(idClient+" "+" "+ nom +" "+ prenom+" "+solde);
            }

        }
        return personnes;
    }

}
