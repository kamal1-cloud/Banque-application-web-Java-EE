package ma.youcode.BanqueWebApplication.DAO.Clients;

import ma.youcode.BanqueWebApplication.Connectivity.DbConnection;
import ma.youcode.BanqueWebApplication.Modeles.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDaoImp {
    public ArrayList<Client> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<Client> clients = new ArrayList<>();
        Connection conn = DbConnection.getConnection();
        String requete = "select * from Clients";
        PreparedStatement statement = conn.prepareStatement(requete);
        ResultSet resultat = statement.executeQuery();
        while (resultat.next()) {
            Long idClient = resultat.getLong("idClient");
            String client = resultat.getString("client");

            Client c = new Client(idClient,client);
            clients.add(c);
            System.out.println(idClient + " " + client);
        }

        return clients;
    }
}
