package ma.youcode.BanqueWebApplication.Modeles;

public class Personnes extends Comptes{
    private Long idPersonne;
    private String prenom;

    public Personnes(Long idClient, String client, Long idCompte, String nom, String numero, Long solde, Long idPersonne, String prenom) {
        super(idClient, client, idCompte, nom, numero, solde);
        this.idPersonne = idPersonne;
        this.prenom = prenom;
    }

    public Personnes() {
        super();
    }

    public Personnes(Long idClient, Long idCompte, String nom, String numero, Long solde, Long idPersonne, String prenom) {
    }

    public Long getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Long idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
