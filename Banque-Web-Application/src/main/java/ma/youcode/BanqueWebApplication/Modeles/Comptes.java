package ma.youcode.BanqueWebApplication.Modeles;

public class Comptes extends Client{

    private Long idCompte;
    private String nom;
    private String numero;
    private Long solde;

    public Comptes(Long idClient, String client, Long idCompte, String nom, String numero, Long solde) {
        super(idClient, client);
        this.idCompte = idCompte;
        this.nom = nom;
        this.numero = numero;
        this.solde = solde;
    }

    public Comptes() {
        super();
    }

    public Long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getSolde() {
        return solde;
    }

    public void setSolde(Long solde) {
        this.solde = solde;
    }
}
