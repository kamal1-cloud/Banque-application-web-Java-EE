package ma.youcode.BanqueWebApplication.DAO.Personnes;

import ma.youcode.BanqueWebApplication.Modeles.Personnes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface PersonneDAO {

    public ArrayList<Personnes> getAll() throws ClassNotFoundException, SQLException;
    public Personnes get(int id);
    public Long AjouterComptePer(String nom, String numero, Long solde,Long idClient ,String prenom) throws ClassNotFoundException, SQLException ;
    public Long updateCompte(Long idCompte,String nom, String numero, Long solde,Long idClient ,String prenom) throws ClassNotFoundException, SQLException;
    public boolean deleteById(int id) throws ClassNotFoundException, SQLException;
    public List<Personnes> Searsh(String pattern) throws SQLException, ClassNotFoundException;


}
