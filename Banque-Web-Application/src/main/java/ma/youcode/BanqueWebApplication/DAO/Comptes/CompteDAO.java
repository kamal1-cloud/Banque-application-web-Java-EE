package ma.youcode.BanqueWebApplication.DAO.Comptes;

import ma.youcode.BanqueWebApplication.Modeles.Comptes;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CompteDAO {
    public ArrayList<Comptes> getAll() throws ClassNotFoundException, SQLException;

}
