package ma.youcode.BanqueWebApplication.Modeles;

public class Client {
    private Long idClient;
    private String client;

    public Client(Long idClient, String client) {
        this.idClient = idClient;
        this.client = client;
    }

    public Client() {

    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
