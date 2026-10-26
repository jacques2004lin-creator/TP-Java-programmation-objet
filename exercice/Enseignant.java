public class Enseignant {
    protected String nom;
    protected String prenom;
    protected int heuresCours;

    public Enseignant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.heuresCours = 0;
    }

    public void attribuerheures(int h) {
        this.heuresCours = h;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getHeuresCours() {
        return heuresCours;
    }
}
