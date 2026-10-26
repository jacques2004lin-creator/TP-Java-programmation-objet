public class Remunere extends Compte {
    private int taux;

    public Remunere(String titulaire, double soldeInitial, int taux) {
        super(titulaire, soldeInitial, "Remunere");
        this.taux = taux;
    }

    public void calculInteret() {
        this.crediter(this.getSolde() * taux);
    }
}