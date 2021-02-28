package ma.youcode.BanqueWebApplication.Modeles;

public class Entreprises extends Comptes{
    private Long idEntreprise;

    public Entreprises(Long idClient, String client, Long idCompte, String nom, String numero, Long solde, Long idEntreprise) {
        super(idClient, client, idCompte, nom, numero, solde);
        this.idEntreprise = idEntreprise;
    }

    public Long getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(Long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }
}
