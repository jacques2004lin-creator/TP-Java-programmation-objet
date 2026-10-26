public class Enseignantchercheur extends Enseignant {

    public Enseignantchercheur(String nom, String prenom) {
        super(nom, prenom);
    }

    public float cout() {
        float salaireFixe = 2000f * 12;
        int heuresSup = 0;

        if (this.heuresCours > 192) {
            heuresSup = this.heuresCours - 192;
        }

        return salaireFixe + (heuresSup * 40f);
    }
}