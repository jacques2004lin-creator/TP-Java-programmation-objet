public class Vacataire extends Enseignant {
    private String organisme;

    public Vacataire(String nom, String prenom, String organisme) {
        super(nom, prenom);
        this.organisme = organisme;
    }

    public float cout() {
        return this.heuresCours * 40f;
    }

    public String getOrganisme() {
        return organisme;
    }

    public void setOrganisme(String organisme) {
        this.organisme = organisme;
    }
}