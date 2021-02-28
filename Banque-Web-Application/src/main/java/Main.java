import ma.youcode.BanqueWebApplication.Connectivity.DbConnection;
import ma.youcode.BanqueWebApplication.DAO.Personnes.PersonneDaoImp;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        PersonneDaoImp test = new PersonneDaoImp();
        test.Searsh("kamal");
    }
}
