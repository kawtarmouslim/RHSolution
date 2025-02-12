package entites;

public class User {
    private Long id;
    private  String nom;
    private  String prenom;
    private String poste;
    private int salaire;
//constructeur
    public User(Long id, String nom, String prenom, String poste, int salaire) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.salaire = salaire;
    }

    public User(String nom, String prenom, String poste, int salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.salaire = salaire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }
}
